package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.service.UsuarioService;


@Controller
public class InicioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	/**
	 * Peticion GET, permite obtener la vista de inicio.
	 * @param model
	 * @return
	 */
	@GetMapping({"/inicio","/"})
	public String getInicio(Model model){
		if(this.usuarioService.obtenerSesionUsuario().getId()==null) {
			model.addAttribute("login", false);
		}else {
			model.addAttribute("login", true);
			model.addAttribute("admin", usuarioService.obtenerSesionUsuario().getAdmin().booleanValue());
		}
		return "index";
	}
	
	/**
	 * Peticion GET, devuelve la pagina "not_found" en caso de que la URL no 'exista'.
	 * @return
	 */
	@GetMapping("/*")
	public String getNotFound(Model model){
		if(this.usuarioService.obtenerSesionUsuario().getId()==null) {
			model.addAttribute("login", false);
		}else {
			model.addAttribute("login", true);
			model.addAttribute("admin", usuarioService.obtenerSesionUsuario().getAdmin().booleanValue());
		}
		return "not_found";
	}
	
	/**
     * Maneja la petición GET para mostrar la página de inicio de sesión.
     * @param model Modelo para compartir datos con la vista.
     * @return Formulario de inicio de sesion.
     * @return Pagina de inicio de sesion
     */
	
	@GetMapping("/iniciarSesion")
	public String getIniciarSesion(Model model) {
		model.addAttribute("login", false);
		if(this.usuarioService.obtenerSesionUsuario().getId()==null) {
			return "iniciar_sesion";
		}else {
			System.out.println("Ya ha iniciado sesion");
			return "redirect:/inicio";
		}
	}
	
	/**
     * Maneja la petición POST para iniciar sesión.
     * @param idUser Identificador del usuario a iniciar sesión.
     * @return Objeto ModelAndView con la vista y los atributos correspondientes.
     */
	
	@PostMapping("/iniciarSesion")
	public ModelAndView postIniciarSesion(@RequestParam String idUser) {
		ModelAndView modelview;
		if(idUser.equals(null) || idUser==""){
			modelview = new ModelAndView("iniciar_sesion");
			modelview.addObject("login", false);
			modelview.addObject("error", "Ingrese un ID valido.");
	    }else {
	    	Usuario usuario = usuarioService.buscarUsuarioById(Long.parseLong(idUser));
	    	if(usuario!=null){
	    		modelview = new ModelAndView("redirect:/inicio");
	    		usuarioService.iniciarSesion(usuario);
	    	}else {
	    		modelview = new ModelAndView("iniciar_sesion");
	    		modelview.addObject("login", false);
	    		modelview.addObject("error", "No existe usuario registrado con tal ID.");
	    	}
	    	
	    }
		return modelview;
	}
	
	/**
     * Maneja la petición GET para cerrar la sesión del usuario.
     * @return Pagina de inicio.
     */
	
	@GetMapping("/cerrarSesion")
	public String getCerrarSesion() {
		this.usuarioService.iniciarSesion(new Usuario());
		return "redirect:/inicio";
	}
}

