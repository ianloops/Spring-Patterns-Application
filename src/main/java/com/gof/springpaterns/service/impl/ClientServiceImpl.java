package com.gof.springpaterns.service.impl;

import com.gof.springpaterns.model.Address;
import com.gof.springpaterns.model.AddressRepository;
import com.gof.springpaterns.model.Client;
import com.gof.springpaterns.model.ClientRepository;
import com.gof.springpaterns.service.ClientService;
import com.gof.springpaterns.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    //TODO Singleton: Injetar os compontentes do Spring com @Autowired
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ViaCepService viaCepService;
    //TODO Strategy: Implementar os métodos definidos na interface;
    //TODO Facade: Abstrair integrações com subsistemas, provendo uma interface simples;

    @Override
    public Iterable<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client getById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.get();
    }

    @Override
    public void insert(Client client) {
        saveClient(client);
    }

    @Override
    public void update(Long id, Client client){
        Optional<Client> clientBd = clientRepository.findById(id);
        if(clientBd.isPresent()){
            saveClient(client);
        }
    }

    @Override
    public void delete(Long id) {
        Optional<Client> clientBd = clientRepository.findById(id);
        if(clientBd.isPresent()){
            clientRepository.deleteById(clientBd.get().getId());
        }
    }

    private void saveClient(Client client) {
        String cep = client.getAddress().getCep();
        Address address = addressRepository.findById(cep).orElseGet(()->{
            Address newAddress = viaCepService.consultCep(cep);
            addressRepository.save(newAddress);
            return newAddress;
        });
        client.setAddress(address);
        clientRepository.save(client);
    }
}
