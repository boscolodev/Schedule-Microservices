package com.gbs.apiuser.application.usecase.pacient;

import com.gbs.apiuser.api.dto.pacient.PacientRequest;
import com.gbs.apiuser.api.dto.pacient.PacientResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;

@Validated
public interface PacientService{

    PacientResponse findById(final Long id);

    Page<PacientResponse> findAll(Pageable pageable);
    void delete(final Long id);

    PacientResponse save(final @Valid PacientRequest request);

    PacientResponse update(final Long id, @Valid PacientRequest request);

}
