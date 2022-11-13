package com.springBoot.profie.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("student")
public class BasicConfiguration {
    private String name;
    private String address;
    private int RollNo;

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String address() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int RollNo() {
        return RollNo;
    }

    public void setRollNo(int rollNo) {
        RollNo = rollNo;
    }
}
