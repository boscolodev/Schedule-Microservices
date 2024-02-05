package com.gbs.apiappointment.api.dto.appointment;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record AppointmentRequest(
        @NotNull(message = "Doctor required") Long doctorId,
        @NotNull(message = "Patient required") Long patientId,
        @NotNull(message = "Date required") Date appointmentDate,
        @NotNull(message = "Time required")  Long appointmentTime
) {
}
