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

/**
 * Controlador para gestionar las operaciones relacionadas con los usuarios.
 */

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	/**
     * Maneja la petición GET para obtener el formulario de registro de un nuevo usuario.
     * @param model Modelo utilizado para transmitir datos a la vista.
     * @return formulario para registrar un nuevo usurio.
     * @return Pagina de inicio
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
     * Maneja la petición GET para obtener el formulario de edición de un usuario específico.
     *
     * @param usuario Usuario que sera modificado.
     * @param model   Modelo utilizado para transmitir datos a la vista.
     * @return formulario para modificar los datos.
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
     * Maneja la petición POST para registrar un nuevo usuario.
     * @param usuario        Objeto Usuario obtenido del formulario.
     * @param bindingResult  Resultado de la validación del formulario.
     * @return Modelo y vista que se mostrará después del procesamiento.
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
     * Maneja la petición GET para obtener la página con la lista de todos los usuarios registrados.
     *
     * @param model Modelo utilizado para transmitir datos a la vista.
     * @return Si el id ingresado no es admi muestra la pagina de inicio.
     * @return Si el id es admi muestra la pagina donde se encuntra todos los registros de usuarios.
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
	/**
     * Maneja la petición GET para eliminar un usuario por su ID.
     * @param id    ID del usuario a eliminar.
     * @param model Modelo utilizado para transmitir datos a la vista.
     * @return Redirecciona a la lista de usuarios después de la eliminación.
     */
	@GetMapping("/eliminarUsuario/{id}")
	public String getEliminarUsuario(@PathVariable(value="id")Long id, Model model) {
		usuarioService.eliminarUsuario(id);
		return "redirect:/usuarios";
	}
}