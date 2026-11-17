package com.jgilhoyos.practica6ampliacion.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "proveedor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProveedor;

    @Column
    private String nombre;

    @Column(unique = true)
    private String cif;

    @Column
    private int telefono;

    @Column(nullable = true)
    private String email;

    @Column
    private boolean activo;



}
