package ar.edu.unju.fi.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.entity.Usuario;

/**
 * Repositorio de datos para la entidad Usuario.
 * Proporciona métodos de acceso a la base de datos para operaciones CRUD (crear, leer, actualizar, eliminar) relacionadas con usuarios.
 */

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

}