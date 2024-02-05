package com.gbs.apiappointment.model.repositories;

import com.gbs.apiappointment.model.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
