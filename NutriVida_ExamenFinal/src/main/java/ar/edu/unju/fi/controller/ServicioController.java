package ar.edu.unju.fi.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;



import ar.edu.unju.fi.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.service.ImcService;
import ar.edu.unju.fi.service.UsuarioService;
@Controller
public class ServicioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	ImcService imcService;
	
	
	
	/**
	 * Método para manejar la solicitud GET en la ruta "/imc".
	 *
	 * @return El nombre de la vista "imc".
	 * @GetMapping Indica que este método maneja solicitudes HTTP GET en la ruta especificada.
	 */

	@GetMapping("/imc")
	public String getIMC(Model model) {
		if(this.usuarioService.obtenerSesionUsuario().getId()==null) {
			return "redirect:/inicio";
		}else {
			model.addAttribute("login", true);
			model.addAttribute("admin", usuarioService.obtenerSesionUsuario().getAdmin().booleanValue());
			model.addAttribute("imc", new IndiceMasaCorporal());
			System.out.println(imcService.obtenerImcByUsuario(usuarioService.obtenerSesionUsuario()).size());
			model.addAttribute("resultados",imcService.obtenerImcByUsuario(usuarioService.obtenerSesionUsuario()));
			return "imc";
		}
	}
	
	/**
	 * Maneja la petición POST para calcular y registrar el Índice de Masa Corporal (IMC) de un usuario.
	 * @param indiceMasaCorporal Objeto IndiceMasaCorporal que contiene los datos del cálculo IMC.
	 * @param bindingResult Resultado del proceso de validación.
	 * @return Objeto ModelAndView con la vista y los atributos correspondientes.
	 */
	
	@PostMapping("/imc")
	public ModelAndView postIMC(@Validated @ModelAttribute("imc") IndiceMasaCorporal indiceMasaCorporal, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			ModelAndView model = new ModelAndView("imc");
			model.addObject("login", true);
			model.addObject("admin", usuarioService.obtenerSesionUsuario().getAdmin().booleanValue());
			model.addObject("imc", indiceMasaCorporal);
			return model;
		}
		ModelAndView model = new ModelAndView("redirect:/imc");
		indiceMasaCorporal.setFecha(LocalDate.now());
		indiceMasaCorporal.setUsuario(usuarioService.obtenerSesionUsuario());
		indiceMasaCorporal.calcularImc();
		System.out.println(indiceMasaCorporal.getEstado());
		imcService.agregarImc(indiceMasaCorporal);
		return model;
	}
	
	
	
	/**
	 * Método para manejar la solicitud GET en la ruta "/peso-ideal".
	 *
	 * @return El nombre de la vista "peso_ideal".
	 * @GetMapping Indica que este método maneja solicitudes HTTP GET en la ruta especificada.
	 */
	
	@GetMapping("/peso-ideal")
	public String getPesoIdeal(Model model) {
		if(this.usuarioService.obtenerSesionUsuario().getId()==null) {
			return "redirect:/inicio";
		}else {
			model.addAttribute("login", true);
			model.addAttribute("admin", usuarioService.obtenerSesionUsuario().getAdmin().booleanValue());
			model.addAttribute("edad", usuarioService.obtenerSesionUsuario().calcularEdad());
		//	model.addAttribute("pesoIdeal",  usuarioService.obtenerSesionUsuario().calcularPesoIdeal());
			return "peso_ideal";
		}
		
	}
	
}
