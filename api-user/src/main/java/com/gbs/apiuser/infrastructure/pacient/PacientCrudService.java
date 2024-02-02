package com.gbs.apiuser.infrastructure.pacient;

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
public class PacientCrudService implements GenericCrudService<Pacient, Long> {

    private final PacientRepository repository;
    @Override
    public JpaRepository<Pacient, Long> getRepository() {
        return repository;
    }

    @Override
    public Pacient findById(Long id) {
        return GenericCrudService.super.findById(id);
    }

    @Override
    public void delete(Long id) {
        GenericCrudService.super.delete(id);
    }

    @Override
    public Pacient save(Pacient entity) {
        return GenericCrudService.super.save(entity);
    }

    @Override
    public Pacient update(Long id, Pacient entity) {
        return GenericCrudService.super.update(id, entity);
    }

    @Override
    public Page<Pacient> findAll(Pageable pageable) {
        return GenericCrudService.super.findAll(pageable);
    }

    @Override
    public void beforeSave() {
        GenericCrudService.super.beforeSave();
    }

    public boolean existsEmail(String email){
        return repository.existsByEmail(email);
    }
    public Pacient findByEmail(String email){
        return repository.findByEmail(email);
    }
}
