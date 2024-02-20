package com.gbs.apiemail.infrastructure.message;

import com.gbs.apiemail.api.dto.appointment.AppointmentResponse;
import com.gbs.apiemail.application.service.EmailService;
import com.gbs.apiemail.shared.exceptions.ConsumerException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
@Slf4j
public class EmailApiConsumer {

    private final EmailService service;

    @KafkaListener(topics = "${topico.email-api.consumer.nome}", groupId = "${topico.email-api.consumer.group-id}")
    public void consumerProducerEmail(AppointmentResponse appointmentResponse) {
        try {
            String department = appointmentResponse.getDepartment();
            service.sendMail(appointmentResponse, department);
        } catch (Exception e) {
            throw new ConsumerException(String.format("Erro ao consumir mensagem do Kafka %s", e.getMessage()));
        }
    }
}
