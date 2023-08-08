package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Ingrediente;
import ar.edu.unju.fi.repository.IngredienteRepository;
import ar.edu.unju.fi.service.IngredienteService;

/**
 * Esta clase implementa la interfaz IngredienteService y define los métodos para gestionar los ingredientes.
 * 
 * La clase proporciona operaciones para agregar, eliminar, buscar por ID y obtener todos los ingredientes.
 */

@Service
public class IngredienteServiceImp implements IngredienteService {
	
	@Autowired
	IngredienteRepository ingredienteRepository;
	
	/**
	 * Agrega un nuevo ingrediente a la base de datos.
	 * 
	 * @param ingrediente El objeto Ingrediente que representa el registro de ingrediente a ser agregado.
	 */

	@Override
	public void agregarIngrediente(Ingrediente ingrediente) {
		ingredienteRepository.save(ingrediente);
	}
	
	/**
	 * Elimina un ingrediente de la base de datos por su ID.
	 * 
	 * @param id El ID del ingrediente a ser eliminado.
	 */

	@Override
	public void eliminarIngrediente(Long id) {
		ingredienteRepository.deleteById(id);
	}
	
	/**
	 * Busca un ingrediente en la base de datos por su ID.
	 * 
	 * @param id El ID del ingrediente a buscar.
	 * @return El objeto Ingrediente que corresponde al ID dado, o null si no se encuentra.
	 */

	@Override
	public Ingrediente buscarIngredienteById(Long id) {
		Optional<Ingrediente> ingrediente = ingredienteRepository.findById(id);
		return ingrediente.orElse(null);
	}
	
	/**
	 * Obtiene una lista de todos los ingredientes en la base de datos.
	 * 
	 * @return Una lista de objetos Ingrediente que representan todos los ingredientes en la base de datos.
	 */

	@Override
	public List<Ingrediente> obtenerIngredientes(){
		return (List<Ingrediente>) ingredienteRepository.findAll();
	}
}

