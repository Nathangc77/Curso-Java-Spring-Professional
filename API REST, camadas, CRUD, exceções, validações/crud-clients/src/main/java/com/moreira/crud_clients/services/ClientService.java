package com.moreira.crud_clients.services;

import com.moreira.crud_clients.dto.ClientDTO;
import com.moreira.crud_clients.entities.Client;
import com.moreira.crud_clients.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
       Page<Client> clients = clientRepository.findAll(pageable);
       return clients.map(x -> new ClientDTO(x));
    }
}
