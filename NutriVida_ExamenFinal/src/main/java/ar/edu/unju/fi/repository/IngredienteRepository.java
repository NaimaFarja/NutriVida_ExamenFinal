package ar.edu.unju.fi.repository;

import org.springframework.data.repository.CrudRepository;
import ar.edu.unju.fi.entity.Ingrediente;

/**
 * Esta interfaz es parte de la capa de persistencia del sistema y se encarga de manejar la entidad Ingrediente en la base de datos.
 * Extiende de CrudRepository, lo que significa que hereda los métodos CRUD básicos (Create, Read, Update, Delete)
 * y otros métodos útiles proporcionados por Spring Data JPA para trabajar con la entidad Ingrediente.
 */
public interface IngredienteRepository extends CrudRepository<Ingrediente, Long> {

}