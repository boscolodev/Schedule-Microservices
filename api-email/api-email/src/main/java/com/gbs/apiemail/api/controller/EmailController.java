package com.gbs.apiemail.api.controller;

import com.gbs.apiemail.application.service.EmailService;
import com.gbs.apiemail.api.dto.appointment.AppointmentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/emails")
@RequiredArgsConstructor
public class EmailController {

    private final EmailService service;

    @PostMapping
    public void sendEmail(@Valid @RequestBody AppointmentResponse appointmentResponse) {
        service.sendMail(appointmentResponse, appointmentResponse.getDepartment());
    }

}
