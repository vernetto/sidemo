package com.example.sidemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/integrate")
public class IntegrationController {
    @Autowired
    private IntegrationGateway integrationGateyay;

    @GetMapping(value = "/{name}")
    public String getMessage(@PathVariable("name") String name) {
        return integrationGateyay.sendMessage(name);
    }

}
