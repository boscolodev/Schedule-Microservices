package com.gbs.apiemail.application.factory;

import com.gbs.apiemail.api.dto.email.Email;
import com.gbs.apiemail.application.interfaces.EmailStrategy;
import org.thymeleaf.context.Context;

public class EmailScheduleFactory implements EmailStrategy {

    private String template;

    public EmailScheduleFactory() {
        template = "schedule-template";
    }

    @Override
    public Context createContext(Email email) {
        Context context = new Context();
        context.setVariable("patientName", email.patient().name());
        context.setVariable("doctorName", email.doctor().name());
        context.setVariable("appointmentDate", email.appointment().appointmentDate());
        context.setVariable("appointmentTime", email.appointment().appointmentTime());
        context.setVariable("clinicAddress", email.doctor().address());

        return context;
    }

    @Override
    public String getTemplate() {
        return template;
    }
}
