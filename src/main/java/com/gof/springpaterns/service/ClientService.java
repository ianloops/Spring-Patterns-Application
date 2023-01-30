package com.gof.springpaterns.service;

import com.gof.springpaterns.model.Client;

/**
 * Interface que define o padrão <b>Strategy</b> no domínio do cliente.
 * Com isso, se necessário, podemos ter multiplas implementações dessa mesma interface.
 * */
public interface ClientService {
    Iterable<Client> getAll();
    Client getById(Long id);
    void insert(Client client);
    void update(Long id, Client client);
    void delete(Long id);

}
