package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.RolEntity;
import com.example.demo.entity.UsuarioEntity;
import com.example.demo.repository.RolRepository;
import com.example.demo.service.UsuarioService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
    private RolRepository rolRepository;
	 
	@GetMapping("/lista")
    public String listaAdmin(Model model) {
		List<UsuarioEntity> admins = usuarioService.findByRolNombre("ADMIN");
		model.addAttribute("usuarios", admins);
		return "admin/listaAdmin";
	}
	
	@GetMapping("/nuevo")
	public String nuevoAdminForm(Model model) {
	    UsuarioEntity admin = new UsuarioEntity();
	    RolEntity rolAdmin = rolRepository.findByNombre("ADMIN").get();
	    admin.setRol(rolAdmin);
	    model.addAttribute("admin", admin);
	    return "admin/formularioAdmin";
	}

	@PostMapping("/guardar")
	public String guardarAdmin(@ModelAttribute("admin") UsuarioEntity admin) {
	    RolEntity rolAdmin = rolRepository.findByNombre("ADMIN").get();
	    if (rolAdmin == null) {
	        rolAdmin = new RolEntity();
	        rolAdmin.setNombre("ADMIN");
	        rolRepository.save(rolAdmin);
	    }
	    admin.setRol(rolAdmin);
	    usuarioService.guardarUsuario(admin);
	    return "redirect:/admin/lista";
	}
	
	@GetMapping("/{id}/editar")
	public String editarAdmin(@PathVariable Long id, Model model) {
	    UsuarioEntity usuario = usuarioService.obtenerUsuarioPorId(id);
	    if (usuario == null) {
	        return "redirect:/admin/lista";
	    }
	    model.addAttribute("usuario", usuario);
	    return "admin/editarAdmin";  // Asegúrate de que la vista se llama "editarAdmin.html"
	}

	@PostMapping("/actualizar")
	public String actualizarAdmin(@ModelAttribute UsuarioEntity usuario) {
	    // Asegúrate de que el rol es siempre Admin (puedes ajustar el ID según tu base de datos)
	    RolEntity adminRole = rolRepository.findByNombre("ADMIN").get();
	    usuario.setRol(adminRole);
	    usuarioService.actualizarUsuario(usuario);
	    return "redirect:/admin/lista";
	}

    @GetMapping("/{id}/eliminar")
    public String eliminarAdmin(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return "redirect:/admin/lista";
    }
}
