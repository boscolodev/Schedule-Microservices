package com.gbs.apiappointment.application.usecase;

import com.gbs.apiappointment.api.dto.appointment.AppointmentRequest;
import com.gbs.apiappointment.api.dto.appointment.AppointmentResponse;
import com.gbs.apiappointment.infrastructure.AppointmentCrudService;
import com.gbs.apiappointment.shared.utils.Mapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentCrudService service;
    @Override
    public AppointmentResponse findById(Long id) {
        return Mapper.converte(service.findById(id), AppointmentResponse.class);
    }
    @Override
    public Page<AppointmentResponse> findAll(Pageable pageable) {
        return service.findAll(pageable).map(row -> Mapper.converte(row, AppointmentResponse.class));
    }

    @Override
    public void delete(Long id) {
        service.delete(id);
    }

    @Override
    public AppointmentResponse save(AppointmentRequest request) {
        return Mapper.converte(request, AppointmentResponse.class);
    }

    @Override
    public AppointmentResponse update(Long id, AppointmentRequest request) {
        return Mapper.converte(request, AppointmentResponse.class);
    }
}
