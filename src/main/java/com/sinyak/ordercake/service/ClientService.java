package com.sinyak.ordercake.service;

import com.sinyak.ordercake.entity.Client;
import com.sinyak.ordercake.repositories.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional
    public List<Client> findAll(){
        return clientRepository.findAll();
    }
}
