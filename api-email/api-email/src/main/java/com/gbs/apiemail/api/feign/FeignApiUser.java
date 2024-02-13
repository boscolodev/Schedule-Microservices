package com.gbs.apiemail.api.feign;

import com.gbs.apiemail.api.dto.DoctorResponse;
import com.gbs.apiemail.api.dto.PatientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", url = "${service.api.user.url}")
public interface FeignApiUser {

    @GetMapping("/api/v1/pacients/{id}")
    public PatientResponse findPatientById(@PathVariable("id") final Long id);

    @GetMapping("/api/v1/doctors/{id}")
    public DoctorResponse findDoctorById(@PathVariable("id") final Long id);
}
