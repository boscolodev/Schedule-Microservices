package com.gbs.apiuser.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.gbs.apiuser.api.dto.address.AddressResponse;
import com.gbs.apiuser.api.dto.ApiError;
import com.gbs.apiuser.shared.exceptions.RestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


@Service
@Slf4j
public class RestApi {

    private final RestTemplate restTemplate;

    public RestApi(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    private static final ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .registerModule(new ParameterNamesModule())
                .registerModule(new Jdk8Module())
                .registerModule(new JavaTimeModule())
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);


    public AddressResponse findCep(final String cep) {
        String url = "http://localhost:8090/address/{cep}";

        try {
            return restTemplate.getForObject(url, AddressResponse.class, cep);
        } catch (HttpStatusCodeException e) {
            ApiError apiError = null;
            String responseBody = e.getResponseBodyAsString();
            
            try {
                apiError = objectMapper.readValue(responseBody, ApiError.class);
                apiError.setPath(url.replace("{cep}",cep));
            } catch (JsonProcessingException je) {
                e.printStackTrace();
            }

            throw new RestException(apiError);

        } catch (RestClientException e) {
            throw new RestClientException(e.getMessage());
        }


    }
}