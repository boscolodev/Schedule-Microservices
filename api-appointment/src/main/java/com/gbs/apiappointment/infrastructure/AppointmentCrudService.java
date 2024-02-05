package com.gbs.apiappointment.infrastructure;

import com.gbs.apiappointment.model.entities.Appointment;
import com.gbs.apiappointment.model.repositories.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentCrudService<T, ID> implements GenericCrudService<Appointment, Long> {

    private final AppointmentRepository repository;

    @Override
    public JpaRepository<Appointment, Long> getRepository() {
        return repository;
    }

    @Override
    public Appointment findById(Long id) {
        return GenericCrudService.super.findById(id);
    }

    @Override
    public void delete(Long id) {
        GenericCrudService.super.delete(id);
    }

    @Override
    public Appointment save(Appointment entity) {
        return GenericCrudService.super.save(entity);
    }

    @Override
    public Appointment update(Long id, Appointment entity) {
        return GenericCrudService.super.update(id, entity);
    }

    @Override
    public Page<Appointment> findAll(Pageable pageable) {
        return GenericCrudService.super.findAll(pageable);
    }
}
