package com.registro.usuarios.servicio;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.registro.usuarios.controlador.dto.UsuarioRegistroDTO;
import com.registro.usuarios.modelo.Usuario;

/**
 * La interfaz UsuarioServicio define los métodos para la gestión de usuarios en el sistema.
 * 
 * <p>Esta interfaz extiende {@link UserDetailsService}, lo que permite utilizarla como servicio de detalles de usuario para la autenticación de Spring Security.
 * Define métodos para guardar un nuevo usuario y para listar todos los usuarios registrados.
 */
public interface UsuarioServicio extends UserDetailsService {

    /**
     * Guarda un nuevo usuario en el sistema.
     * 
     * @param registroDTO los datos del usuario a registrar
     * @return el usuario guardado
     */
    public Usuario guardar(UsuarioRegistroDTO registroDTO);
    
    /**
     * Obtiene una lista de todos los usuarios registrados en el sistema.
     * 
     * @return una lista de usuarios
     */
    public List<Usuario> listarUsuarios();

}