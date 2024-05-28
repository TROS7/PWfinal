package com.registro.usuarios.controlador.dto;

/**
 * La clase UsuarioRegistroDTO es un Data Transfer Object (DTO) utilizado para el registro de usuarios.
 * 
 * <p>Esta clase contiene los campos necesarios para registrar un usuario, incluyendo id, nombre, apellido,
 * email y contraseña.
 */
public class UsuarioRegistroDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String password;

    /**
     * Obtiene el ID del usuario.
     * 
     * @return el ID del usuario
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del usuario.
     * 
     * @param id el ID del usuario
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del usuario.
     * 
     * @return el nombre del usuario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     * 
     * @param nombre el nombre del usuario
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido del usuario.
     * 
     * @return el apellido del usuario
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido del usuario.
     * 
     * @param apellido el apellido del usuario
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene el email del usuario.
     * 
     * @return el email del usuario
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el email del usuario.
     * 
     * @param email el email del usuario
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene la contraseña del usuario.
     * 
     * @return la contraseña del usuario
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la contraseña del usuario.
     * 
     * @param password la contraseña del usuario
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Constructor con parámetros para crear un nuevo UsuarioRegistroDTO.
     * 
     * @param nombre el nombre del usuario
     * @param apellido el apellido del usuario
     * @param email el email del usuario
     * @param password la contraseña del usuario
     */
    public UsuarioRegistroDTO(String nombre, String apellido, String email, String password) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
    }

    /**
     * Constructor sin parámetros para crear un nuevo UsuarioRegistroDTO.
     */
    public UsuarioRegistroDTO() {
    }

}