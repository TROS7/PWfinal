package com.registro.usuarios.inter;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * La clase i18n configura la internacionalización (i18n) para la aplicación.
 * 
 * <p>Esta clase implementa {@link WebMvcConfigurer} y define los beans necesarios
 * para la resolución de la localización y el cambio de la localización basada en un parámetro.
 */
@Configuration
public class i18n implements WebMvcConfigurer {

    /**
     * Define el bean LocaleResolver que determina la localización predeterminada de la aplicación.
     * 
     * @return un {@link SessionLocaleResolver} configurado con la localización predeterminada en inglés (EE.UU.)
     */
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(Locale.US);
        return sessionLocaleResolver;
    }

    /**
     * Define el bean LocaleChangeInterceptor que permite cambiar la localización mediante un parámetro en la solicitud.
     * 
     * @return un {@link LocaleChangeInterceptor} configurado para usar el parámetro "lang"
     */
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }

    /**
     * Añade el interceptor de cambio de localización al registro de interceptores.
     * 
     * @param registry el registro de interceptores
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

}

