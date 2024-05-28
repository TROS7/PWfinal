package com.registro.usuarios.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.registro.usuarios.servicio.UsuarioServicio;

/**
 * La clase SecurityConfiguration configura la seguridad de la aplicación.
 * 
 * <p>Esta clase extiende {@link WebSecurityConfigurerAdapter} y está anotada con {@link Configuration} y {@link EnableWebSecurity} para indicar que es una configuración de seguridad de Spring.
 * Configura la autenticación de usuarios, las autorizaciones de acceso a las URL y otras opciones de seguridad.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private AuthenticationSuccessHandler customAuthenticationSuccessHandler;
    
    /**
     * Crea un codificador de contraseñas BCrypt.
     * 
     * @return el codificador de contraseñas BCrypt
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    /**
     * Crea un proveedor de autenticación personalizado.
     * 
     * @return el proveedor de autenticación personalizado
     */
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(usuarioServicio);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }
    
    /**
     * Configura el administrador de autenticación.
     * 
     * @param auth el administrador de autenticación
     * @throws Exception si ocurre un error al configurar la autenticación
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
    
    /**
     * Configura la seguridad HTTP.
     * 
     * @param http la configuración de seguridad HTTP
     * @throws Exception si ocurre un error al configurar la seguridad HTTP
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers(
                "/registro**",
                "/js/**",
                "/css/**",
                "/img/**").permitAll()
            .antMatchers("/").hasRole("ADMIN")
            .antMatchers("/prueba").hasRole("USER")
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/login")
            .successHandler(customAuthenticationSuccessHandler)  // Usa el manejador de éxito de autenticación personalizado
            .permitAll()
            .and()
            .logout()
            .invalidateHttpSession(true)
            .clearAuthentication(true)
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .logoutSuccessUrl("/login?logout")
            .permitAll();
    }
}

