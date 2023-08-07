package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.service.UsuarioService;



@Controller
@RequestMapping("/")
public class ContactoController {
	@Autowired
	UsuarioService usuarioService;
		@GetMapping("/contacto")
		public String getIndexController(Model model) {
			
			if(this.usuarioService.obtenerSesionUsuario().getId()==null) {
				model.addAttribute("login", false);
				return "contacto";
			}else {
				model.addAttribute("login", true);
				return "contacto";
			}
			
		}
}