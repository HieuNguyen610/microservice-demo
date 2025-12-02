package hieu.serviceapplication.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

    @Value("${spring.application.name:ServiceApplication}")
    private String instance;

    @GetMapping("/")
    public String home() {
        return "Hello from " + instance + "!";
    }
}
