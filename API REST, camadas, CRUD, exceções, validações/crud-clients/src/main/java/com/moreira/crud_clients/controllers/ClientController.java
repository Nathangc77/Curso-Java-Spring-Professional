package com.moreira.crud_clients.controllers;

import com.moreira.crud_clients.dto.ClientDTO;
import com.moreira.crud_clients.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public Page<ClientDTO> findAll(Pageable page) {
        return clientService.findAll(page);
    }
}
