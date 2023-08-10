package com.exercise.project.parkingApp.controller;

import com.exercise.project.parkingApp.dto.CheckIn;
import com.exercise.project.parkingApp.dto.CheckInResponses;
import com.exercise.project.parkingApp.dto.CheckOut;
import com.exercise.project.parkingApp.dto.ParkirResponses;
import com.exercise.project.parkingApp.service.ParkingDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ParkingController {

    @Autowired
    private ParkingDataService parkingDataService;
    @PostMapping("/check-in/")
    public ResponseEntity<CheckInResponses> checkIn(@RequestBody CheckIn checkIn) {
        return ResponseEntity.ok(parkingDataService.checkIn(checkIn));
    }
    @PostMapping("/check-out/")
    public ResponseEntity<ParkirResponses> checkOut(@RequestBody CheckOut checkOut) {
        return ResponseEntity.ok(parkingDataService.checkOut(checkOut));
    }

}
