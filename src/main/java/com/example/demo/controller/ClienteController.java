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
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RolRepository rolRepository;

    @GetMapping("/lista")
    public String listaClientes(Model model) {
        List<UsuarioEntity> clientes = usuarioService.findByRolNombre("CLIENTE");
        model.addAttribute("usuarios", clientes);
        return "cliente/listaCliente";
    }


    @GetMapping("/nuevo")
    public String nuevoClienteForm(Model model) {
        UsuarioEntity cliente = new UsuarioEntity();
        RolEntity rolCliente = rolRepository.findByNombre("CLIENTE").get();
        cliente.setRol(rolCliente);
        model.addAttribute("cliente", cliente);
        return "cliente/formularioCliente";
    }


    @PostMapping("/guardar")
    public String guardarCliente(@ModelAttribute("cliente") UsuarioEntity cliente) {
        RolEntity rolCliente = rolRepository.findByNombre("CLIENTE").get();
        cliente.setRol(rolCliente);
        usuarioService.guardarUsuario(cliente);
        return "redirect:/cliente/lista";
    }

    @GetMapping("/{id}/editar")
    public String editarCliente(@PathVariable Long id, Model model) {
        UsuarioEntity usuario = usuarioService.obtenerUsuarioPorId(id);
        if (usuario == null) {
            return "redirect:/cliente/lista";
        }
        model.addAttribute("usuario", usuario);
        return "cliente/editarCliente";
    }

    @PostMapping("/actualizar")
    public String actualizarCliente(@ModelAttribute UsuarioEntity usuario) {
        RolEntity rolCliente = rolRepository.findByNombre("CLIENTE").get();
        usuario.setRol(rolCliente);
        usuarioService.actualizarUsuario(usuario);
        return "redirect:/cliente/lista";
    }


    @GetMapping("/{id}/eliminar")
    public String eliminarCliente(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return "redirect:/cliente/lista";
    }
}
