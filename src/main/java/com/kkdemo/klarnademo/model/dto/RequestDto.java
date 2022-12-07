package com.kkdemo.klarnademo.model.dto;

import com.kkdemo.klarnademo.model.enums.AninmalType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class RequestDto {

    private LocalDate requestDateBegin;
    private LocalDate requestDateEnd;
    private AninmalType aninmalType;
    private String requestDescription;
}
