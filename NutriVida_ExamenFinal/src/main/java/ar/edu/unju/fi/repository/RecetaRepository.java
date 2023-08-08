package ar.edu.unju.fi.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.entity.Receta;

/**
 * Esta interfaz define los métodos para acceder a la base de datos de recetas.
 * 
 * @param Receta La entidad Receta que representa un registro de receta en la base de datos.
 * @param Long El tipo de dato de la clave primaria de la entidad Receta (ID).
 */
public interface RecetaRepository extends CrudRepository<Receta, Long> {

}
