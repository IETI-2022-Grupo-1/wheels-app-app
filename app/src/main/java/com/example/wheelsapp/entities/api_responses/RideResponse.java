package com.example.wheelsapp.entities.api_responses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

public class RideResponse {
    private String id;
    private String idDriver;
    private String idCar = "JKL 256";
    private Date journeyDate;
    private Date departureHour;
    private Date arrivalHour;
    private ArrayList<String> route = new ArrayList<String>(Arrays.asList("stop 1", "stop 2", "stop 3"));
    private Integer availableSeats = 3;
    private Integer seatsReserved;
    private Boolean isActive = true;
    private Boolean hasStarted;
    private Integer code;
    private ArrayList<String> passengerList;
    private HashMap<String, String> stopsList;
    private String title = "Trayecto a Los Andes";
}
