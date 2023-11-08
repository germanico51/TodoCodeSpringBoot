package com.proyecto.bazar.service;

import com.proyecto.bazar.model.Cliente;

import java.util.List;

public interface IClienteService {
     void saveClient(Cliente client);
     List<Cliente> getClients();
     Cliente findClient(Long id);
     void deleteClient(Long id);
     void editClient(Long id, Cliente cliente);

}
