package ar.edu.unju.fi.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.entity.Receta;

/**
 * Esta interfaz es parte de la capa de persistencia del sistema y se encarga de manejar la entidad Receta en la base de datos.
 * Extiende de CrudRepository, lo que significa que hereda los métodos CRUD básicos (Create, Read, Update, Delete)
 * y otros métodos útiles proporcionados por Spring Data JPA para trabajar con la entidad Receta.
 */
public interface RecetaRepository extends CrudRepository<Receta, Long> {
//EDITANDOO
}
