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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.GeneroEntity;
import com.example.demo.entity.PeliculaEntity;
import com.example.demo.repository.GeneroRepository;
import com.example.demo.service.GeneroService;
import com.example.demo.service.PeliculaService;

@Controller
@RequestMapping("/peliculas")
public class PeliculaController {
	
	@Autowired
	private PeliculaService peliculaService;
	
	@Autowired
	private GeneroService generoService;
	
	@GetMapping("/listar")
    public String listarPeliculas(Model model) {
        model.addAttribute("peliculas", peliculaService.listarPeliculas());
        return "peliculas/listar";
    }
	
	@GetMapping("/crear")
    public String crearPeliculaForm(Model model) {
        model.addAttribute("pelicula", new PeliculaEntity());
        model.addAttribute("genero", generoService.listarGeneros());
        return "peliculas/crear";
    }

    @PostMapping("/crear")
    public String crearPelicula(@ModelAttribute("pelicula") PeliculaEntity pelicula,
                                @RequestParam("file") MultipartFile file,
                                RedirectAttributes redirectAttributes,
                                Model model) {
        peliculaService.guardarPelicula(pelicula, file);
        redirectAttributes.addFlashAttribute("success", "Película creada exitosamente!");
        return "redirect:/peliculas/listar";
    }
    
    @GetMapping("/editar/{id}")
    public String editarPeliculaForm(@PathVariable("id") Long id, Model model) {
        PeliculaEntity pelicula = peliculaService.obtenerPeliculaPorId(id).get();
        model.addAttribute("pelicula", pelicula);
        model.addAttribute("genero", generoService.listarGeneros());
        return "peliculas/editar";
    }

    @PostMapping("/editar/{id}")
    public String editarPelicula(@PathVariable("id") Long id,
                                 @ModelAttribute PeliculaEntity pelicula,
                                 @RequestParam("file") MultipartFile file,
                                 RedirectAttributes redirectAttributes) {
        pelicula.setPeliculaId(id);
        peliculaService.actualizarPelicula(pelicula, file);
        redirectAttributes.addFlashAttribute("success", "Película actualizada exitosamente!");
        return "redirect:/peliculas/listar";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminarPelicula(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        peliculaService.eliminarPelicula(id);
        redirectAttributes.addFlashAttribute("success", "Película eliminada exitosamente!");
        return "redirect:/peliculas/listar";
    }

    @GetMapping("/buscar")
    public String buscarPeliculas(@RequestParam(value = "titulo", required = false) String titulo,
                                  @RequestParam(value = "director", required = false) String director,
                                  @RequestParam(value = "generoId", required = false) Long generoId,
                                  Model model) {
        List<PeliculaEntity> peliculas;
        if (titulo != null && !titulo.isEmpty()) {
            peliculas = peliculaService.buscarPorTitulo(titulo);
        } else if (director != null && !director.isEmpty()) {
            peliculas = peliculaService.buscarPorDirector(director);
        } else if (generoId != null) {
            peliculas = peliculaService.buscarPorGeneroId(generoId);
        } else {
            peliculas = peliculaService.listarPeliculas();
        }
        model.addAttribute("peliculas", peliculas);
        return "peliculas/listar";
    }
}
