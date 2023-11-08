package com.proyecto.bazar.controller;

import com.proyecto.bazar.model.Producto;
import com.proyecto.bazar.model.Venta;
import com.proyecto.bazar.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductoController {
    @Autowired
    IProductoService prodService;

    @PostMapping("/productos/crear")
    public String createProduct(@RequestBody Producto prod){
        prodService.saveProduct(prod);
        return "Producto creado correctamente.";
    }
    @GetMapping("/productos")
    public List<Producto> createProduct(){
        return prodService.getProducts();
    }

    @GetMapping("/productos/{codigo_producto}")
    public Producto getProduct(@PathVariable Long codigo_producto){
        return prodService.findProduct(codigo_producto);
    }

    @DeleteMapping("/productos/eliminar/{codigo_producto}")
    public String deleteProduct(@PathVariable Long codigo_producto){
        prodService.deleteProduct(codigo_producto);
        return "El producto fue eliminado";
    }
    @PutMapping("/productos/editar/{codigo_producto}")
    public Producto editProd(@PathVariable Long codigo_producto,@RequestBody Producto producto){
        prodService.editProduct(codigo_producto,producto);
        return this.getProduct(codigo_producto);
    }

    //Obtener todos los productos cuya cantidad_disponible sea menor a 5
    @GetMapping("/productos/falta_stock")
    public List<Producto> getProdsBajoStock(){
        return prodService.getLowStockProducts();
    }

}
