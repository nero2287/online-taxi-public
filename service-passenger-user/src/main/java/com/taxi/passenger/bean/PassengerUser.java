package com.taxi.passenger.bean;

import lombok.Data;

@Data
public class PassengerUser {
    private int id;
    private String passengerPhone;
    private String passengerName;
    private String passengerGender;
    private int state;
    private String updateTime;
}
