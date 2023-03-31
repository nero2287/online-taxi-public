package com.taxi.passenger.bean;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PassengerUser {
    private int id;
    private String passengerPhone;
    private String passengerName;
    private int passengerGender;
    private String profilePhoto;
    private int state;
    private LocalDateTime updateTime;
    private LocalDateTime createTime;
}
