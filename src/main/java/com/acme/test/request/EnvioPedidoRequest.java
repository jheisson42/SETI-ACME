package com.acme.test.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EnvioPedidoRequest")
public class EnvioPedidoRequest {

	@XmlElement(name = "pedido")
    private String numPedido;

    @XmlElement(name = "Cantidad")
    private String cantidadPedido;

    @XmlElement(name = "EAN")
    private String codigoEAN;

    @XmlElement(name = "Producto")
    private String nombreProducto;

    @XmlElement(name = "Cedula")
    private String numDocumento;

    @XmlElement(name = "Direccion")
    private String direccion;

}
