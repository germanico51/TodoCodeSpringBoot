package com.proyecto.bazar.service;

import com.proyecto.bazar.model.Producto;

import java.util.List;

public interface IProductoService {
     void saveProduct(Producto prod);
     List<Producto> getProducts();
     Producto findProduct(Long id);
     void deleteProduct(Long id);
     void editProduct(Long id, Producto prod);
     List<Producto> getLowStockProducts();

     boolean hayStockDeVenta(List<Producto> productoList);
}
