package com.kkdemo.klarnademo.service;

import com.kkdemo.klarnademo.exception.NoKlarnautFoundException;
import com.kkdemo.klarnademo.exception.RequestCoulndtCreatedException;
import com.kkdemo.klarnademo.model.Klarnaut;
import com.kkdemo.klarnademo.model.MatchesRequest;
import com.kkdemo.klarnademo.model.dto.MatchesRequestDto;
import com.kkdemo.klarnademo.model.enums.RequestStatus;
import com.kkdemo.klarnademo.repository.KlarnautRepository;
import com.kkdemo.klarnademo.repository.MatchesRequestRepository;
import com.kkdemo.klarnademo.smsConfig.SmsRequest;
import com.kkdemo.klarnademo.smsConfig.SmsService;
import com.twilio.exception.ApiException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MatchesRequestService {
    private final MatchesRequestRepository matchesRequestRepository;
    private final KlarnautService klarnautService;
    private final SmsService smsService;

    public MatchesRequest createMatchesRequest(MatchesRequestDto matchesRequestDto){
        Klarnaut accepterKlarnaut = klarnautService.findByUsername(matchesRequestDto.getNameOfAccepter())
                .orElseThrow(() -> new NoKlarnautFoundException("couldnt find accepter"));
        Klarnaut requesterKlarnaut = klarnautService.findByUsername(matchesRequestDto.getNameOfRequester())
                .orElseThrow(() -> new NoKlarnautFoundException("shit happened"));

        try {
            sendSMS(matchesRequestDto, accepterKlarnaut);
        }catch (ApiException e){
            throw new RequestCoulndtCreatedException("probably error is on sms side");
        }

        MatchesRequest matchesRequest = MatchesRequest.builder()
                .createTime(LocalDate.now())
                .requestStatus(RequestStatus.WAITING)
                .requesterId(requesterKlarnaut.getId())
                .helperId(accepterKlarnaut.getId())
                .build();
        return this.matchesRequestRepository.save(matchesRequest);
    }

    public List<MatchesRequest> findPreviousMatchesOfAccepter(String userName){
        Long accepterId = klarnautService.findByUsername(userName)
                .map(Klarnaut::getId)
                .orElseThrow(() -> new NoKlarnautFoundException("not found"));
        return matchesRequestRepository.findAllByHelperId(accepterId);
    }

    public List<MatchesRequest> findPreviousMatchesOfRequester(String userName){
        Long requesterId = klarnautService.findByUsername(userName)
                .map(Klarnaut::getId)
                .orElseThrow(() -> new NoKlarnautFoundException("not found"));
        return matchesRequestRepository.findAllByRequesterId(requesterId);
    }

    private void sendSMS(MatchesRequestDto matchesRequestDto, Klarnaut accepterKlarnaut) {
        try{smsService.sendSms(
                new SmsRequest(
                        accepterKlarnaut.getPhoneNumber(),
                        matchesRequestDto.getRequestSmsMessage()
                ));
            System.out.println("SMS Notification has been sent. KLARNA SSO");
        }
        catch (ApiException e){
            System.err.println(e.getMessage());
            System.err.print("Your message is:"+matchesRequestDto.getRequestSmsMessage());
            throw e;
        }

    }
}
