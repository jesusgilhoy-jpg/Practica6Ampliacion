package com.jgilhoyos.practica6ampliacion.test;

import com.jgilhoyos.practica6ampliacion.model.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TestCliente {

    private static final Logger logger = LoggerFactory.getLogger(TestCliente.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void ejecutarCicloVida() {
        logger.info("=== INICIO CICLO DE VIDA: CLIENTE ===");

        // 1. TRANSIENT
        Cliente cliente = new Cliente();
        cliente.setNombre("Juan");
        cliente.setApellidos("Pérez Gómez");
        cliente.setDni("12345678A");
        cliente.setTelefono("600123456");
        cliente.setEmail("juan.perez@email.com");
        logger.info("1. TRANSIENT - ¿Está gestionado?: {}", entityManager.contains(cliente));

        // 2. MANAGED (Persist)
        entityManager.persist(cliente);
        logger.info("2. MANAGED - Persistido ID: {}. ¿Está gestionado?: {}", cliente.getIdCliente(), entityManager.contains(cliente));

        // 3. Modificación en estado MANAGED
        cliente.setTelefono("699999999");
        logger.info("3. MODIFICACIÓN MANAGED - Teléfono actualizado en memoria.");

        // 4. DETACHED
        entityManager.detach(cliente);
        logger.info("4. DETACHED - ¿Está gestionado tras detach?: {}", entityManager.contains(cliente));

        // Modificación en estado DETACHED (no se sincroniza automáticamente con la BD)
        cliente.setTelefono("611111111");

        // 5. MERGE
        Cliente clienteMerged = entityManager.merge(cliente);
        logger.info("5. MERGE - Objeto fusionado. ¿Está gestionado el merged?: {}. Teléfono final: {}",
                entityManager.contains(clienteMerged), clienteMerged.getTelefono());

        logger.info("=== FIN CICLO DE VIDA: CLIENTE ===\n");
    }
}