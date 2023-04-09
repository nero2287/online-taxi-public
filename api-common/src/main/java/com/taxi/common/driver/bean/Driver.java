package com.taxi.common.driver.bean;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Driver {
    private int id;
    private String driverAddress;
    private String certificateNo;
    private int commercialType;
    private String contractCompany;
    private LocalDate contractOff;
    private LocalDate contractOn;
    private LocalDate driverBirthday;
    private String driverContactAddress;
    private int driverGender;
    private LocalDate driverLicenseDate;
    private LocalDate driverLicenseOff;
    private LocalDate driverLicenseOn;
    private int driverNation;
    private String driverPhone;
    private int flag;
    private LocalDate getNetworkCarProofDate;
    private String licensePhotoId;
    private LocalDate networkCarIssueDate;
    private String networkCarIssueOrganization;
    private LocalDate networkCarProofOff;
    private LocalDate networkCarProofOn;
    private LocalDate registerDate;
    private int state;
    private int taxiDriver;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
