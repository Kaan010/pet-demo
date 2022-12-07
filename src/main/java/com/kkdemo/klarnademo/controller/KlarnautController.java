package com.kkdemo.klarnademo.controller;

import com.kkdemo.klarnademo.model.Klarnaut;
import com.kkdemo.klarnademo.model.dto.RequestDto;
import com.kkdemo.klarnademo.service.KlarnautService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/authentication")//pre-path
public class KlarnautController {

    @Autowired
    private KlarnautService klarnautService;

    @PostMapping("sign-up") //api/authentication/sign-up
    public ResponseEntity<?> signUp(@RequestBody Klarnaut klarnaut)
    {
        if (klarnautService.findByUsername(klarnaut.getUserName()).isPresent())
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(klarnautService.saveKlarnaut(klarnaut), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Klarnaut>> getAvailableKlarnauts(){
        return new ResponseEntity<> (
                klarnautService.findAllKlarnauts(),
                HttpStatus.CREATED
        );
    }

}
