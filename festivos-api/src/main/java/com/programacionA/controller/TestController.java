package com.programacionA.festivos_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/hola")
    public String hola() {
        return "API funcionando 🔥";
    }
}