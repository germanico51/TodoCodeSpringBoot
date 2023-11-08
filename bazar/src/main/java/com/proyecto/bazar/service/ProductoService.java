package com.proyecto.bazar.service;

import com.proyecto.bazar.model.Producto;
import com.proyecto.bazar.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoService implements IProductoService{
    @Autowired
    IProductoRepository prodRepo;
    @Override
    public void saveProduct(Producto prod) {
         prodRepo.save(prod);
    }
    @Override
    public List<Producto> getProducts() {
        return prodRepo.findAll();
    }
    @Override
    public Producto findProduct(Long id) {
        return prodRepo.findById(id).orElse(null);
    }
    @Override
    public void deleteProduct(Long id) {
        prodRepo.deleteById(id);
    }
    @Override
    public void editProduct(Long id, Producto producto) {
        producto.setCodigo_producto(id);
        this.saveProduct(producto);
    }
    @Override
    public List<Producto> getLowStockProducts() {
        return this.getProducts().stream().filter(p->p.getCantidad_disponible()<5).collect(Collectors.toList());
    }
    @Override
    public boolean hayStockDeVenta(List<Producto> productoList) {
        //Ordeno la lista y hago corte de control para contar si hay suficiente
        //stock para cada producto en la lista
        productoList.sort(Comparator.comparing(Producto::getCodigo_producto));
        Long codProdAnt=null;
        int contDeProdsAVender=0;
        for (Producto prod : productoList){
            if(prod.getCodigo_producto()!=codProdAnt && codProdAnt!=null){
                contDeProdsAVender=0;
            }
            contDeProdsAVender++;
            if(contDeProdsAVender>=prod.getCantidad_disponible()) {
                return false;
            }
            codProdAnt=prod.getCodigo_producto();
        }
        return true;
    }


}
