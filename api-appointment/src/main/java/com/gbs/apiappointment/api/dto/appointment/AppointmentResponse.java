package com.gbs.apiappointment.api.dto.appointment;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AppointmentResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @NotNull(message = "Doctor required")
    private Long doctorId;

    @NotNull(message = "Patient required")
    private Long patientId;

//    @JsonSerialize(using = DateSerializer.class)
//    @JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
//    @NotNull(message = "Date required")
//    private Date appointmentDate;

    @NotNull(message = "Time required")
    private Long appointmentTime;

    @NotEmpty(message = "Department required")
    private String department;

}

