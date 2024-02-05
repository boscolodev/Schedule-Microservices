package com.gbs.apiappointment.application.usecase;

import com.gbs.apiappointment.api.dto.appointment.AppointmentRequest;
import com.gbs.apiappointment.api.dto.appointment.AppointmentResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;

@Validated
public interface AppointmentService {

    AppointmentResponse findById(final Long id);

    Page<AppointmentResponse> findAll(Pageable pageable);
    void delete(final Long id);

    AppointmentResponse save(final @Valid AppointmentRequest request);

    AppointmentResponse update(final Long id, @Valid AppointmentRequest request);

}
