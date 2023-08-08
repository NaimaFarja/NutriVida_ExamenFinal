package ar.edu.unju.fi.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.entity.Usuario;

/**
 * Esta interfaz define los métodos para acceder a la base de datos de usuarios.
 * 
 * @param Usuario La entidad Usuario que representa un registro de usuario en la base de datos.
 * @param Long El tipo de dato de la clave primaria de la entidad Usuario (ID).
 */

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}
