package com.acme.test.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AcmeService implements IAcmeService {

	public String callApiService(String xml) {
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_XML);
		HttpEntity<String> entity = new HttpEntity<>(xml, headers);
		ResponseEntity<String> response = restTemplate.exchange(
				"https://run.mocky.io/v3/19217075-6d4e-4818-98bc-416d1feb7b84", HttpMethod.POST, entity, String.class);
		return response.getBody();
	}

}
