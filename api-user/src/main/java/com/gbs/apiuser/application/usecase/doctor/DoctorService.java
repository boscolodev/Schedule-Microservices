package com.gbs.apiuser.application.usecase.doctor;

import com.gbs.apiuser.api.dto.doctor.DoctorRequest;
import com.gbs.apiuser.api.dto.doctor.DoctorResponse;
import com.gbs.apiuser.api.dto.pacient.PacientRequest;
import com.gbs.apiuser.api.dto.pacient.PacientResponse;
import com.gbs.apiuser.model.entities.Doctor;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;

@Validated
public interface DoctorService {

    DoctorResponse findById(final Long id);

    Page<DoctorResponse> findAll(Pageable pageable);
    void delete(final Long id);

    DoctorResponse save(final @Valid DoctorRequest request);

    DoctorResponse update(final Long id, @Valid DoctorRequest request);

}
