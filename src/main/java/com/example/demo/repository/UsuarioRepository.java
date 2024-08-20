package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.UsuarioEntity;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{
	
	List<UsuarioEntity> findByRolNombre(String rolNombre);
	
	UsuarioEntity findByNombreUsuario(String nombreUsuario);
    
	boolean existsByCorreo(String correo);
    
	boolean existsByDni(Integer dni);
}
