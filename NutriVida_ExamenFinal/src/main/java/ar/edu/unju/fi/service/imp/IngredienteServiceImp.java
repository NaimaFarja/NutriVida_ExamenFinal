package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Ingrediente;
import ar.edu.unju.fi.repository.IngredienteRepository;
import ar.edu.unju.fi.service.IngredienteService;


/**
 * Esta clase es una implementación de la interfaz IngredienteService y se encarga de brindar los servicios relacionados con la entidad Ingrediente.
 * Los servicios implementados realizan operaciones CRUD (Create, Read, Update, Delete) y otras operaciones relacionadas con Ingrediente.
 */
@Service
public class IngredienteServiceImp implements IngredienteService {
	
	@Autowired
	IngredienteRepository ingredienteRepository;

	
	/**
     * Agrega un nuevo Ingrediente a la base de datos.
     *
     * @param ingrediente El objeto Ingrediente a agregar.
     */
	@Override
	public void agregarIngrediente(Ingrediente ingrediente) {
		ingredienteRepository.save(ingrediente);
	}

	
	/**
     * Elimina un Ingrediente de la base de datos según su identificador.
     *
     * @param id El identificador del Ingrediente a eliminar.
     */
	@Override
	public void eliminarIngrediente(Long id) {
		ingredienteRepository.deleteById(id);
	}
	
	

	 /**
     * Busca un Ingrediente en la base de datos por su identificador.
     *
     * @param id El identificador del Ingrediente a buscar.
     * @return El objeto Ingrediente encontrado o null si no existe.
     */
	@Override
	public Ingrediente buscarIngredienteById(Long id) {
		Optional<Ingrediente> ingrediente = ingredienteRepository.findById(id);
		return ingrediente.orElse(null);
	}

	
	 /**
     * Obtiene una lista de todos los Ingredientes almacenados en la base de datos.
     *
     * @return Una lista que contiene todos los objetos Ingrediente en la base de datos.
     */
	@Override
	public List<Ingrediente> obtenerIngredientes(){
		return (List<Ingrediente>) ingredienteRepository.findAll();
	}
}