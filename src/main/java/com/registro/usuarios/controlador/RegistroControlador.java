package com.registro.usuarios.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.registro.usuarios.modelo.Usuario;
import com.registro.usuarios.servicio.UsuarioServicio;

/**
 * El controlador RegistroControlador maneja las solicitudes relacionadas con el registro de usuarios.
 * 
 * <p>Este controlador proporciona endpoints para iniciar sesión, ver la página de inicio, 
 * registrar nuevos usuarios, editar usuarios existentes y eliminar usuarios.
 */
@Controller
public class RegistroControlador {

    @Autowired
    private UsuarioServicio servicio;

    /**
     * Maneja la solicitud GET para la prueba.
     * 
     * @return la vista de prueba
     */
    @GetMapping("/prueba")
    public String inciarprueba() {
        return "img/prueba";
    }

    /**
     * Maneja la solicitud GET para iniciar sesión.
     * 
     * @return la vista de inicio de sesión
     */
    @GetMapping("/login")
    public String iniciarSesion() {
        return "login";
    }

    /**
     * Maneja la solicitud GET para ver la página de inicio.
     * 
     * @param modelo el modelo para pasar datos a la vista
     * @return la vista de la página de inicio
     */
    @GetMapping("/")
    public String verPaginaDeInicio(Model modelo) {
        modelo.addAttribute("usuarios", servicio.listarUsuarios());
        return "index";
    }

    /**
     * Maneja la solicitud GET para mostrar el formulario de registro de un nuevo usuario.
     * 
     * @param modelo el modelo para pasar datos a la vista
     * @return la vista del formulario de registro de usuario
     */
    @GetMapping("/nuevo")
    public String MostrarFormularioDeRegistrarUsuario(Model modelo) {
        Usuario usuario = new Usuario();
        modelo.addAttribute("usuario", usuario);
        return "nuevo_usuario";    
    }

    /**
     * Maneja la solicitud GET para mostrar el formulario de edición de un usuario existente.
     * 
     * @param id el ID del usuario a editar
     * @return la vista del formulario de edición de usuario
     */
    @GetMapping("/editar/{id}")
    public ModelAndView mostrarFormularioDeEditar(@PathVariable(name="id") Long id) {
        ModelAndView modelo = new ModelAndView("editar_usuario");
        return modelo;
    }

    /**
     * Maneja la solicitud GET para eliminar un usuario.
     * 
     * @param id el ID del usuario a eliminar
     * @return redirecciona a la página de inicio
     */
    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable(name="id") Long id) {
        return "redirect:/";
    }
}
