package com.jgilhoyos.practica6ampliacion.test;

import com.jgilhoyos.practica6ampliacion.model.Estado;
import com.jgilhoyos.practica6ampliacion.model.OrdenReparacion;
import com.jgilhoyos.practica6ampliacion.model.Vehiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class TestOrdenReparacion {

    private static final Logger logger = LoggerFactory.getLogger(TestOrdenReparacion.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void ejecutarCicloVida() {
        logger.info("=== INICIO CICLO DE VIDA: ORDEN REPARACION ===");

        // Creamos y persistimos un vehículo previo para asociarlo a la orden
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setMatricula("9999XYZ");
        vehiculo.setMarca("Ford");
        vehiculo.setModelo("Focus");
        vehiculo.setAnioFabricacion(2021);
        vehiculo.setKilometraje(30000);
        entityManager.persist(vehiculo);

        // 1. TRANSIENT
        OrdenReparacion orden = new OrdenReparacion();
        orden.setDescripcion("Cambio de pastillas de freno y discos");
        orden.setFechaEntrada(LocalDate.now());
        orden.setEstado(Estado.PENDIENTE);
        orden.setCosteEstimado(new BigDecimal("180.00"));
        orden.setVehiculo(vehiculo);
        logger.info("1. TRANSIENT - ¿Está gestionado?: {}", entityManager.contains(orden));

        // 2. MANAGED (Persist)
        entityManager.persist(orden);
        logger.info("2. MANAGED - Persistido ID: {}. ¿Está gestionado?: {}", orden.getIdOrdenReparacion(), entityManager.contains(orden));

        // 3. Modificación en estado MANAGED
        orden.setCosteEstimado(new BigDecimal("195.50"));
        logger.info("3. MODIFICACIÓN MANAGED - Coste estimado actualizado en memoria.");

        // 4. DETACHED
        entityManager.detach(orden);
        logger.info("4. DETACHED - ¿Está gestionado tras detach?: {}", entityManager.contains(orden));

        // Modificación en estado DETACHED
        orden.setCosteEstimado(new BigDecimal("210.00"));

        // 5. MERGE
        OrdenReparacion ordenMerged = entityManager.merge(orden);
        logger.info("5. MERGE - Objeto fusionado. ¿Está gestionado el merged?: {}. Coste final: {}",
                entityManager.contains(ordenMerged), ordenMerged.getCosteEstimado());

        logger.info("=== FIN CICLO DE VIDA: ORDEN REPARACION ===\n");
    }
}