package com.envelo.boredapi.controllers;

import com.envelo.boredapi.model.Activity;
import com.envelo.boredapi.services.BoredService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BoredController {

    private final BoredService boredService;

    @GetMapping("/activities/random")
    public Activity getRandomActivity() {

        return boredService.getRandomActivity();
    }
}
