package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Receta;


/**
 * Esta interfaz define los métodos que deben ser implementados por las clases que brindan servicios relacionados con la entidad Receta.
 * Los servicios están destinados a realizar operaciones CRUD (Create, Read, Update, Delete) y otras operaciones relacionadas con Receta.
 */
public interface RecetaService {
	
	/**
     * Agrega una nueva Receta a la base de datos.
     *
     * @param receta El objeto Receta a agregar.
     */
	public void agregarReceta(Receta receta);
	
	
	/**
     * Elimina una Receta de la base de datos según su identificador.
     *
     * @param id El identificador de la Receta a eliminar.
     */
	public void eliminarReceta(Long id);
	
	
	
	 /**
     * Modifica una Receta existente en la base de datos.
     *
     * @param receta El objeto Receta modificado a actualizar en la base de datos.
     */
	public void modificarReceta(Receta receta);
	
	
	
	/**
     * Busca una Receta en la base de datos por su identificador.
     *
     * @param id El identificador de la Receta a buscar.
     * @return El objeto Receta encontrado o null si no existe.
     */
	public Receta buscarRecetaById(Long id);
	
	
	
	 /**
     * Obtiene una lista de todas las Recetas almacenadas en la base de datos.
     *
     * @return Una lista que contiene todos los objetos Receta en la base de datos.
     */
	public List<Receta> obtenerRecetas();
	
	//EDITANDOO
}