package com.udemy.springboot.web.app.controllers;


import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udemy.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	@GetMapping({ "/index", "/", "/home", "" })
	public String index(Model model) {
		model.addAttribute("titulo", "Curso spring");
		return "index";
	}

	@GetMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Henry");
		usuario.setApellido("Rincon");
		usuario.setEmail("correo@correo.com");
		model.addAttribute("titulo", "Curso spring ".concat(usuario.getNombre()));
		model.addAttribute("usuario", usuario);
		return "perfil";
	}

	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de usuarios");
		return "listar";
	}

	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios() {
		List<Usuario> usuarios = Arrays.asList(new Usuario("Andres", "Duarte", "test1@test.com"),
				new Usuario("Felipe", "Coanon", "test2@test.com"), new Usuario("Henry", "Rincon", "test3@test.com"),
				new Usuario("Juan", "Rincon", "test4@test.com"));
		return usuarios;
	}
}
