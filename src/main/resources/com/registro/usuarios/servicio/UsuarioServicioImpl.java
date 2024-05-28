package com.registro.usuarios.servicio;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.registro.usuarios.controlador.dto.UsuarioRegistroDTO;
import com.registro.usuarios.modelo.Rol;
import com.registro.usuarios.modelo.Usuario;
import com.registro.usuarios.repositorio.UsuarioRepositorio;

/**
 * La clase UsuarioServicioImpl proporciona métodos para la gestión de usuarios en el sistema.
 * 
 * <p>Esta clase implementa {@link UsuarioServicio} y está anotada con {@link Service} para indicar que es un servicio de Spring.
 * Implementa la lógica para guardar usuarios, cargar usuarios por nombre de usuario y mapear roles a autoridades de Spring Security.
 */
@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * Crea una instancia de UsuarioServicioImpl.
     * 
     * @param usuarioRepositorio el repositorio de usuarios
     */
    public UsuarioServicioImpl(UsuarioRepositorio usuarioRepositorio) {
        super();
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @SuppressWarnings("unused")
    @Override
    public Usuario guardar(UsuarioRegistroDTO registroDTO) {
        long count = usuarioRepositorio.count();
        String rolNombre = (count == 0) ? "ROLE_ADMIN" : "ROLE_USER";

        Usuario usuario = new Usuario(registroDTO.getNombre(), 
                registroDTO.getApellido(), registroDTO.getEmail(),
                passwordEncoder.encode(registroDTO.getPassword()), Arrays.asList(new Rol(rolNombre)));
        return usuarioRepositorio.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.findByEmail(username);
        if(usuario == null) {
            throw new UsernameNotFoundException("Usuario o password inválidos");
        }
        return new User(usuario.getEmail(), usuario.getPassword(), mapearAutoridadesRoles(usuario.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
    }
    
    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepositorio.findAll();
    }
    
    public void save(Usuario usuario) {
        usuarioRepositorio.save(usuario);
    }
    public void get(Long id) {
        usuarioRepositorio.findById(id).get();
    }
    public void delete(Long id) {
        usuarioRepositorio.deleteById(id);
    }
    
}

