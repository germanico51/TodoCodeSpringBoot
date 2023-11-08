package com.proyecto.bazar.service;

import com.proyecto.bazar.dto.VentaClienteDTO;
import com.proyecto.bazar.model.Producto;
import com.proyecto.bazar.model.Venta;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface IVentaService {
     void saveVenta(Venta vent);
     List<Venta> getVentas();
     Venta findVenta(Long id);
     void deleteVenta(Long id);
     void editVenta(Long id, Venta vent);

     List<Producto> getProdsByVenta(Long codigoVenta);

     Map<String,Object> getTotalVentasPorFecha(LocalDate fechaVenta);

     VentaClienteDTO getMayorVenta();
}
