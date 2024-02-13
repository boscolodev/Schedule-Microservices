package com.gbs.apiemail.application.service;

import com.gbs.apiemail.api.dto.appointment.Appointment;
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

    public void sendMail(Appointment appointment, String strategyKey) {

        try {
            mail.send(getEmail(appointment, strategyKey));
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private MimeMessage getEmail(Appointment appointment, String strategyKey) throws MessagingException {
        Email email = createEmailRecord(appointment);
        EmailStrategy strategy = factory.getStrategy(strategyKey);
        return email.createEmailMessage(mail, strategy);
    }

    private Email createEmailRecord(Appointment appointment) {
        PatientResponse patient = apiUser.findPatientById(appointment.patientId());
        DoctorResponse doctor = apiUser.findDoctorById(appointment.doctorId());
        return new Email(patient, doctor, appointment);
    }


}
