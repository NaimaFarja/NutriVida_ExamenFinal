package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Receta;

/**
 * Esta interfaz define los métodos que deben ser implementados para gestionar las recetas.
 */

public interface RecetaService {
	
	/**
	 * Agrega una nueva receta a la base de datos.
	 * 
	 * @param receta El objeto Receta que representa el registro de receta a ser agregado.
	 */
	
	public void agregarReceta(Receta receta);
	
	/**
	 * Elimina una receta de la base de datos por su ID.
	 * 
	 * @param id El ID de la receta a ser eliminada.
	 */
	
	public void eliminarReceta(Long id);
	
	/**
	 * Modifica una receta en la base de datos.
	 * 
	 * @param receta El objeto Receta que representa el registro de receta a ser modificado.
	 */
	
	public void modificarReceta(Receta receta);
	
	/**
	 * Busca una receta en la base de datos por su ID.
	 * 
	 * @param id El ID de la receta a buscar.
	 * @return El objeto Receta que corresponde al ID dado, o null si no se encuentra.
	 */
	
	public Receta buscarRecetaById(Long id);
	
	/**
	 * Obtiene una lista de todas las recetas en la base de datos.
	 * 
	 * @return Una lista de objetos Receta que representan todas las recetas en la base de datos.
	 */
	
	public List<Receta> obtenerRecetas();
}
