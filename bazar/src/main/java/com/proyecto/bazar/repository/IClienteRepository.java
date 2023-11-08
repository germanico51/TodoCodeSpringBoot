package com.proyecto.bazar.repository;

import com.proyecto.bazar.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente,Long> {
    //Producto findByUserName(@Param("username") String username);
}
