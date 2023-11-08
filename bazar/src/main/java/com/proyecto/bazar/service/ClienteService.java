package com.proyecto.bazar.service;

import com.proyecto.bazar.model.Cliente;
import com.proyecto.bazar.model.Venta;
import com.proyecto.bazar.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService{
    @Autowired
    IClienteRepository clientRepo;
    @Override
    public void saveClient(Cliente client) {
         clientRepo.save(client);
    }
    @Override
    public List<Cliente> getClients() {
        return clientRepo.findAll();
    }
    @Override
    public Cliente findClient(Long id) {
        return clientRepo.findById(id).orElse(null);
    }
    @Override
    public void deleteClient(Long id) {
        clientRepo.deleteById(id);
    }
    @Override
    public void editClient(Long id, Cliente cliente) {
        cliente.setId_cliente(id);
        this.saveClient(cliente);
    }
}
