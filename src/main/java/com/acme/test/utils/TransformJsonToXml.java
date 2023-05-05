package com.acme.test.utils;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.stereotype.Component;

import com.acme.test.request.EnvioPedidoAcme;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class TransformJsonToXml {

	public String transformJsonToXml(String peticion) throws JsonProcessingException, JAXBException {

		ObjectMapper mapper = new ObjectMapper();
		EnvioPedidoAcme pedido = mapper.readValue(peticion, EnvioPedidoAcme.class);

		JAXBContext jaxbContext = JAXBContext.newInstance(EnvioPedidoAcme.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		StringWriter sw = new StringWriter();
		marshaller.marshal(pedido, sw);
		return sw.toString();

	}
}
