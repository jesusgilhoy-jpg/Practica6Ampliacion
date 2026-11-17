package com.jgilhoyos.practica6ampliacion.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "mecanico")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mecanico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMecanico;

    @Column
    private String nombre;

    @Column
    private String apellidos;

    @Column
    private Especialidad especialidad;

    @Column(name="fecha_contratacion")
    private LocalDate fechaContratacion;

    @Column(name="anios_experiencia")
    private int aniosExperiencia;


}
