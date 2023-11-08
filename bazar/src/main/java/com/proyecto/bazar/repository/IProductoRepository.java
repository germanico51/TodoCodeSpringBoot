package com.proyecto.bazar.repository;

import com.proyecto.bazar.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<Producto,Long> {
    //Producto findByUserName(@Param("username") String username);
}
