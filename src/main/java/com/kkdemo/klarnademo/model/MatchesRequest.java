package com.kkdemo.klarnademo.model;

import com.kkdemo.klarnademo.model.enums.RequestStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "matches_request")
public class MatchesRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="user_id", nullable = false)
    private Long requesterId;

    @Column(name="book_id", nullable = false)
    private Long helperId;

    @Column(name="create_time", nullable = false)
    private LocalDate createTime;

    @Column(name="request_status", nullable = false)
    private RequestStatus requestStatus;

}
