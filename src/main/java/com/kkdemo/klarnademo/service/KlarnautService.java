package com.kkdemo.klarnademo.service;

import com.kkdemo.klarnademo.exception.NoKlarnautFoundException;
import com.kkdemo.klarnademo.model.Klarnaut;
import com.kkdemo.klarnademo.model.dto.RequestDto;
import com.kkdemo.klarnademo.model.enums.Role;
import com.kkdemo.klarnademo.repository.KlarnautRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class KlarnautService {
    private final KlarnautRepository klarnautRepository;
//    private final PasswordEncoder passwordEncoder;

    public Klarnaut saveKlarnaut(Klarnaut klarnaut){
//        klarnaut.setPassword(passwordEncoder.encode(klarnaut.getPassword()));

        return klarnautRepository.save(klarnaut);
    }

    public Optional<Klarnaut> findByUsername(String userName){
        return klarnautRepository.findByUserName(userName);
    }

    public Optional<Klarnaut> findById(long id){
        return klarnautRepository.findById(id);
    }

    public void makeAdmin(String userName){
        Klarnaut klarnaut = klarnautRepository.findByUserName(userName)
                .orElseThrow(() -> new NoKlarnautFoundException("not found"));
        klarnautRepository.save(klarnaut);
    }

    public List<Klarnaut> findAvailableKlarnauts(RequestDto requestDto) {
        return klarnautRepository.findByAccepterDateBeginIsLessThanEqualAndAccepterDateEndGreaterThanEqualAndAcceptedAnimalsContains(
                requestDto.getRequestDateBegin(),
                requestDto.getRequestDateEnd(),
                requestDto.getAninmalType());
    }

    public List<Klarnaut> findAvailableKlarnauts2(RequestDto requestDto) {
        return klarnautRepository.findByAccepterDateBeginIsLessThanEqualAndAccepterDateEndGreaterThanEqual(
                requestDto.getRequestDateBegin(),
                requestDto.getRequestDateEnd());
    }

    public List<Klarnaut> findAllKlarnauts() {
        return klarnautRepository.findAll();
    }
}
