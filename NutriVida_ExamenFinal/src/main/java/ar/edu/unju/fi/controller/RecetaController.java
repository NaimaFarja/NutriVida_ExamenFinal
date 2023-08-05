package ar.edu.unju.fi.controller;

import java.io.IOException;
//import java.net.MalformedURLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.Resource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.entity.Ingrediente;
import ar.edu.unju.fi.entity.Receta;
import ar.edu.unju.fi.service.IngredienteService;
import ar.edu.unju.fi.service.RecetaService;
import ar.edu.unju.fi.service.UsuarioService;
//import ar.edu.unju.fi.util.UploadFile;

@Controller
public class RecetaController {
	@Autowired
	private RecetaService recetaService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private IngredienteService ingredienteService;
	
	@Autowired
	//private UploadFile uploadFile;
	
	
	
	/**
	 * Muestra la lista de recetas en la vista "receta".
	 *
	 * @param model El modelo para enviar datos a la vista.
	 * @return El nombre de la vista "receta".
	 */
	@GetMapping("/receta")
	public String getObtenerRecetas(Model model) {
		model.addAttribute("login", false);
		if(this.usuarioService.obtenerSesionUsuario().getId()!=null) {
			model.addAttribute("login", true);
			model.addAttribute("admin", usuarioService.obtenerSesionUsuario().getAdmin().booleanValue());
		}
		model.addAttribute("receta",recetaService.obtenerRecetas());
		return "receta";
	}
	
	
	/**
	 * Muestra la página para crear una nueva receta si el usuario es administrador.
	 * Redirige a la página de inicio si el usuario no es administrador.
	 *
	 * @param model El modelo para enviar datos a la vista.
	 * @return El nombre de la vista "receta_nueva" si el usuario es administrador, de lo contrario, redirige a la página de inicio.
	 */
	@GetMapping("/receta_nueva")
	public String recetaNueva(Model model) {
		if(this.usuarioService.obtenerSesionUsuario().getAdmin()==false) {
			model.addAttribute("login", false);
			return "redirect:/inicio";
		}else {
			model.addAttribute("admin", usuarioService.obtenerSesionUsuario().getAdmin().booleanValue());
			List<Ingrediente> ingredientes = ingredienteService.obtenerIngredientes();
			model.addAttribute("ingredientes", ingredientes);
			model.addAttribute("receta", new Receta());
			return "receta_nueva";
		}
	}
	
	
	/**
	 * Registra una nueva receta si los datos proporcionados son válidos.
	 *
	 * @param receta         El objeto Receta a registrar.
	 * @param bindingResult  El resultado del proceso de validación.
	 * @param image          La imagen relacionada con la receta.
	 * @return Una vista ModelAndView con la página de registro de recetas si hay errores de validación, o redirige a la página de recetas.
	 * @throws IOException Si ocurre un error al manejar la imagen.
	 */
	@PostMapping("/receta_nueva")
	public ModelAndView postRecetaNueva(@Validated @ModelAttribute("receta") Receta receta, BindingResult bindingResult, @RequestParam("file") MultipartFile image) throws IOException {
		if(bindingResult.hasErrors() || (image.isEmpty() && receta.getId()==null)) {
			ModelAndView model = new ModelAndView("receta_nueva");
			List<Ingrediente> ingredientes = ingredienteService.obtenerIngredientes();
			model.addObject("ingredientes", ingredientes);
			model.addObject("receta", receta);
			if(image.isEmpty() && receta.getId()==null) {
				model.addObject("vacio", true);
			}
			return model;
		}
		if(!image.isEmpty()){ //Si se cargo una imagen
			if(receta.getImagen() != null) { // Y receta tiene una imagen
				//uploadFile.delete(receta.getImagen()); // Se borra la anterior
			}
			//String uniqueFileName = uploadFile.copy(image); 
			//receta.setImagen(uniqueFileName);
        }else {
        	if(receta.getId()!=null && recetaService.buscarRecetaById(receta.getId()).getImagen()!=null) {
        		receta.setImagen(recetaService.buscarRecetaById(receta.getId()).getImagen());
        	}
        }
		recetaService.agregarReceta(receta);
		ModelAndView model = new ModelAndView("redirect:/receta");
		return model;
	}
	
	
	/**
	 * Muestra la página de gestión de recetas si el usuario es administrador.
	 * Redirige a la página de inicio si el usuario no es administrador.
	 *
	 * @param model El modelo para enviar datos a la vista.
	 * @return El nombre de la vista "gestion_receta" si el usuario es administrador, de lo contrario, redirige a la página de inicio.
	 */
	@GetMapping("/gestion-receta")
	public String getReceta(Model model) {
		if(this.usuarioService.obtenerSesionUsuario().getAdmin()==false) {
			model.addAttribute("login", false);
			return "redirect:/inicio";
		}else {
			model.addAttribute("login", true);
			model.addAttribute("admin", usuarioService.obtenerSesionUsuario().getAdmin().booleanValue());
			model.addAttribute("recetas", recetaService.obtenerRecetas());
			return "gestion_receta";
		}
	}
	
	
	/**
	 * Elimina una receta existente según el id proporcionado si el usuario es administrador.
	 *
	 * @param id    El id de la receta a eliminar.
	 * @param model El modelo para enviar datos a la vista.
	 * @return Redirige a la página de gestión de recetas después de eliminar la receta.
	 */
	@GetMapping("/eliminarReceta/{id}")
	public String getEliminarReceta(@PathVariable(value="id")Long id, Model model) {
		recetaService.eliminarReceta(id);
		return "redirect:/gestion-receta";
	}
	

	
	
	/**
	 * Muestra la página para editar una receta existente si el usuario es administrador.
	 * Redirige a la página de inicio si el usuario no es administrador.
	 *
	 * @param receta El objeto Receta a editar.
	 * @param model  El modelo para enviar datos a la vista.
	 * @return El nombre de la vista "receta_nueva" con los datos de la receta a editar si el usuario es administrador, de lo contrario, redirige a la página de inicio.
	 */
	@GetMapping("/editarReceta/{id}")
	public String getEditarUsuario(Receta receta, Model model){
		if(this.usuarioService.obtenerSesionUsuario().getId()==null) {
			model.addAttribute("login", false);
			return "redirect:/inicio";
		}else {
			model.addAttribute("login", true);
			receta = recetaService.buscarRecetaById(receta.getId());
			List<Ingrediente> ingredientes = ingredienteService.obtenerIngredientes();
			model.addAttribute("ingredientes", ingredientes);
			model.addAttribute("receta", receta);
			return "receta_nueva";
		}
		
	}
	
	
	/**
	 * Permite cargar una imagen.
	 *
	 * @param filename El nombre de archivo de la imagen.
	 * @return La imagen en una respuesta HTTP.
	 */
	/* @GetMapping("/recetas/uploads/{filename}")
    public ResponseEntity<Resource> cargarImagen(@PathVariable String filename){
        Resource resource = null;
        try{
            resource = uploadFile.load(filename);
        }catch (MalformedURLException e ){
            e.printStackTrace();
        }return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }*/
	//EDITANDO
}