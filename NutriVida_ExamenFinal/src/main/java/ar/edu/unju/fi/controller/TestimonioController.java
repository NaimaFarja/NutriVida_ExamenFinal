package ar.edu.unju.fi.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Testimonio;
import ar.edu.unju.fi.service.TestimonioService;
import ar.edu.unju.fi.service.UsuarioService;

/**
 * Controlador que maneja las operaciones relacionadas con los testimonios de usuarios.
 */

public class TestimonioController {

	@Autowired
	TestimonioService testimonioService;
	@Autowired
	UsuarioService usuarioService;
	
	/**
     * Maneja la petición GET para mostrar la página de gestión de testimonios.
     * @param model Modelo para compartir datos con la vista.
     * @return Si el id no es de un admin muestra pagina de inicio.
     * @return Si el id es de un admin muestra la gestion donde se guardan los testimonios.
     */
	
	@GetMapping("/gestion-testimonio")
	public String getTestimonio(Model model) {
		if(this.usuarioService.obtenerSesionUsuario().getAdmin()==false) {
			model.addAttribute("login", false);
			return "redirect:/inicio";
		}else {
			model.addAttribute("login", true);
			model.addAttribute("admin", usuarioService.obtenerSesionUsuario().getAdmin().booleanValue());
			model.addAttribute("testimonio", testimonioService.obtenerTestimonios());
			return "gestion_testimonio";
		}
	}
	
	/**
     * Maneja la petición GET para mostrar el formulario de nuevo testimonio.
     * @param model Modelo para compartir datos con la vista.
     * @return La vista correspondiente segun el resultado de la condicion.
     */
	
	@GetMapping("/nuevo_testimonio")
	public String getNuevoTestimonio(Model model) {
		if(this.usuarioService.obtenerSesionUsuario().getId()==null) {
			model.addAttribute("login", false);
			return "redirect:/inicio";
		}else {
			model.addAttribute("login", true);
			model.addAttribute("admin", usuarioService.obtenerSesionUsuario().getAdmin().booleanValue());
			model.addAttribute("testimonio", new Testimonio());
			return "nuevo_testimonio";
		}
	}
	
	/*
	 * @param testimonio     Objeto Testimonio a ser guardado.
     * @param bindingResult  Resultado del proceso de validación.
     * @return Objeto ModelAndView con la vista y los atributos correspondientes.
     */
	
	@PostMapping("/nuevo_testimonio")
	public ModelAndView postNuevoTestamento(@Validated @ModelAttribute("testimonio") Testimonio testimonio,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			ModelAndView model = new ModelAndView("nuevo_testimonio");
			model.addObject("testimonio", testimonio);
			return model;
		}
		testimonio.setFecha(LocalDate.now());
		testimonio.setUsuario(usuarioService.obtenerSesionUsuario());
		testimonioService.agregarTestimonio(testimonio);
		ModelAndView model = new ModelAndView("redirect:/gestion-testimonio");
		return model;
	}
	
	/**
     * Maneja la petición GET para mostrar la página de testimonios donde se veran reflejados los testimonios para todos.
     * @param model Modelo para compartir datos con la vista.
     * @return Pagina donde se muestran los testimonios.
     */
	
	@GetMapping("/testimonios")
	public String getTest(Model model) {
		model.addAttribute("login", false);
		if(this.usuarioService.obtenerSesionUsuario().getId()!=null) {
			model.addAttribute("login", true);
			model.addAttribute("admin", usuarioService.obtenerSesionUsuario().getAdmin().booleanValue());
			model.addAttribute("idUsuario", usuarioService.obtenerSesionUsuario().getId());
		}
		model.addAttribute("testimonio", testimonioService.obtenerTestimonios());
		return "testimonio";
	}
	
	/**
     * Maneja la petición GET para eliminar un testimonio específico.
     * @param id    Identificador del testimonio a eliminar.
     * @param model Modelo para compartir datos con la vista.
     * @return Pagina donde se gestionan los testimonios después de eliminar.
     */
	
	@GetMapping("/eliminarTestimonio/{id}")
	public String getEliminarTestimonio(@PathVariable(value="id")Long id, Model model) {
		testimonioService.eliminarTestimonio(id);
		return "redirect:/gestion-testimonio";
	}
	
	/**
	 * Peticion GET, permite obtener el formulario para editar un testimonio en especifico.
	 * @param testimonio
	 * @param model
	 * @return
	 */
	
	@GetMapping("/editarTestimonio/{id}")
	public String getEditarUsuario(Testimonio testimonio, Model model){
		if(this.usuarioService.obtenerSesionUsuario().getAdmin()==false) {
			model.addAttribute("login", false);
			return "redirect:/inicio";
		}else {
			model.addAttribute("login", true);
			model.addAttribute("admin", usuarioService.obtenerSesionUsuario().getAdmin().booleanValue());
			testimonio = testimonioService.buscarTestimonioById(testimonio.getId());
			model.addAttribute("testimonio", testimonio);
			return "nuevo_testimonio";
		}
		
	}
	
}
