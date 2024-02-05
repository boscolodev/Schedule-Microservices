package com.gbs.apiappointment.api.controller;

import com.gbs.apiappointment.api.dto.appointment.AppointmentRequest;
import com.gbs.apiappointment.api.dto.appointment.AppointmentResponse;
import com.gbs.apiappointment.application.usecase.AppointmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService service;

    @GetMapping
    public Page<AppointmentResponse> findAll(final Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping(value = "/{id}")
    public AppointmentResponse findById(@PathVariable final Long id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable final Long id) {
        service.delete(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AppointmentResponse save(@RequestBody @Valid AppointmentRequest request) {
        return service.save(request);
    }

    @PutMapping(value = "/{id}")
    public AppointmentResponse update(@PathVariable final Long id, @RequestBody @Valid AppointmentRequest request) {
        return service.update(id, request);
    }
}
