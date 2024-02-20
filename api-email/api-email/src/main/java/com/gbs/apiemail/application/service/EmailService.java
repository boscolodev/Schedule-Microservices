package com.gbs.apiemail.application.service;

import com.gbs.apiemail.api.dto.appointment.AppointmentResponse;
import com.gbs.apiemail.api.dto.doctor.DoctorResponse;
import com.gbs.apiemail.api.dto.email.Email;
import com.gbs.apiemail.api.dto.patient.PatientResponse;
import com.gbs.apiemail.api.feign.FeignApiUser;
import com.gbs.apiemail.application.interfaces.EmailStrategy;
import com.gbs.apiemail.application.factory.EmailStrategyFactory;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mail;
    private final FeignApiUser apiUser;
    private final EmailStrategyFactory factory;

    public void sendMail(AppointmentResponse appointmentResponse, String strategyKey) {

        try {
            mail.send(getEmail(appointmentResponse, strategyKey));
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private MimeMessage getEmail(AppointmentResponse appointmentResponse, String strategyKey) throws MessagingException {
        Email email = createEmailRecord(appointmentResponse);
        EmailStrategy strategy = factory.getStrategy(strategyKey);
        return email.createEmailMessage(mail, strategy);
    }

    private Email createEmailRecord(AppointmentResponse appointmentResponse) {
        PatientResponse patient = apiUser.findPatientById(appointmentResponse.getPatientId());
        DoctorResponse doctor = apiUser.findDoctorById(appointmentResponse.getDoctorId());
        return new Email(patient, doctor, appointmentResponse);
    }


}
