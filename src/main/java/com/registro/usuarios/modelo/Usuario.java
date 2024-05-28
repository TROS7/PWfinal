package com.registro.usuarios.modelo;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * La clase Usuario representa un usuario en el sistema.
 * 
 * <p>Esta clase está mapeada a la tabla "usuarios" en la base de datos utilizando JPA.
 * Cada usuario tiene un conjunto de roles asociados.
 */
@Entity
@Table(name = "usuarios", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "usuarios_roles",
            joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id")
    )
    private Collection<Rol> roles;

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
     * Obtiene los roles del usuario.
     * 
     * @return una colección de roles del usuario
     */
    public Collection<Rol> getRoles() {
        return roles;
    }

    /**
     * Establece los roles del usuario.
     * 
     * @param roles una colección de roles del usuario
     */
    public void setRoles(Collection<Rol> roles) {
        this.roles = roles;
    }

    /**
     * Constructor con todos los campos para crear un nuevo Usuario.
     * 
     * @param id el ID del usuario
     * @param nombre el nombre del usuario
     * @param apellido el apellido del usuario
     * @param email el email del usuario
     * @param password la contraseña del usuario
     * @param roles los roles del usuario
     */
    public Usuario(Long id, String nombre, String apellido, String email, String password, Collection<Rol> roles) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    /**
     * Constructor con los campos esenciales para crear un nuevo Usuario.
     * 
     * @param nombre el nombre del usuario
     * @param apellido el apellido del usuario
     * @param email el email del usuario
     * @param password la contraseña del usuario
     * @param roles los roles del usuario
     */
    public Usuario(String nombre, String apellido, String email, String password, Collection<Rol> roles) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    /**
     * Constructor sin parámetros para crear un nuevo Usuario.
     */
    public Usuario() {
    }

}

