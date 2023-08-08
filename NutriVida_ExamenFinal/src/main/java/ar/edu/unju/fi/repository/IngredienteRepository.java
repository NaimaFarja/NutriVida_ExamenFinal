package ar.edu.unju.fi.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.entity.Ingrediente;

/**
 * Esta interfaz define los métodos para acceder a la base de datos de ingredientes.
 * 
 * @param Ingrediente La entidad Ingrediente que representa un registro de ingrediente en la base de datos.
 * @param Long El tipo de dato de la clave primaria de la entidad Ingrediente (ID).
 */

public interface IngredienteRepository extends CrudRepository<Ingrediente, Long> {
	
   Optional<Ingrediente> findByNombre(String nombre);
}
