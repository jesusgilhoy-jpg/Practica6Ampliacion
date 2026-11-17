package com.jgilhoyos.practica6ampliacion.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;

    @Column
    private String nombre;

    @Column
    private String apellidos;

    @Column(unique = true)
    private String dni;

    @Column(length = 9)
    private String telefono;

    @Column(unique = true)
    private String email;




}
