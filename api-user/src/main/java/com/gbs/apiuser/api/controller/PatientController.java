package com.gbs.apiuser.api.controller;

import com.gbs.apiuser.api.dto.pacient.PacientRequest;
import com.gbs.apiuser.api.dto.pacient.PatientResponse;
import com.gbs.apiuser.application.usecase.pacient.PatientService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/pacients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService service;

    @GetMapping
    public Page<PatientResponse> findAll(final Pageable pageable){
        return service.findAll(pageable);
    }

    @GetMapping(value = "/{id}")
    public PatientResponse findById(@PathVariable final Long id){
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable final Long id){
        service.delete(id);
    }

    @PutMapping(value = "/{id}")
    public PatientResponse update(@PathVariable final Long id, @RequestBody @Valid final PacientRequest request){
        return service.update(id, request);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PatientResponse insert(@RequestBody @Valid final PacientRequest request){
        return service.save(request);
    }

}
