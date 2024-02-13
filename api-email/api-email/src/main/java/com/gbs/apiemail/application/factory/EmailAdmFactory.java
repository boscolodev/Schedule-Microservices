package com.gbs.apiemail.application.factory;

import com.gbs.apiemail.api.dto.Email;
import com.gbs.apiemail.application.interfaces.EmailStrategy;
import lombok.Getter;
import org.thymeleaf.context.Context;

@Getter
public class EmailAdmFactory implements EmailStrategy {

    private String template;

    public EmailAdmFactory() {
        template = "adm-template";
    }

    @Override
    public Context createContext(Email email) {
        Context context = new Context();
        context.setVariable("patientName", email.patient().name());
        context.setVariable("doctorName", email.doctor().name());
        return context;
    }

    @Override
    public String getTemplate() {
        return template;
    }
}
