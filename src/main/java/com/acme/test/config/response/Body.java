package com.acme.test.config.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

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
public class Body {
    @XmlElement(name = "EnvioPedidoAcmeResponse", namespace = "http://WSDLs/EnvioPedidos/EnvioPedidosAcme")
    private EnvioPedidoAcmeResponse envioPedidoAcmeResponse;

}
