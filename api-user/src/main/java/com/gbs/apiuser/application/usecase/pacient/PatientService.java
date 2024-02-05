package com.gbs.apiuser.application.usecase.pacient;

import com.gbs.apiuser.api.dto.pacient.PacientRequest;
import com.gbs.apiuser.api.dto.pacient.PatientResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;

@Validated
public interface PatientService {

    PatientResponse findById(final Long id);

    Page<PatientResponse> findAll(Pageable pageable);
    void delete(final Long id);

    PatientResponse save(final @Valid PacientRequest request);

    PatientResponse update(final Long id, @Valid PacientRequest request);

}
