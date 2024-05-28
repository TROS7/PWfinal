package com.registro.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * La clase RegistroUsuariosSpringSecurityApplication es la clase principal para
 * la aplicación de registro de usuarios con Spring Security.
 * 
 * <p>Esta clase configura y arranca la aplicación utilizando Spring Boot.
 * 
 * <p>Para ejecutar la aplicación, simplemente ejecute el método main.
 * 
 * <p>Ejemplo de uso:
 * <pre>
 * {@code
 * public static void main(String[] args) {
 *     SpringApplication.run(RegistroUsuariosSpringSecurityApplication.class, args);
 * }
 * }
 * </pre>
 * 
 * <p>Esta clase está anotada con {@link SpringBootApplication}, lo que la hace
 * la clase principal para la configuración y el arranque de la aplicación.
 * 
 * <p>El método main utiliza {@link SpringApplication#run(Class, String...)} para
 * lanzar la aplicación.
 * 
 * @see SpringApplication
 * @see SpringBootApplication
 */
@SpringBootApplication
public class RegistroUsuariosSpringSecurityApplication {

    /**
     * El método main es el punto de entrada de la aplicación.
     * 
     * <p>Este método arranca la aplicación Spring Boot utilizando la clase
     * {@link SpringApplication}.
     * 
     * @param args Los argumentos de línea de comandos
     */
    public static void main(String[] args) {
        SpringApplication.run(RegistroUsuariosSpringSecurityApplication.class, args);
    }
}