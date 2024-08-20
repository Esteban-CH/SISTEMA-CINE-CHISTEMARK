package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.UsuarioEntity;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@GetMapping("/cliente/bienvenido")
	public String bienvenidaCliente(HttpSession session, Model model) {
	    UsuarioEntity usuario = (UsuarioEntity) session.getAttribute("usuario");
	    if (usuario != null && "CLIENTE".equals(usuario.getRol().getNombre())) {
	        model.addAttribute("usuario", usuario);
	        model.addAttribute("nombreCompleto", usuario.getNombre() + " " + usuario.getApellido());
	        return "home/bienvenidoCliente";
	    }
	    return "redirect:/login";
	}

	@GetMapping("/trabajadores/bienvenido")
	public String bienvenidaTrabajadores(HttpSession session, Model model) {
	    UsuarioEntity usuario = (UsuarioEntity) session.getAttribute("usuario");
	    if (usuario != null && ("ADMIN".equals(usuario.getRol().getNombre()) || "EMPLEADO".equals(usuario.getRol().getNombre()))) {
	        model.addAttribute("usuario", usuario);
	        model.addAttribute("nombreCompleto", usuario.getNombre() + " " + usuario.getApellido());
	        return "home/bienvenidoTrabajadores";
	    }
	    return "redirect:/login";
	}
}
