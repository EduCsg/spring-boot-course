package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api/v1")
public class FunRestController {

    // expose "/" that returns "Hello, world!"
    @GetMapping("/")
    public String sayHello() {
        return "Hello, world!";
    }

    // Expose a new endpoint for "workout"
    @GetMapping("/workout")
    public String getDalyWorkout() {
        return "Run a hard 5k!";
    }

    // Expose a new endpoint for "fortune"
    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Today is your luck day.";
    }
}