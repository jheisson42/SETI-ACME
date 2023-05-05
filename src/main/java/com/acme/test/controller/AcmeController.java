package com.acme.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acme.test.service.IAcmeService;
import com.acme.test.utils.TransformJsonToXml;
import com.acme.test.utils.TransformXmlToJson;

@CrossOrigin
@RestController
@RequestMapping(value = "acme", produces = { MediaType.APPLICATION_JSON_VALUE })
public class AcmeController {

	@Autowired
	private IAcmeService acmeService;
	@Autowired
	private TransformJsonToXml transformJsonToXml;
	@Autowired
	private TransformXmlToJson transformXmlToJson;

	@PostMapping("/enviarPedido")
	public ResponseEntity<String> enviarPedido(@RequestBody String peticion) throws Exception {

		try {
			String xmlPedido = transformJsonToXml.transformJsonToXml(peticion);
			String xmlRespuesta = acmeService.callApiService(xmlPedido);

			return ResponseEntity.status(HttpStatus.OK).body(transformXmlToJson.transformXmlToJson(xmlRespuesta));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

	}

}
