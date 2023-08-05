package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Ingrediente;
import ar.edu.unju.fi.service.IngredienteService;
import ar.edu.unju.fi.service.UsuarioService;

@Controller
public class IngredienteController {

	@Autowired
	private IngredienteService ingredienteService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	/**
	 * Muestra la lista de ingredientes en la vista si el usuario es administrador.
	 * Redirige a la página de inicio si el usuario no es administrador.
	 *
	 * @param model El modelo para enviar datos a la vista.
	 * @return La vista "ingredientes" si el usuario es administrador, de lo contrario, redirige a la página de inicio.
	 */
	@GetMapping("/ingredientes")
	public String getIngredientes(Model model) {
		if(this.usuarioService.obtenerSesionUsuario().getAdmin()==false) {
			model.addAttribute("login", false);
			return "redirect:/inicio";
		}else {
			model.addAttribute("login", true);
			model.addAttribute("admin", usuarioService.obtenerSesionUsuario().getAdmin().booleanValue());
			model.addAttribute("ingredientes", ingredienteService.obtenerIngredientes());
			return "ingredientes";
		}
	}
	
	
	
	/**
	 * Muestra la página de registro de un nuevo ingrediente si el usuario es administrador.
	 * Redirige a la página de inicio si el usuario no es administrador.
	 *
	 * @param model El modelo para enviar datos a la vista.
	 * @return La vista "registrar_ingrediente" si el usuario es administrador, de lo contrario, redirige a la página de inicio.
	 */
	@GetMapping("/registrarIngrediente")
	public String getRegistrarIngrediente(Model model) {
		if(this.usuarioService.obtenerSesionUsuario().getAdmin()==false) {
			model.addAttribute("login", false);
			return "redirect:/inicio";
		}else {
			model.addAttribute("admin", usuarioService.obtenerSesionUsuario().getAdmin().booleanValue());
			model.addAttribute("ingrediente", new Ingrediente());
			return "registrar_ingrediente";
		}
	}
	
	
	/**
	 * Registra un nuevo ingrediente si los datos proporcionados son válidos.
	 *
	 * @param ingrediente     El objeto Ingrediente a registrar.
	 * @param bindingResult   El resultado del proceso de validación.
	 * @return Una vista ModelAndView con la página de registro de ingredientes si hay errores de validación, o redirige a la página de ingredientes.
	 */
	@PostMapping("/registrarIngrediente")
	public ModelAndView postRegistrarIngrediente(@Validated @ModelAttribute("ingrediente") Ingrediente ingrediente, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			ModelAndView model = new ModelAndView("registrar_ingrediente");
			model.addObject("ingrediente", ingrediente);
			return model;
		}
		ingredienteService.agregarIngrediente(ingrediente);
		ModelAndView model = new ModelAndView("redirect:/ingredientes");
		return model;
	}
	
	
	
	/**
	 * Muestra la página de edición de un ingrediente existente si el usuario es administrador.
	 * Redirige a la página de inicio si el usuario no es administrador.
	 *
	 * @param ingrediente El objeto Ingrediente a editar.
	 * @param model       El modelo para enviar datos a la vista.
	 * @return La vista "registrar_ingrediente" con los datos del ingrediente a editar si el usuario es administrador, de lo contrario, redirige a la página de inicio.
	 */
	@GetMapping("/editarIngrediente/{id}")
	public String getEditarIngrediente(Ingrediente ingrediente, Model model){
		if(this.usuarioService.obtenerSesionUsuario().getAdmin()==false) {
			model.addAttribute("login", false);
			return "redirect:/inicio";
		}else {
			model.addAttribute("login", true);
			model.addAttribute("admin", usuarioService.obtenerSesionUsuario().getAdmin().booleanValue());
			ingrediente = ingredienteService.buscarIngredienteById(ingrediente.getId());
			model.addAttribute("ingrediente", ingrediente);
			return "registrar_ingrediente";
		}
	}
	
	
	/**
	 * Elimina un ingrediente existente según el id proporcionado si el usuario es administrador.
	 *
	 * @param id    El id del ingrediente a eliminar.
	 * @param model El modelo para enviar datos a la vista.
	 * @return Redirige a la página de ingredientes después de eliminar el ingrediente.
	 */
	@GetMapping("/eliminarIngrediente/{id}")
	public String getEliminarUsuario(@PathVariable(value="id")Long id, Model model) {
		ingredienteService.eliminarIngrediente(id);
		return "redirect:/ingredientes";
	}
}