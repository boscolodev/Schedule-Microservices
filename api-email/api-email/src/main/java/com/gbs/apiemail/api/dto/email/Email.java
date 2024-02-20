package com.gbs.apiemail.api.dto.email;

import com.gbs.apiemail.api.dto.appointment.AppointmentResponse;
import com.gbs.apiemail.api.dto.doctor.DoctorResponse;
import com.gbs.apiemail.api.dto.patient.PatientResponse;
import com.gbs.apiemail.application.interfaces.EmailStrategy;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;


@Slf4j
public record Email(@Valid PatientResponse patient,
                    @Valid DoctorResponse doctor,
                    @Valid AppointmentResponse appointmentResponse
) {
    private String createEmailBody(EmailStrategy strategy){

        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);

        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);

        return templateEngine.process(strategy.getTemplate(), strategy.createContext(this));
    }

    public MimeMessage createEmailMessage(JavaMailSender mailSender, EmailStrategy strategy) throws MessagingException {

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(doctor.email());
        helper.setTo(patient.email());
        helper.setSubject("Confirmação Agenda de Consulta - Medic Schedule");
        helper.setText(createEmailBody(strategy), true);

        return message;
    }

}

