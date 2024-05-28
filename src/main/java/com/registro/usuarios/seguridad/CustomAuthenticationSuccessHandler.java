package com.registro.usuarios.seguridad;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * La clase CustomAuthenticationSuccessHandler maneja la redirección después de una autenticación exitosa.
 * 
 * <p>Esta clase implementa {@link AuthenticationSuccessHandler} y está anotada con {@link Component} para que Spring la reconozca como un componente.
 * Cuando la autenticación es exitosa, se redirige al usuario dependiendo de sus roles.
 */
@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    /**
     * Método invocado cuando la autenticación es exitosa.
     * 
     * <p>Redirige al usuario dependiendo de sus roles.
     * Si el usuario tiene el rol "ROLE_ADMIN", se redirige a la página de inicio ("/").
     * Si el usuario tiene el rol "ROLE_USER", se redirige a la página de prueba ("/prueba").
     * Si el usuario no tiene ninguno de estos roles, se redirige a la página de inicio de sesión con un error ("/login?error").
     * 
     * @param request la solicitud HTTP
     * @param response la respuesta HTTP
     * @param authentication la información de autenticación del usuario
     * @throws IOException si hay un error de E/S durante la redirección
     * @throws ServletException si ocurre un error de servlet durante la redirección
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        for (GrantedAuthority authority : authorities) {
            if (authority.getAuthority().equals("ROLE_ADMIN")) {
                response.sendRedirect("/");
                return;
            } else if (authority.getAuthority().equals("ROLE_USER")) {
                response.sendRedirect("/prueba");
                return;
            }
        }
        response.sendRedirect("/login?error");
    }
}