package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import ar.edu.unju.fi.service.UsuarioService;



/**
 * Esta clase es un controlador que maneja las solicitudes relacionadas con la página de contacto.
 * 
 */
@Controller
@RequestMapping("/")
public class ContactoController {

	
	/**
	 * Maneja la solicitud GET para acceder a la página de contacto.
	 * 
	 * @param model El objeto Model utilizado para pasar datos a la vista.
	 * @return El nombre de la vista de la página de contacto ("contacto").
	 */
	
		

	@Autowired
	UsuarioService usuarioService;
		@GetMapping("/contacto")
		public String getIndexController(Model model) {
			
			if(this.usuarioService.obtenerSesionUsuario().getId()==null) {
				model.addAttribute("login", false);
				return "contacto";
			}else {
				model.addAttribute("login", true);
				model.addAttribute("admin", usuarioService.obtenerSesionUsuario().getAdmin().booleanValue());
				return "contacto";
			}
			

		}
}