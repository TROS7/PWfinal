package com.registro.usuarios.inter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * La clase I18nViewApplication es la clase principal para la aplicación de vista internacionalizada (i18n).
 * 
 * <p>Esta clase configura y arranca la aplicación utilizando Spring Boot.
 * 
 * <p>Está anotada con {@link SpringBootApplication} y {@link ComponentScan}, lo que permite 
 * la configuración automática de Spring Boot y especifica los paquetes a escanear para 
 * componentes Spring.
 * 
 * <p>Para ejecutar la aplicación, simplemente ejecute el método main.
 * 
 * <p>Ejemplo de uso:
 * <pre>
 * {@code
 * public static void main(String[] args) {
 *     SpringApplication.run(I18nViewApplication.class, args);
 * }
 * }
 * </pre>
 * 
 * @see SpringApplication
 * @see SpringBootApplication
 * @see ComponentScan
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.registro.usuarios", "co.edu.usco.pw.i18n_view"})
public class I18nViewApplication {

    /**
     * El método main es el punto de entrada de la aplicación.
     * 
     * <p>Este método arranca la aplicación Spring Boot utilizando la clase
     * {@link SpringApplication}.
     * 
     * @param args Los argumentos de línea de comandos
     */
    public static void main(String[] args) {
        SpringApplication.run(I18nViewApplication.class, args);
    }
}