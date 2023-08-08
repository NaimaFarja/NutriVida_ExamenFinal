package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
		@GetMapping("/contacto")
		public String getContactoController(Model model) {
			return "contacto";
		}
}