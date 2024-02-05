package com.gbs.apiappointment.model.entities;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "tb_appointment", schema = "db_appointment")
public class Appointment implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long doctorId;

    @Column(nullable = false)
    private Long pacientId;

    @Column(nullable = false)
    private Long patientId;

    @Column(nullable = false)
    private Date appointmentDate;

    @Column(nullable = false)
    private Long appointmentTime;

}
