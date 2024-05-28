package com.registro.usuarios.inter;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * La clase ServletInitializer configura la aplicación cuando se despliega en un contenedor de servlets.
 * 
 * <p>Extiende {@link SpringBootServletInitializer} y sobrescribe el método {@code configure} 
 * para especificar la clase principal de la aplicación.
 * 
 * <p>Esta configuración es necesaria para que la aplicación Spring Boot funcione correctamente
 * cuando se despliega como una aplicación web tradicional en un servidor de aplicaciones.
 * 
 * @see SpringBootServletInitializer
 */
public class ServletInitializer extends SpringBootServletInitializer {

    /**
     * Configura la aplicación para que use la clase principal {@link I18nViewApplication}.
     * 
     * <p>Este método se llama cuando la aplicación se despliega en un contenedor de servlets
     * como un archivo WAR.
     * 
     * @param application una instancia de {@link SpringApplicationBuilder}
     * @return la instancia de {@link SpringApplicationBuilder} con la clase fuente configurada
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(I18nViewApplication.class);
    }

}