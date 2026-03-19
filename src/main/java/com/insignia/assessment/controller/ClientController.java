package com.insignia.assessment.controller;

import com.insignia.assessment.model.*;
import com.insignia.assessment.service.ClientService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService service) {
        this.clientService = service;
    }

    @PostMapping
    public Client save(@RequestBody ClientRequest req) {
        return clientService.save(req);
    }
}
