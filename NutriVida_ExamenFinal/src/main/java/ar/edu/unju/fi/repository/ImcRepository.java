package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.entity.Usuario;

/**
 * Esta interfaz define los métodos para acceder a la base de datos de los índices de masa corporal (IMC).
 * 
 * @param IndiceMasaCorporal La entidad de Índice de Masa Corporal que representa un registro de IMC en la base de datos.
 * @param Long El tipo de dato de la clave primaria de la entidad ÍndiceMasaCorporal (ID).
 */

public interface ImcRepository extends CrudRepository<IndiceMasaCorporal, Long> {
	
	/**
	 * Método para buscar y recuperar todos los registros de Índice de Masa Corporal (IMC)
	 * asociados a un Usuario específico.
	 * 
	 * @param usuario El objeto Usuario para el cual se buscarán los registros de IMC.
	 * @return Una lista de objetos IndiceMasaCorporal que corresponden al usuario dado.
	 */
	
	List<IndiceMasaCorporal> findByUsuario(Usuario usuario);
}
