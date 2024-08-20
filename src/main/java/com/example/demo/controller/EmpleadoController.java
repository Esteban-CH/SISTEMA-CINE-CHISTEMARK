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
@RequestMapping("/empleado")
public class EmpleadoController {
	
	@Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RolRepository rolRepository;

    @GetMapping("/lista")
    public String listaEmpleados(Model model) {
        List<UsuarioEntity> empleados = usuarioService.findByRolNombre("EMPLEADO");
        model.addAttribute("usuarios", empleados);
        return "empleado/listaEmpleado";
    }

    @GetMapping("/nuevo")
    public String nuevoEmpleadoForm(Model model) {
        UsuarioEntity empleado = new UsuarioEntity();
        RolEntity rolEmpleado = rolRepository.findByNombre("EMPLEADO").get();
        empleado.setRol(rolEmpleado);
        model.addAttribute("empleado", empleado);
        return "empleado/formularioEmpleado";
    }

    @PostMapping("/guardar")
    public String guardarEmpleado(@ModelAttribute("empleado") UsuarioEntity empleado) {
        RolEntity rolEmpleado = rolRepository.findByNombre("EMPLEADO").get();
        empleado.setRol(rolEmpleado);
        usuarioService.guardarUsuario(empleado);
        return "redirect:/empleado/lista";
    }

    @GetMapping("/{id}/editar")
    public String editarEmpleado(@PathVariable Long id, Model model) {
        UsuarioEntity usuario = usuarioService.obtenerUsuarioPorId(id);
        if (usuario == null) {
            return "redirect:/empleado/lista";
        }
        model.addAttribute("usuario", usuario);
        return "empleado/editarEmpleado";
    }

    @PostMapping("/actualizar")
    public String actualizarEmpleado(@ModelAttribute UsuarioEntity usuario) {
        RolEntity rolEmpleado = rolRepository.findByNombre("EMPLEADO").get();
        usuario.setRol(rolEmpleado);
        usuarioService.actualizarUsuario(usuario);
        return "redirect:/empleado/lista";
    }

    @GetMapping("/{id}/eliminar")
    public String eliminarEmpleado(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return "redirect:/empleado/lista";
    }
}
