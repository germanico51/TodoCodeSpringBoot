package com.proyecto.bazar.repository;

import com.proyecto.bazar.model.Cliente;
import com.proyecto.bazar.model.Venta;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IVentaRepository extends JpaRepository<Venta,Long> {
    List<Venta> findAllByFecha(LocalDate fecha);
    Optional<Venta> findFirstByOrderByTotalDesc();

}
