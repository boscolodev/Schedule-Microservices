package com.gbs.apiemail.infrastructure.message;

import com.gbs.apiemail.api.dto.appointment.Appointment;
import com.gbs.apiemail.application.service.EmailService;
import com.gbs.apiemail.shared.exceptions.ConsumerException;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class EmailApiConsumer {

    private final EmailService service;

    @KafkaListener(topics = "${topico.email-api.consumer.nome}", groupId = "${topico.email-api.consumer.group-id}")
    public void consumerProducerEmail(Appointment appointment, String department){
        try{
            service.sendMail(appointment, department);
        }catch (Exception e){
            throw new ConsumerException("Erro ao consumer mensagem do kafka");
        }

    }

}
