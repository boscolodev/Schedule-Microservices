package com.gbs.apiuser.model.repositories;

import com.gbs.apiuser.model.entities.Doctor;
import com.gbs.apiuser.model.entities.Pacient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    boolean existsByEmail(String email);
    Doctor findByEmail(String email);
}
