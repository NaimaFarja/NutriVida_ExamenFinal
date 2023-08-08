package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.entity.Usuario;

/**
 * Esta interfaz define los métodos que deben ser implementados para gestionar los índices de masa corporal (IMC).
 */

public interface ImcService {
	
	/**
	 * Agrega un nuevo índice de masa corporal a la base de datos.
	 * 
	 * @param indiceMasaCorporal El objeto IndiceMasaCorporal que representa el registro de IMC a ser agregado.
	 */
	
	void agregarImc(IndiceMasaCorporal indiceMasaCorporal);
	
	/**
	 * Elimina un índice de masa corporal de la base de datos por su ID.
	 * 
	 * @param id El ID del índice de masa corporal a ser eliminado.
	 */
	
	void eliminarImc(Long id);
	
	/**
	 * Obtiene una lista de índice de masa corporal asociados a un usuario específico.
	 * 
	 * @param usuario El objeto Usuario para el cual se buscarán los índices de masa corporal.
	 * @return Una lista de objetos IndiceMasaCorporal que corresponden al usuario dado.
	 */
	
	public List<IndiceMasaCorporal> obtenerImcByUsuario(Usuario usuario);
}
