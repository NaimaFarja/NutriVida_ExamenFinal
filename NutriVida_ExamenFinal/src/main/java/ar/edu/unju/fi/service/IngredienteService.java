package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Ingrediente;


/**
 * Esta interfaz define los métodos que deben ser implementados por las clases que brindan servicios relacionados con la entidad Ingrediente.
 * Los servicios están destinados a realizar operaciones CRUD (Create, Read, Update, Delete) y otras operaciones relacionadas con Ingrediente.
 */
public interface IngredienteService {
	
	
	 /**
     * Agrega un nuevo Ingrediente a la base de datos.
     *
     * @param ingrediente El objeto Ingrediente a agregar.
     */
	public void agregarIngrediente(Ingrediente ingrediente);
	
    /**
     * Elimina un Ingrediente de la base de datos según su identificador.
     *
     * @param id El identificador del Ingrediente a eliminar.
     */
	public void eliminarIngrediente(Long id);
	
	 /**
     * Busca un Ingrediente en la base de datos por su identificador.
     *
     * @param id El identificador del Ingrediente a buscar.
     * @return El objeto Ingrediente encontrado o null si no existe.
     */
	public Ingrediente buscarIngredienteById(Long id);
	
	
	 /**
     * Obtiene una lista de todos los Ingredientes almacenados en la base de datos.
     *
     * @return Una lista que contiene todos los objetos Ingrediente en la base de datos.
     */
	public List<Ingrediente> obtenerIngredientes();
	
	//EDITANDO
}

