package com.moreira.crud_clients.services;

import com.moreira.crud_clients.dto.ClientDTO;
import com.moreira.crud_clients.entities.Client;
import com.moreira.crud_clients.repositories.ClientRepository;
import org.springframework.beans.BeanUtils;
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

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client result = clientRepository.findById(id).get();
        return new ClientDTO(result);
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto) {
        Client entity = new Client();
        copyDtoToEntity(dto, entity);
        entity = clientRepository.save(entity);
        return new ClientDTO(entity);
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO dto) {
        Client entity = clientRepository.getReferenceById(id);
        copyDtoToEntity(dto, entity);
        entity = clientRepository.save(entity);
        return new ClientDTO(entity);
    }

    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    private void copyDtoToEntity(ClientDTO dto, Client entity) {
        //BeanUtils.copyProperties(dto, entity);
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());
    }

}
