package com.exercise.project.parkingApp.service;

import com.exercise.project.parkingApp.dto.CheckIn;
import com.exercise.project.parkingApp.dto.CheckInResponses;
import com.exercise.project.parkingApp.dto.CheckOut;
import com.exercise.project.parkingApp.dto.ParkirResponses;
import com.exercise.project.parkingApp.entity.ParkingData;
import com.exercise.project.parkingApp.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.Duration;
import java.time.LocalTime;
import java.util.Random;

@Service
public class ParkingDataService {
    @Autowired
    private ParkingRepository parkingRepository;


    private String generateCode(){
        int length = 8;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        StringBuilder randomString = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            randomString.append(randomChar);
        }
        return randomString.toString();
    }
    public int calculateParking(ParkingData parking) {
        LocalTime checkIn = parking.getCheckIn();
        LocalTime checkOut = parking.getCheckOut();
        Duration durasi = Duration.between(checkIn,checkOut);
        long minutes = durasi.toMinutes();
        int hours = (int) Math.ceil(minutes / 60.0);

        if(minutes <=5){
            return 0;
        }
        if (parking.getTypeVihicle().equals("car")) {
            return 5000 + Math.max(0, hours - 1) * 3000;
        } else if (parking.getTypeVihicle().equals("motorcycle")) {
            return 3000 + Math.max(0, hours - 1) * 2000;
        } else {
            return 0;
        }
    }

    public CheckInResponses checkIn(CheckIn checkIn){
        ParkingData parking = new ParkingData();
        String code = generateCode();
        parking.setCode(code);
        parking.setCheckIn(LocalTime.now());
        parking.setTypeVihicle(checkIn.getTypeVihicle());
        parkingRepository.save(parking);
        return CheckInResponses.builder().
                checkInTime(LocalTime.now()).
                code(code).
                typeVihicle(checkIn.getTypeVihicle()).
                build();
    }
    public ParkirResponses checkOut(CheckOut checkOut){
        ParkingData parkingData = parkingRepository.findByCode(checkOut.getCode());
        parkingData.setCheckOut(checkOut.getCheckOut());
        parkingData.setPrice(calculateParking(parkingData));
        parkingRepository.save(parkingData);
        return ParkirResponses.builder().
                checkIn(parkingData.getCheckIn()).
                trxId(parkingData.getParkingId()).
                checkOut(checkOut.getCheckOut()).
                totalPayment(calculateParking(parkingData)).
                typeVihicle(parkingData.getTypeVihicle()).
                build();
    }
}

