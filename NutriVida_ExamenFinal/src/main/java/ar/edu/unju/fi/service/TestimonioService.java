package ar.edu.unju.fi.service;

import java.util.List;



import ar.edu.unju.fi.entity.Testimonio;

/**
 * Esta interfaz define los métodos que deben ser implementados para gestionar los testimonios.
 */

public interface TestimonioService {
	
	/**
	 * Agrega un nuevo testimonio a la base de datos.
	 * 
	 * @param testimonio El objeto Testimonio que representa el registro de testimonio a ser agregado.
	 */
	
	public void agregarTestimonio(Testimonio testimonio);
	
	/**
	 * Elimina un testimonio de la base de datos por su ID.
	 * 
	 * @param id El ID del testimonio a ser eliminado.
	 */
	
	public void eliminarTestimonio(Long id);
	
	/**
	 * Modifica un testimonio en la base de datos.
	 * 
	 * @param testimonio El objeto Testimonio que representa el registro de testimonio a ser modificado.
	 */
	
	public void modificarTestimonio(Testimonio testimonio);
	
	/**
	 * Busca un testimonio en la base de datos por su ID.
	 * 
	 * @param id El ID del testimonio a buscar.
	 * @return El objeto Testimonio que corresponde al ID dado, o null si no se encuentra.
	 */
	
	public Testimonio buscarTestimonioById(Long id);
	
	/**
	 * Obtiene una lista de todos los testimonios en la base de datos.
	 * 
	 * @return Una lista de objetos Testimonio que representan todos los testimonios en la base de datos.
	 */
	
	public List<Testimonio> obtenerTestimonios();
}
