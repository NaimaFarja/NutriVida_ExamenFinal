package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.entity.Usuario;

/**
 * Interfaz que define un repositorio para la entidad IndiceMasaCorporal.
 * Proporciona métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en la base de datos,
 * así como métodos personalizados para consultar registros relacionados con la entidad Usuario.
 */

public interface ImcRepository  extends CrudRepository<IndiceMasaCorporal, Long>{
	
	/**
     * Consulta registros de IndiceMasaCorporal por un Usuario específico.
     * @param usuario El Usuario para el cual se buscan registros de IndiceMasaCorporal.
     * @return Una lista de registros de IndiceMasaCorporal relacionados con el Usuario proporcionado.
     */
	List<IndiceMasaCorporal> findByUsuario(Usuario usuario);
}
