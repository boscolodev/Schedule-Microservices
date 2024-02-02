package com.gbs.apiuser.model.repositories;

import com.gbs.apiuser.model.entities.Pacient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacientRepository extends JpaRepository<Pacient, Long> {

    boolean existsByEmail(String email);
    Pacient findByEmail(String email);

}
