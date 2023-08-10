package com.exercise.project.parkingApp.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalTime;

@Builder
@Getter
public class CheckInResponses {
    private String code;
    private LocalTime checkInTime;
    private String typeVihicle;
}
