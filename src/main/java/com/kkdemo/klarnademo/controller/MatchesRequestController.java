package com.kkdemo.klarnademo.controller;

import com.kkdemo.klarnademo.model.MatchesRequest;
import com.kkdemo.klarnademo.model.dto.MatchesRequestDto;
import com.kkdemo.klarnademo.service.MatchesRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/matching-request")//pre-path
public class MatchesRequestController {

    @Autowired
    private MatchesRequestService matchesRequestService;


    @PostMapping
    public ResponseEntity<?> createMatchesRequest(@RequestBody MatchesRequestDto purchaseHistory)
    {
        return new ResponseEntity<>(
                matchesRequestService.createMatchesRequest(purchaseHistory),
                HttpStatus.CREATED);
    }

    @GetMapping("accepter/{accepterUserName}")
    public ResponseEntity<?> getPreviousMatchesOfAccepter(@RequestBody String accepterUserName)
    {
        return new ResponseEntity<>(
                matchesRequestService.findPreviousMatchesOfAccepter(accepterUserName),
                HttpStatus.CREATED);
    }

    @GetMapping("requester/{requesterUserName}")
    public ResponseEntity<?> getPreviousMatchesOfRequester(@RequestBody String requesterUserName)
    {
        return new ResponseEntity<>(
                matchesRequestService.findPreviousMatchesOfRequester(requesterUserName),
                HttpStatus.CREATED);
    }


}
