package com.gbs.apiuser.api.controller;

import com.gbs.apiuser.api.dto.doctor.DoctorRequest;
import com.gbs.apiuser.api.dto.doctor.DoctorResponse;
import com.gbs.apiuser.api.dto.pacient.PacientRequest;
import com.gbs.apiuser.api.dto.pacient.PacientResponse;
import com.gbs.apiuser.application.usecase.doctor.DoctorService;
import com.gbs.apiuser.application.usecase.pacient.PacientService;
import com.gbs.apiuser.model.entities.Doctor;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService service;

    @GetMapping
    public Page<DoctorResponse> findAll(final Pageable pageable){
        return service.findAll(pageable);
    }

    @GetMapping(value = "/{id}")
    public DoctorResponse findById(@PathVariable final Long id){
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable final Long id){
        service.delete(id);
    }

    @PutMapping(value = "/{id}")
    public DoctorResponse update(@PathVariable final Long id, @RequestBody @Valid final DoctorRequest request){
        return service.update(id, request);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DoctorResponse insert(@RequestBody @Valid final DoctorRequest request){
        return service.save(request);
    }

}
