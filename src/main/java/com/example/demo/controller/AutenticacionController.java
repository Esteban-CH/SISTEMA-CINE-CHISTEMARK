package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.RolEntity;
import com.example.demo.entity.UsuarioEntity;
import com.example.demo.repository.RolRepository;
import com.example.demo.service.UsuarioService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AutenticacionController {

	@Autowired
	private UsuarioService usuarioService;
    
	@Autowired
	private RolRepository rolRepository;
    
    @GetMapping("/login")
    public String loginForm() {
        return "iniciarSesion/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("nombreUsuario") String nombreUsuario,
                        @RequestParam("clave") String clave,
                        HttpSession session,
                        RedirectAttributes redirectAttributes) {
        UsuarioEntity user = usuarioService.obtenerUsuarioPorNombreUsuario(nombreUsuario);
        if (user != null && usuarioService.checkPassword(user, clave)) {
            session.setAttribute("usuario", user);
            String rolNombre = user.getRol().getNombre();
            switch (rolNombre) {
                case "CLIENTE":
                    return "redirect:/cliente/bienvenido";
                case "ADMIN":
                case "EMPLEADO":
                    return "redirect:/trabajadores/bienvenido";
                default:
                    redirectAttributes.addFlashAttribute("error", "Rol desconocido.");
                    return "redirect:/login";
            }
        } else {
            redirectAttributes.addFlashAttribute("error", "Usuario o contraseña inválidos.");
            return "redirect:/login";
        }
    }

    
    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("cliente", new UsuarioEntity());
        return "iniciarSesion/register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UsuarioEntity cliente, RedirectAttributes redirectAttributes) {
        if (usuarioService.correoYaRegistrado(cliente.getCorreo())) {
            redirectAttributes.addFlashAttribute("error", "El correo ya está registrado.");
            return "redirect:/register";
        }

        if (usuarioService.dniYaRegistrado(cliente.getDni())) {
            redirectAttributes.addFlashAttribute("error", "El DNI ya está registrado.");
            return "redirect:/register";
        }

        RolEntity rolCliente = rolRepository.findByNombre("CLIENTE").get();
        cliente.setRol(rolCliente);
        cliente.setClave(cliente.getClave());
        usuarioService.guardarUsuario(cliente);
        redirectAttributes.addFlashAttribute("success", "Registro exitoso!");
        return "redirect:/login";
    }
}
