package com.jgilhoyos.practica6ampliacion.test;

import com.jgilhoyos.practica6ampliacion.model.Pieza;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Component
public class TestPieza {

    private static final Logger logger = LoggerFactory.getLogger(TestPieza.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void ejecutarCicloVida() {
        logger.info("=== INICIO CICLO DE VIDA: PIEZA ===");

        // 1. TRANSIENT
        Pieza pieza = new Pieza();
        pieza.setNombre("Filtro de aceite");
        pieza.setCodigo("PZ0001");
        pieza.setPrecio(new BigDecimal("25.50"));
        pieza.setStock(50);
        pieza.setDisponible(true);
        logger.info("1. TRANSIENT - Gestionado: {}", entityManager.contains(pieza));

        // 2. MANAGED
        entityManager.persist(pieza);
        logger.info("2. MANAGED - Persistido ID: {}. Gestionado: {}", pieza.getIdPieza(), entityManager.contains(pieza));

        // 3. Modificación
        pieza.setStock(45);
        logger.info("3. MODIFICACIÓN MANAGED - Stock actualizado.");

        // 4. DETACHED
        entityManager.detach(pieza);
        logger.info("4. DETACHED - Gestionado: {}", entityManager.contains(pieza));

        pieza.setStock(40);

        // 5. MERGE
        Pieza piezaMerged = entityManager.merge(pieza);
        logger.info("5. MERGE - Gestionado: {}. Stock final: {}", entityManager.contains(piezaMerged), piezaMerged.getStock());

        logger.info("=== FIN CICLO DE VIDA: PIEZA ===\n");
    }
}