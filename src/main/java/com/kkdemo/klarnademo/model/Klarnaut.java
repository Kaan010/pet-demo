package com.kkdemo.klarnademo.model;

import com.kkdemo.klarnademo.model.enums.AninmalType;
import com.kkdemo.klarnademo.model.enums.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "klarnaut")
public class Klarnaut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name",nullable = false)
    private String userName;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "phone_number",nullable = false)
    private String phoneNumber;

    //FOR accepter
    @Column(name = "accepter_date_begin",nullable = false)
    private LocalDate accepterDateBegin;

    @Column(name = "accepter_date_end",nullable = false)
    private LocalDate accepterDateEnd;

    @ElementCollection
    @Column(name = "accepted_animals")
    private List<AninmalType> acceptedAnimals;

    @Column(name = "accepter_description",nullable = false)
    private String accepterDescription;

}
