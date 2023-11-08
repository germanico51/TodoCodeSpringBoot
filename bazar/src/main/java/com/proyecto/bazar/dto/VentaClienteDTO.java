package com.proyecto.bazar.dto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class VentaClienteDTO {
    private Long codigo_venta;
    private Double total;
    private int cantProd;
    private String nombreCliente;
    private String apellidoCliente;

    public VentaClienteDTO() {
    }

    public VentaClienteDTO(Long codigo_venta, Double total, int cantProd, String nombreCliente, String apellidoCliente) {
        this.codigo_venta = codigo_venta;
        this.total = total;
        this.cantProd = cantProd;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
    }
}
