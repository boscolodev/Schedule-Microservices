package com.gbs.apiemail.infrastructure.message;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gbs.apiemail.api.dto.appointment.AppointmentResponse;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

public class AppointmentResponseDeserializer implements Deserializer<AppointmentResponse> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public AppointmentResponse deserialize(String topic, byte[] data) {
        try {
            return objectMapper.readValue(data, AppointmentResponse.class);
        } catch (IOException e) {
            throw new SerializationException("Error deserializing object", e);
        }
    }

}
