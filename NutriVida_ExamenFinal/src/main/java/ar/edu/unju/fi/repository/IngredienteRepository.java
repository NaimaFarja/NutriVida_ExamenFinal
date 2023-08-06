package ar.edu.unju.fi.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.entity.Ingrediente;

public interface IngredienteRepository extends CrudRepository<Ingrediente, Long> {
	
   Optional<Ingrediente> findByNombre(String nombre);
}
