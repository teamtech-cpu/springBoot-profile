package com.springBoot.profie.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@ConfigurationProperties(prefix = "employee")
@Configuration
//@PropertySource("classpath:employees.properties")
@PropertySources({
        @PropertySource("classpath:employees.properties"),
        @PropertySource("file:\\C:\\Users\\vinod kumar reddy\\Downloads\\handson\\emplyee.properties")
})
public class Employee {
    private String name;
    private String role;
    private Integer id;
    private String email;
    private String detias;

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String role() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer id() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String email() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String detias() {
        return detias;
    }

    public void setDetias(String detias) {
        this.detias = detias;
    }
}
