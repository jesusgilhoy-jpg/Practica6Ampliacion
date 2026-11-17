package com.jgilhoyos.practica6ampliacion.test;

import com.jgilhoyos.practica6ampliacion.model.Vehiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TestVehiculo {

    private static final Logger logger = LoggerFactory.getLogger(TestVehiculo.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void ejecutarCicloVida() {
        logger.info("=== INICIO CICLO DE VIDA: VEHICULO ===");

        // 1. TRANSIENT
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setMatricula("1234ABC");
        vehiculo.setMarca("Seat");
        vehiculo.setModelo("León");
        vehiculo.setAnioFabricacion(2020);
        vehiculo.setKilometraje(45000);
        // Nota: 'cliente' es @Transient según tu entidad, por lo que no se persiste directamente a BD por JPA mapping.
        logger.info("1. TRANSIENT - Gestionado: {}", entityManager.contains(vehiculo));

        // 2. MANAGED
        entityManager.persist(vehiculo);
        logger.info("2. MANAGED - Persistido ID: {}. Gestionado: {}", vehiculo.getId_vehiculo(), entityManager.contains(vehiculo));

        // 3. Modificación
        vehiculo.setKilometraje(46000);
        logger.info("3. MODIFICACIÓN MANAGED - Kilometraje actualizado.");

        // 4. DETACHED
        entityManager.detach(vehiculo);
        logger.info("4. DETACHED - Gestionado: {}", entityManager.contains(vehiculo));

        vehiculo.setKilometraje(47000);

        // 5. MERGE
        Vehiculo vehiculoMerged = entityManager.merge(vehiculo);
        logger.info("5. MERGE - Gestionado: {}. Kilometraje final: {}", entityManager.contains(vehiculoMerged), vehiculoMerged.getKilometraje());

        logger.info("=== FIN CICLO DE VIDA: VEHICULO ===\n");
    }
}