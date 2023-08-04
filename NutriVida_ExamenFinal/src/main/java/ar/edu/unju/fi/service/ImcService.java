package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.entity.Usuario;

/**
 * Interfaz que define los métodos de servicio para la entidad IndiceMasaCorporal.
 * Proporciona métodos para agregar, eliminar y obtener registros de IndiceMasaCorporal, así como consultar
 * registros relacionados con un Usuario específico.
 */

public interface ImcService {
	
	/**
     * Agrega un registro de IndiceMasaCorporal.
     * @param indiceMasaCorporal El objeto IndiceMasaCorporal a agregar.
     */
	void agregarImc(IndiceMasaCorporal indiceMasaCorporal);
	
	/**
     * Elimina un registro de IndiceMasaCorporal por su identificador único.
     * @param id El identificador del registro a eliminar.
     */
	void eliminarImc(Long id);
	
	/**
     * Obtiene una lista de registros de IndiceMasaCorporal asociados a un Usuario específico.
     * @param usuario El Usuario para el cual se buscan registros de IndiceMasaCorporal.
     * @return Una lista de registros de IndiceMasaCorporal relacionados con el Usuario proporcionado.
     */
	public List<IndiceMasaCorporal> obtenerImcByUsuario(Usuario usuario);
}
