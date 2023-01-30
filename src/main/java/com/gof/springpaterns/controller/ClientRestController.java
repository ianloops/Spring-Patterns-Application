package com.gof.springpaterns.controller;


import com.gof.springpaterns.model.Client;
import com.gof.springpaterns.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Esse {@link RestController} representa nossa <b>Facade</b>, pois abstrai
 * a complexidade de integrações (Banco de Dados H2 e API do viaCEP)
 * */

@RestController
@RequestMapping("clients")
public class ClientRestController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<Iterable<Client>> getAll(){
        return ResponseEntity.ok(clientService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getById(@PathVariable Long id){
        return ResponseEntity.ok(clientService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Client> insert(@RequestBody Client client){
        clientService.insert(client);
        return ResponseEntity.ok(client);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client client){
        clientService.update(id, client);
        return ResponseEntity.ok(client);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        clientService.delete(id);
        return ResponseEntity.ok().build();
    }
}
