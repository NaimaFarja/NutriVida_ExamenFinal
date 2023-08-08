package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Ingrediente;

/**
 * Esta interfaz define los métodos que deben ser implementados para gestionar los ingredientes.
 */

public interface IngredienteService {
	
	/**
	 * Agrega un nuevo ingrediente a la base de datos.
	 * 
	 * @param ingrediente El objeto Ingrediente que representa el registro de ingrediente a ser agregado.
	 */
	
	public void agregarIngrediente(Ingrediente ingrediente);
	
	/**
	 * Elimina un ingrediente de la base de datos por su ID.
	 * 
	 * @param id El ID del ingrediente a ser eliminado.
	 */
	
	public void eliminarIngrediente(Long id);
	
	/**
	 * Busca un ingrediente en la base de datos por su ID.
	 * 
	 * @param id El ID del ingrediente a buscar.
	 * @return El objeto Ingrediente que corresponde al ID dado, o null si no se encuentra.
	 */
	
	public Ingrediente buscarIngredienteById(Long id);
	
	/**
	 * Obtiene una lista de todos los ingredientes en la base de datos.
	 * 
	 * @return Una lista de objetos Ingrediente que representan todos los ingredientes en la base de datos.
	 */
	
	public List<Ingrediente> obtenerIngredientes();
}
