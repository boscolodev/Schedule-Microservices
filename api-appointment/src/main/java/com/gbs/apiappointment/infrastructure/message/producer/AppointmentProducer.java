package com.gbs.apiappointment.infrastructure.message.producer;

import com.gbs.apiappointment.api.dto.appointment.AppointmentResponse;
import com.gbs.apiappointment.shared.exceptions.ProducerException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaProducerException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AppointmentProducer {

    private final KafkaTemplate<String, AppointmentResponse> kafkaTemplate;


    @Value("${topico.email-api.producer.nome}")
    private String topico;

    public void sendMail(final AppointmentResponse appointmentResponse){
        try {
            kafkaTemplate.send(topico, appointmentResponse);
        }catch (Exception e){
            throw new ProducerException("Erro ao produzir mensagem do kafka");
        }
    }
}
