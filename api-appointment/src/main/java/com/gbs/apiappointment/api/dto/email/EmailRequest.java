package com.gbs.apiappointment.api.dto.email;

import com.gbs.apiappointment.api.dto.appointment.AppointmentRequest;
import com.gbs.apiappointment.api.dto.doctor.DoctorResponse;
import com.gbs.apiappointment.api.dto.patient.PatientRequest;
import jakarta.validation.Valid;

public record EmailRequest(

        @Valid AppointmentRequest appointmentRequest,
        @Valid DoctorResponse doctorResponse,
        @Valid PatientRequest patientRequest
        ) {
}

