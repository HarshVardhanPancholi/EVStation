package com.electric.demo.model.entity;

import javax.persistence.*;

@Entity
public class Station{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "station_id")
    private Long stationId;

    @Column(name = "station_name")
    private String stationName;
    @Column(name = "station_image")
    private String stationImage;
    @Column(name = "station_pricing")
    private Double stationPricing;
    @Column(name = "station_address")
    private String stationAddress;


}