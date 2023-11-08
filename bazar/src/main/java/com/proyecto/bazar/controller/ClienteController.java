package com.proyecto.bazar.controller;

import com.proyecto.bazar.model.Cliente;
import com.proyecto.bazar.model.Venta;
import com.proyecto.bazar.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {
    @Autowired
    IClienteService clientService;

    @PostMapping("/clientes/crear")
    public String createClient(@RequestBody Cliente prod){
        clientService.saveClient(prod);
        return "Cliente creado correctamente.";
    }
    @GetMapping("/clientes")
    public List<Cliente> createClient(){
        return clientService.getClients();
    }

    @GetMapping("/clientes/{codigo_cliente}")
    public Cliente getCliente(@PathVariable Long codigo_cliente){
        return clientService.findClient(codigo_cliente);
    }

    @DeleteMapping("/clientes/eliminar/{codigo_cliente}")
    public String deleteClient(@PathVariable Long codigo_cliente){
        clientService.deleteClient(codigo_cliente);
        return "la venta fue eliminada";
    }

    @PutMapping("/clientes/editar/{codigo_cliente}")
    public Cliente editClient(@PathVariable Long codigo_cliente,@RequestBody Cliente cliente){
        clientService.editClient(codigo_cliente,cliente);
        return this.getCliente(codigo_cliente);
    }
}
