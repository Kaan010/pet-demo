package com.kkdemo.klarnademo.model.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class MatchesRequestDto {
    String nameOfRequester;
    String nameOfAccepter;
    String requestSmsMessage;
}
