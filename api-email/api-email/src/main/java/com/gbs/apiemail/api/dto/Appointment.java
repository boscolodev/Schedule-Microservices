package com.gbs.apiemail.api.dto;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record Appointment(
        @NotNull(message = "Doctor required") Long doctorId,
        @NotNull(message = "Patient required") Long patientId,
        @NotNull(message = "Date required") Date appointmentDate,
        @NotNull(message = "Time required")  Long appointmentTime,
        @NotNull(message = "Department required") String department
) {
}
