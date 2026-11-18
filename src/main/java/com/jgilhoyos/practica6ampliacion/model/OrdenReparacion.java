package com.jgilhoyos.practica6ampliacion.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "orden_reparacion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdenReparacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrdenReparacion;

    @Column(length = 255)
    private String descripcion;

    @Column(name="fecha_entrada")
    private LocalDate fechaEntrada;

    @Column
    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Column(name="coste_estimado", precision = 7, scale = 2)
    private BigDecimal costeEstimado;

    @Transient
    private Vehiculo vehiculo;



}
