package com.jgilhoyos.practica6ampliacion.test;

import com.jgilhoyos.practica6ampliacion.model.Especialidad; // Asegúrate de importar tu enum
import com.jgilhoyos.practica6ampliacion.model.Mecanico;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Component
public class TestMecanico {

    private static final Logger logger = LoggerFactory.getLogger(TestMecanico.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void ejecutarCicloVida() {
        logger.info("=== INICIO CICLO DE VIDA: MECANICO ===");

        // 1. TRANSIENT
        Mecanico mecanico = new Mecanico();
        mecanico.setNombre("Carlos");
        mecanico.setApellidos("Sánz Ruiz");
        mecanico.setEspecialidad(Especialidad.ELECTRICIDAD); // Ajusta según tu enum
        mecanico.setFechaContratacion(LocalDate.now());
        mecanico.setAniosExperiencia(5);
        logger.info("1. TRANSIENT - ¿Está gestionado?: {}", entityManager.contains(mecanico));

        // 2. MANAGED
        entityManager.persist(mecanico);
        logger.info("2. MANAGED - Persistido ID: {}. ¿Está gestionado?: {}", mecanico.getIdMecanico(), entityManager.contains(mecanico));

        // 3. Modificación
        mecanico.setAniosExperiencia(6);
        logger.info("3. MODIFICACIÓN MANAGED - Años de experiencia actualizados.");

        // 4. DETACHED
        entityManager.detach(mecanico);
        logger.info("4. DETACHED - ¿Está gestionado?: {}", entityManager.contains(mecanico));

        mecanico.setAniosExperiencia(10);

        // 5. MERGE
        Mecanico mecanicoMerged = entityManager.merge(mecanico);
        logger.info("5. MERGE - Gestionado: {}. Experiencia final: {}", entityManager.contains(mecanicoMerged), mecanicoMerged.getAniosExperiencia());

        logger.info("=== FIN CICLO DE VIDA: MECANICO ===\n");
    }
}