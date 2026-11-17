package com.jgilhoyos.practica6ampliacion.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "pieza")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pieza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPieza;

    @Column
    private String nombre;

    @Column(unique = true, length = 6)
    private String codigo;

    @Column(precision = 6, scale = 2)
    private BigDecimal precio;

    @Column
    private int stock;

    @Column
    private boolean disponible;
}
