package com.jgilhoyos.practica6ampliacion;


import com.jgilhoyos.practica6ampliacion.test.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Practica6AmpliacionApplication {

    public static void main(String[] args) {
        SpringApplication.run(Practica6AmpliacionApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(TestCliente testCliente, TestMecanico testMecanico, TestOrdenReparacion testOrdenReparacion, TestPieza testPieza, TestProveedor testProveedor, TestVehiculo testVehiculo) {
        return args -> {

            System.out.println("==================================================");
            System.out.println(" INICIANDO PRUEBAS DE CICLO DE VIDA JPA (6 ENTIDADES)");
            System.out.println("==================================================");

                testCliente.ejecutarCicloVida();
                testMecanico.ejecutarCicloVida();
                testOrdenReparacion.ejecutarCicloVida();
                testPieza.ejecutarCicloVida();
                testProveedor.ejecutarCicloVida();
                testVehiculo.ejecutarCicloVida();

            System.out.println("==================================================");
            System.out.println(" TODAS LAS PRUEBAS FINALIZARON EXITOSAMENTE");
            System.out.println("==================================================");

        };
    }

}
