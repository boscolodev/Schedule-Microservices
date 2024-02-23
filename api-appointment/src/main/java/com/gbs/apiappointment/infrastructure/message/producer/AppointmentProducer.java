package com.gbs.apiappointment.infrastructure.message.producer;

import com.gbs.apiappointment.api.dto.appointment.AppointmentResponse;
import com.gbs.apiappointment.shared.exceptions.ProducerException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class AppointmentProducer {

    private final KafkaTemplate<String, AppointmentResponse> kafkaTemplate;

    @Value("${topico.email-api.producer.nome}")
    private String topico;

    public void sendMail(final AppointmentResponse appointmentResponse) {
        try {
            kafkaTemplate.send(topico, appointmentResponse);
            log.warn("Nome do Tópico: {}", topico);
            log.warn("Objeto Appointment: {}",appointmentResponse);
            log.warn("Objeto Appointment Class: {}",appointmentResponse.getClass().toString());
            log.warn("Departamento: {}",appointmentResponse.getDepartment());
        } catch (Exception e) {
            e.printStackTrace();
            throw new ProducerException("Erro ao produzir mensagem do kafka");
        }
    }
}
