package com.registro.usuarios.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.registro.usuarios.modelo.Usuario;

/**
 * La interfaz UsuarioRepositorio proporciona métodos para acceder y gestionar datos de usuarios en la base de datos.
 * 
 * <p>Esta interfaz extiende {@link JpaRepository} y está anotada con {@link Repository} para indicar que es un componente de repositorio Spring.
 * Proporciona métodos para realizar operaciones CRUD básicas en la entidad Usuario.
 */
@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{

    /**
     * Busca un usuario por su dirección de correo electrónico.
     * 
     * @param email la dirección de correo electrónico del usuario a buscar
     * @return el usuario encontrado, o null si no se encuentra ningún usuario con el correo electrónico dado
     */
    public Usuario findByEmail(String email);
    
}