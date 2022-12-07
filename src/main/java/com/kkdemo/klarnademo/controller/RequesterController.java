package com.kkdemo.klarnademo.controller;

import com.kkdemo.klarnademo.model.Klarnaut;
import com.kkdemo.klarnademo.model.dto.RequestDto;
import com.kkdemo.klarnademo.service.KlarnautService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/request")//pre-path
public class RequesterController {

    @Autowired
    private KlarnautService klarnautService;

    @GetMapping("/1")
    public ResponseEntity<List<Klarnaut>> getAvailableKlarnauts(@RequestBody RequestDto requestDto){
        return new ResponseEntity<> (
                klarnautService.findAvailableKlarnauts(requestDto),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/2")
    public ResponseEntity<List<Klarnaut>> getAvailableKlarnauts2(@RequestBody RequestDto requestDto){
        return new ResponseEntity<> (
                klarnautService.findAvailableKlarnauts2(requestDto),
                HttpStatus.CREATED
        );
    }
}
