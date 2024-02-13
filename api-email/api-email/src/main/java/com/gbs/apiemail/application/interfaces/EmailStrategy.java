package com.gbs.apiemail.application.interfaces;

import com.gbs.apiemail.api.dto.email.Email;
import org.thymeleaf.context.Context;

public interface EmailStrategy {
    Context createContext(Email email);
    String getTemplate();
}
