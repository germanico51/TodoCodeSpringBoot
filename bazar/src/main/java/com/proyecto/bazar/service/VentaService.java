package com.proyecto.bazar.service;

import com.proyecto.bazar.dto.VentaClienteDTO;
import com.proyecto.bazar.model.Producto;
import com.proyecto.bazar.model.Venta;
import com.proyecto.bazar.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VentaService implements IVentaService{
    @Autowired
    IVentaRepository ventRepo;
    @Override
    public void saveVenta(Venta vent) {
         ventRepo.save(vent);
    }
    @Override
    public List<Venta> getVentas() {
        return ventRepo.findAll();
    }
    @Override
    public Venta findVenta(Long id) {
        return ventRepo.findById(id).orElse(null);
    }
    @Override
    public void deleteVenta(Long id) {
        ventRepo.deleteById(id);
    }
    @Override
    public void editVenta(Long id, Venta vent) {
        vent.setCodigo_venta(id);
        this.saveVenta(vent);
    }

    @Override
    public List<Producto> getProdsByVenta(Long codigoVenta) {
        Venta venta = this.findVenta(codigoVenta);
        if(venta!=null){
            return venta.getListaProductos();
        }
        return null;
    }

    @Override
    public Map<String, Object> getTotalVentasPorFecha(LocalDate fecha) {
        HashMap<String,Object> dtoMontoCant = new HashMap<String,Object>();
        List<Venta> ventasList = ventRepo.findAllByFecha(fecha);
        if(ventasList!=null && !ventasList.isEmpty()){
            dtoMontoCant.put("monto",ventasList.stream().map(Venta::getTotal).reduce(Double::sum));
            dtoMontoCant.put("cantidad",ventasList.size());
        }else{
            dtoMontoCant.put("monto",0);
            dtoMontoCant.put("cantidad",0);
        }
        return dtoMontoCant;
    }

    @Override
    public VentaClienteDTO getMayorVenta() {
        Venta ventaMax = ventRepo.findFirstByOrderByTotalDesc().orElse(null);
        if(ventaMax!=null){
            VentaClienteDTO vtaClientDTO = new VentaClienteDTO();
            vtaClientDTO.setCodigo_venta(ventaMax.getCodigo_venta());
            vtaClientDTO.setTotal(ventaMax.getTotal());
            vtaClientDTO.setCantProd(ventaMax.getListaProductos().size());
            vtaClientDTO.setNombreCliente(ventaMax.getUnCliente().getNombre());
            vtaClientDTO.setApellidoCliente(ventaMax.getUnCliente().getApellido());
            return vtaClientDTO;
        }
        return null;
    }


}
