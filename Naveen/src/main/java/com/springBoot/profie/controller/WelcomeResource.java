package com.springBoot.profie.controller;

import com.springBoot.profie.model.BasicConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController

public class WelcomeResource {
    @Value("${welcome.message}")
    private String welcomemsg;

    @GetMapping("/welcome")
    public String retrieveWelcomeMessage() {
        return welcomemsg;
    }

    @Autowired
    private BasicConfiguration configuration;

    @RequestMapping("/student-info")
    public Map StudentDetials() {
        // Not the best practice to use a map to store differnt types!
        Map map = new HashMap();
        map.put("name", configuration.name());
        map.put("address", configuration.address());
        map.put("key", configuration.RollNo());
        return map;
    }
}
