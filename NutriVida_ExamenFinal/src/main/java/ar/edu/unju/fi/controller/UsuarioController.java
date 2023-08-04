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

import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.service.UsuarioService;


@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	/**
	 * Peticion GET, permite obtener el formulario para el registro de un usuario.
	 * @param model
	 * @return
	 */
	@GetMapping("/registrarUsuario")
	public String getRegistrarUsuario(Model model){
		if(this.usuarioService.obtenerSesionUsuario().getId()==null) {
			model.addAttribute("login", false);
			model.addAttribute("usuario", new Usuario());
			return "registrar_usuario";
		}else {
			model.addAttribute("login", true);
			return "redirect:/inicio";
		}
		
	}
	
	/**
	 * Peticion GET, permite obtener el formulario para editar un usuario en especifico.
	 * @param usuario
	 * @param model
	 * @return
	 */
	@GetMapping("/editarUsuario/{id}")
	public String getEditarUsuario(Usuario usuario, Model model){
		if(this.usuarioService.obtenerSesionUsuario().getId()==null) {
			model.addAttribute("login", false);
			return "redirect:/inicio";
		}else {
			model.addAttribute("login", true);
			model.addAttribute("admin", usuarioService.obtenerSesionUsuario().getAdmin().booleanValue());
			usuario = usuarioService.buscarUsuarioById(usuario.getId());
			model.addAttribute("usuario", usuario);
			return "registrar_usuario";
		}
		
	}
	
	/**
	 * Peticion POST, permite verificar que los datos del usuario esten siendo ingresados correctamente.
	 * Luego registra al usuario en la BD.
	 * @param usuario
	 * @param bindingResult
	 * @return
	 */
	@PostMapping("/registrarUsuario")
	public ModelAndView postRegistrarUsuario(@Validated @ModelAttribute("usuario") Usuario usuario, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			ModelAndView model = new ModelAndView("registrar_usuario");
			model.addObject("usuario", usuario);
			return model;
		}
	
		
		
		usuarioService.agregarUsuario(usuario);
		ModelAndView model = new ModelAndView("index");
		model.addObject("login", false);
		model.addObject("msj","Bienvenido, tu codigo es " + usuario.getId() + " guardalo bien.");
		return model;
	}
	
	
	/**
	 * Peticion GET, permite obtener la pagina con todos los usuarios registrados.
	 * @param model
	 * @return
	 */
	@GetMapping("/usuarios")
	public String getUsuario(Model model) {
		if(this.usuarioService.obtenerSesionUsuario().getAdmin()==false) {
			model.addAttribute("login", false);
			return "redirect:/inicio";
		}else {
			model.addAttribute("login", true);
			model.addAttribute("admin", usuarioService.obtenerSesionUsuario().getAdmin().booleanValue());
			model.addAttribute("usuarios", usuarioService.obtenerUsuarios());
			return "usuarios";
		}
	}
	
	@GetMapping("/eliminarUsuario/{id}")
	public String getEliminarUsuario(@PathVariable(value="id")Long id, Model model) {
		usuarioService.eliminarUsuario(id);
		return "redirect:/usuarios";
	}
}

