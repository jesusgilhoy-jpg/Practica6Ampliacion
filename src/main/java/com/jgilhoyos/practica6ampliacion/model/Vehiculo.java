package com.jgilhoyos.practica6ampliacion.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vehiculo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehiculo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_vehiculo;

    @Column(unique = true, length = 7)
    private String matricula;

    @Column
    private String marca;

    @Column
    private String modelo;

    @Column(name="anio_fabricacion")
    private int anioFabricacion;

    @Column(nullable = false)
    private int kilometraje;

    @Transient
    private Cliente cliente;
}
