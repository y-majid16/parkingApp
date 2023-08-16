package com.exercise.project.parkingApp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "parking_data")
public class ParkingData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parking_id")
    private Integer parkingId;

    @Column(name = "generated_code")
    private String code;

    @Column(name = "jenis_kendaraan")
    private String typeVihicle;

    @Column(name = "Jam_masuk")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime checkIn;

    @Column(name = "jam_keluar")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime checkOut;

    private Integer price;

}
