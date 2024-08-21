package com.example.demo.service.impl;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.UsuarioEntity;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.service.UsuarioService;
import com.example.demo.utils.Utilitarios;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
    private UsuarioRepository usuarioRepository;
	
    @Override
    public UsuarioEntity guardarUsuario(UsuarioEntity usuario, MultipartFile file) {
    	if (file != null && !file.isEmpty()) {
            String nombreImagen = Utilitarios.Imagen(file);
            usuario.setUrlImagen(nombreImagen); // Guarda el nombre de la imagen en la BD
        }
    	return usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioEntity obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).get();
    }

    @Override
    public UsuarioEntity obtenerUsuarioPorNombreUsuario(String nombreUsuario) {
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    @Override
    public List<UsuarioEntity> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public UsuarioEntity actualizarUsuario(UsuarioEntity usuario, MultipartFile file) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public boolean correoYaRegistrado(String correo) {
        return usuarioRepository.existsByCorreo(correo);
    }

    @Override
    public boolean dniYaRegistrado(Integer dni) {
        return usuarioRepository.existsByDni(dni);
    }

	@Override
	public List<UsuarioEntity> findByRolNombre(String rolNombre) {
		return usuarioRepository.findByRolNombre(rolNombre);
	}

	@Override
	public boolean existsByNombreUsuario(String nombreUsuario) {
		return usuarioRepository.findByNombreUsuario(nombreUsuario) != null;
	}

	@Override
	public boolean checkPassword(UsuarioEntity usuario, String password) {
		return usuario.getClave().equals(password)	;
	}
	
	private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
