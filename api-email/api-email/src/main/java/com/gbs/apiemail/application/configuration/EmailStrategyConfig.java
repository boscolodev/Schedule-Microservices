package com.gbs.apiemail.application.configuration;

import com.gbs.apiemail.application.factory.EmailAdmFactory;
import com.gbs.apiemail.application.factory.EmailScheduleFactory;
import com.gbs.apiemail.application.factory.EmailStrategyFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailStrategyConfig {

    @Bean
    public EmailStrategyFactory emailStrategyFactory() {
        EmailStrategyFactory factory = new EmailStrategyFactory();
        factory.addStrategy("schedule", new EmailScheduleFactory());
        factory.addStrategy("adm", new EmailAdmFactory());
        return factory;
    }
}
