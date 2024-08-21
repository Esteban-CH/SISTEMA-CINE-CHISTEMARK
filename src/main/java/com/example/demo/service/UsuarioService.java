package com.example.demo.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.UsuarioEntity;

public interface UsuarioService {
	
	UsuarioEntity guardarUsuario(UsuarioEntity usuario, MultipartFile file);

    UsuarioEntity obtenerUsuarioPorId(Long id);

    UsuarioEntity obtenerUsuarioPorNombreUsuario(String nombreUsuario);

    List<UsuarioEntity> listarUsuarios();

    UsuarioEntity actualizarUsuario(UsuarioEntity usuario, MultipartFile file);

    void eliminarUsuario(Long id);

    boolean correoYaRegistrado(String correo);

    boolean dniYaRegistrado(Integer dni);

    List<UsuarioEntity> findByRolNombre(String rolNombre);
    
    boolean checkPassword(UsuarioEntity usuario, String password);
    
    boolean existsByNombreUsuario(String nombreUsuario);
}
