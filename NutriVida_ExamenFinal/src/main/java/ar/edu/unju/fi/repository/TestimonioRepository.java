package ar.edu.unju.fi.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.entity.Testimonio;

/**
 * Esta interfaz define los métodos para acceder a la base de datos de testimonios.
 * 
 * @param Testimonio La entidad Testimonio que representa un registro de testimonio en la base de datos.
 * @param Long El tipo de dato de la clave primaria de la entidad Testimonio (ID).
 */

public interface TestimonioRepository  extends CrudRepository<Testimonio, Long>{

}
