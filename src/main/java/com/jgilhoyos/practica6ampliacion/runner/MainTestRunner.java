package com.jgilhoyos.practica6ampliacion.runner;

import com.jgilhoyos.practica6ampliacion.test.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MainTestRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MainTestRunner.class);

    @Autowired
    private TestCliente testCliente;

    @Autowired
    private TestMecanico testMecanico;

    @Autowired
    private TestOrdenReparacion testOrdenReparacion;

    @Autowired
    private TestPieza testPieza;

    @Autowired
    private TestProveedor testProveedor;

    @Autowired
    private TestVehiculo testVehiculo;

    @Override
    public void run(String... args) throws Exception {
        logger.info("==================================================");
        logger.info(" INICIANDO PRUEBAS DE CICLO DE VIDA JPA (6 ENTIDADES)");
        logger.info("==================================================");

        testCliente.ejecutarCicloVida();
        testMecanico.ejecutarCicloVida();
        testOrdenReparacion.ejecutarCicloVida();
        testPieza.ejecutarCicloVida();
        testProveedor.ejecutarCicloVida();
        testVehiculo.ejecutarCicloVida();

        logger.info("==================================================");
        logger.info(" TODAS LAS PRUEBAS FINALIZARON EXITOSAMENTE");
        logger.info("==================================================");
    }
}