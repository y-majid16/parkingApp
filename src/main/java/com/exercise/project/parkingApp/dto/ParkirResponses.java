package com.exercise.project.parkingApp.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalTime;

@Builder
@Getter
public class ParkirResponses {

    private Integer trxId;
    private LocalTime checkIn;
    private LocalTime checkOut;
    private Integer totalPayment;
    private String typeVihicle;
}
