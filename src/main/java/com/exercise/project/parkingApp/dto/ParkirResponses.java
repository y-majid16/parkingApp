package com.exercise.project.parkingApp.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;


@Builder
@Getter
public class ParkirResponses {

    private Integer trxId;
    private String code;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private Integer totalPayment;
    private String typeVihicle;
}
