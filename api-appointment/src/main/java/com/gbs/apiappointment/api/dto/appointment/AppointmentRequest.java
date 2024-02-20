package com.gbs.apiappointment.api.dto.appointment;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AppointmentRequest implements Serializable {


    @Serial
    private static final long serialVersionUID = 1L;

    @NotNull(message = "Doctor required")
    private Long doctorId;

    @NotNull(message = "Patient required")
    private Long patientId;

    @NotNull(message = "Date required")
    private Date appointmentDate;

    @NotNull(message = "Time required")
    private Long appointmentTime;

    @NotEmpty(message = "Department required")
    private String department;

}
