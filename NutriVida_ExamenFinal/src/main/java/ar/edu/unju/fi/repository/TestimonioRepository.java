package ar.edu.unju.fi.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.entity.Testimonio;

/**
 * Interfaz que define un repositorio para la entidad Testimonio.
 * Proporciona métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en la base de datos.
 */

public interface TestimonioRepository extends CrudRepository<Testimonio, Long> {

}