package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.RolEntity;
import com.example.demo.entity.UsuarioEntity;
import com.example.demo.repository.RolRepository;
import com.example.demo.service.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RolRepository rolRepository;

    @GetMapping("/nuevo")
    public String mostrarFormularioCreacion(Model model) {
        model.addAttribute("usuario", new UsuarioEntity());
        model.addAttribute("roles", rolRepository.findAll());
        return "usuarios/formulario";
    }

    @PostMapping("/guardar")
    public String guardarUsuario(@ModelAttribute UsuarioEntity usuario, 
                                 @RequestParam Long rolId, 
                                 @RequestParam("file") MultipartFile file) {
        RolEntity rol = rolRepository.findById(rolId).get();
        usuario.setRol(rol);
        usuarioService.guardarUsuario(usuario, file);
        return "redirect:/usuarios"; // Redirige a la vista de usuarios
    }

    @GetMapping("/{id}")
    public String mostrarDetalles(@PathVariable Long id, Model model) {
        UsuarioEntity usuario = usuarioService.obtenerUsuarioPorId(id);
        model.addAttribute("usuario", usuario);
        return "usuarios/detalle";
    }

    @GetMapping
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.listarUsuarios());
        return "usuarios/listar";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        UsuarioEntity usuario = usuarioService.obtenerUsuarioPorId(id);
        model.addAttribute("usuario", usuario);
        model.addAttribute("roles", rolRepository.findAll());
        return "usuarios/editar";
    }

    @PostMapping("/actualizar")
    public String actualizarUsuario(@ModelAttribute UsuarioEntity usuario,
                                    @RequestParam Long rolId,
                                    @RequestParam("file") MultipartFile file) {
        RolEntity rol = rolRepository.findById(rolId).get();
        usuario.setRol(rol);
        usuarioService.actualizarUsuario(usuario, file);
        return "redirect:/usuarios";
    }


    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return "redirect:/usuarios";
    }
    
}
