package com.jgilhoyos.practica6ampliacion.test;

import com.jgilhoyos.practica6ampliacion.model.Proveedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TestProveedor {

    private static final Logger logger = LoggerFactory.getLogger(TestProveedor.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void ejecutarCicloVida() {
        logger.info("=== INICIO CICLO DE VIDA: PROVEEDOR ===");

        // 1. TRANSIENT
        Proveedor proveedor = new Proveedor();
        proveedor.setNombre("Recambios Valencia S.L.");
        proveedor.setCif("B12345678");
        proveedor.setTelefono(961234567);
        proveedor.setEmail("contacto@recambiosvalencia.com");
        proveedor.setActivo(true);
        logger.info("1. TRANSIENT - Gestionado: {}", entityManager.contains(proveedor));

        // 2. MANAGED
        entityManager.persist(proveedor);
        logger.info("2. MANAGED - Persistido ID: {}. Gestionado: {}", proveedor.getIdProveedor(), entityManager.contains(proveedor));

        // 3. Modificación
        proveedor.setTelefono(969876543);
        logger.info("3. MODIFICACIÓN MANAGED - Teléfono actualizado.");

        // 4. DETACHED
        entityManager.detach(proveedor);
        logger.info("4. DETACHED - Gestionado: {}", entityManager.contains(proveedor));

        proveedor.setTelefono(960000000);

        // 5. MERGE
        Proveedor proveedorMerged = entityManager.merge(proveedor);
        logger.info("5. MERGE - Gestionado: {}. Teléfono final: {}", entityManager.contains(proveedorMerged), proveedorMerged.getTelefono());

        logger.info("=== FIN CICLO DE VIDA: PROVEEDOR ===\n");
    }
}