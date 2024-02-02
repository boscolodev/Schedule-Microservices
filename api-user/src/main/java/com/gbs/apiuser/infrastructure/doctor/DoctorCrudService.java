package com.gbs.apiuser.infrastructure.doctor;

import com.gbs.apiuser.infrastructure.GenericCrudService;
import com.gbs.apiuser.model.entities.Doctor;
import com.gbs.apiuser.model.entities.Pacient;
import com.gbs.apiuser.model.repositories.DoctorRepository;
import com.gbs.apiuser.model.repositories.PacientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorCrudService implements GenericCrudService<Doctor, Long> {

    private final DoctorRepository repository;
    @Override
    public JpaRepository<Doctor, Long> getRepository() {
        return repository;
    }

    @Override
    public Doctor findById(Long id) {
        return GenericCrudService.super.findById(id);
    }

    @Override
    public void delete(Long id) {
        GenericCrudService.super.delete(id);
    }

    @Override
    public Doctor save(Doctor entity) {
        return GenericCrudService.super.save(entity);
    }

    @Override
    public Doctor update(Long id, Doctor entity) {
        return GenericCrudService.super.update(id, entity);
    }

    @Override
    public Page<Doctor> findAll(Pageable pageable) {
        return GenericCrudService.super.findAll(pageable);
    }

    @Override
    public void beforeSave() {
        GenericCrudService.super.beforeSave();
    }

    public boolean existsEmail(String email){
        return repository.existsByEmail(email);
    }
    public Doctor findByEmail(String email){
        return repository.findByEmail(email);
    }
}
