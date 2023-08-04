package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Testimonio;

/**
 * Interfaz que define los métodos de servicio para la entidad Testimonio.
 * Proporciona métodos para agregar, eliminar, modificar, buscar por ID y obtener registros de Testimonio.
 */

public interface TestimonioService {
	
	/**
     * Agrega un nuevo testimonio.
     * @param testimonio El objeto Testimonio a agregar.
     */
	public void agregarTestimonio(Testimonio testimonio);
	
	 /**
     * Elimina un testimonio por su identificador único.
     * @param id El identificador del testimonio a eliminar.
     */
	public void eliminarTestimonio(Long id);
	
	/**
     * Modifica un testimonio existente.
     * @param testimonio El objeto Testimonio con los nuevos datos a actualizar.
     */
	public void modificarTestimonio(Testimonio testimonio);
	
	/**
     * Busca un testimonio por su identificador único.
     * @param id El identificador del testimonio a buscar.
     * @return El objeto Testimonio encontrado, o null si no se encuentra.
     */
	public Testimonio buscarTestimonioById(Long id);
	
	/**
     * Obtiene una lista de todos los testimonios registrados.
     * @return Una lista de objetos Testimonio.
     */
	public List<Testimonio> obtenerTestimonios();
}