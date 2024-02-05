package com.gbs.apiappointment.api.dto.appointment;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record AppointmentResponse(
        @NotNull(message = "ID required") Long id,
        Long doctorId,
        Long patientId,
        @NotNull(message = "Date required") Date appointmentDate,
        @NotNull(message = "Time required")  Long appointmentTime
) {
}
