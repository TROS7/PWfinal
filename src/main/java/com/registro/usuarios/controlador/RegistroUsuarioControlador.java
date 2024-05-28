package com.registro.usuarios.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.registro.usuarios.controlador.dto.UsuarioRegistroDTO;
import com.registro.usuarios.servicio.UsuarioServicio;

/**
 * El controlador RegistroUsuarioControlador maneja las solicitudes relacionadas con el registro de nuevos usuarios.
 * 
 * <p>Este controlador proporciona endpoints para mostrar el formulario de registro y para registrar nuevos usuarios.
 */
@Controller
@RequestMapping("/registro")
public class RegistroUsuarioControlador {

    private UsuarioServicio usuarioServicio;

    /**
     * Constructor del RegistroUsuarioControlador.
     * 
     * @param usuarioServicio el servicio de usuarios que será utilizado por este controlador
     */
    public RegistroUsuarioControlador(UsuarioServicio usuarioServicio) {
        super();
        this.usuarioServicio = usuarioServicio;
    }

    /**
     * Proporciona un nuevo objeto UsuarioRegistroDTO a la vista.
     * 
     * @return un nuevo UsuarioRegistroDTO
     */
    @ModelAttribute("usuario")
    public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO() {
        return new UsuarioRegistroDTO();
    }

    /**
     * Maneja la solicitud GET para mostrar el formulario de registro.
     * 
     * @return la vista del formulario de registro
     */
    @GetMapping
    public String mostrarFormularioDeRegistro() {
        return "registro";
    }

    /**
     * Maneja la solicitud POST para registrar una nueva cuenta de usuario.
     * 
     * @param registroDTO el DTO que contiene los datos del usuario a registrar
     * @return redirecciona a la página de registro con un mensaje de éxito
     */
    @PostMapping
    public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioRegistroDTO registroDTO) {
        usuarioServicio.guardar(registroDTO);
        return "redirect:/registro?exito";
    }
}
