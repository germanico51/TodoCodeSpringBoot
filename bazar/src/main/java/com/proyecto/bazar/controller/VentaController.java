package com.proyecto.bazar.controller;

import com.proyecto.bazar.dto.VentaClienteDTO;
import com.proyecto.bazar.model.Producto;
import com.proyecto.bazar.model.Venta;
import com.proyecto.bazar.service.IProductoService;
import com.proyecto.bazar.service.IVentaService;
import com.proyecto.bazar.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class VentaController {
    @Autowired
    IVentaService ventService;

    @Autowired
    IProductoService productoService;

    @PostMapping("/ventas/crear")
    public String createVent(@RequestBody Venta venta){
        List<Producto> productoList = venta.getListaProductos();
//        if(productoList!=null &&  productoService.hayStockDeVenta(productoList)){
            for (Producto prod : productoList) {
//                prod.setCantidad_disponible(prod.getCantidad_disponible() - 1);
//                productoService.editProduct(prod.getCodigo_producto(), prod);
                ventService.saveVenta(venta);
            }
//        }else{
//            return "Error. Productos no disponibles.";
//        }
        return "Venta creada correctamente.";
    }
    @GetMapping("/ventas")
    public List<Venta> getVentas(){
        return ventService.getVentas();
    }

    @GetMapping("/ventas/{codigo_venta}")
    public Venta getVent(@PathVariable Long codigo_venta){
        return ventService.findVenta(codigo_venta);
    }

    @DeleteMapping("/ventas/eliminar/{codigo_venta}")
    public String deleteVent(@PathVariable Long codigo_venta){
        ventService.deleteVenta(codigo_venta);
        return "la venta fue eliminada";
    }
    @PutMapping("/ventas/editar/{codigo_venta}")
    public Venta editVent(@PathVariable Long codigo_venta,@RequestBody Venta venta){
        ventService.editVenta(codigo_venta,venta);
        return this.getVent(codigo_venta);
    }

    // Obtener la lista de productos de una determinada venta
    @GetMapping("/ventas/productos/{codigo_venta}")
    public List<Producto> getProductosPorVenta(@PathVariable Long codigo_venta){
        return ventService.getProdsByVenta(codigo_venta);
    }

    //Obtener la sumatoria del monto y también cantidad total de ventas de un determinado día
    @GetMapping("/ventas/total/{fecha_venta}")
    public Map<String,Object> getTotalVentasPorFecha(@PathVariable LocalDate fecha_venta){
        return ventService.getTotalVentasPorFecha(fecha_venta);
    }

    @GetMapping("/ventas/mayor_venta")
    public VentaClienteDTO getMayorVenta(){
        return ventService.getMayorVenta();
    }



}
