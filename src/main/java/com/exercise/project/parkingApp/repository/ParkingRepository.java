package com.exercise.project.parkingApp.repository;

import com.exercise.project.parkingApp.entity.ParkingData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends JpaRepository<ParkingData, Integer> {
    ParkingData findByCode(String code);
}
