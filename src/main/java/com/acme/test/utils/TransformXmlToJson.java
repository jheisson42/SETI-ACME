package com.acme.test.utils;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Component;

import com.acme.test.config.response.Envelope;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class TransformXmlToJson {
	
	public String transformXmlToJson(String xml) throws JAXBException, JsonProcessingException {

		JAXBContext jaxbContext = JAXBContext.newInstance(Envelope.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		Envelope envelope = (Envelope) unmarshaller.unmarshal(new StringReader(xml));

		ObjectMapper objectMapper = new ObjectMapper();
		String jsonResponse = objectMapper
				.writeValueAsString(envelope.getBody().getEnvioPedidoAcmeResponse().getEnvioPedidoResponse());

		return jsonResponse;

	}
}
