package ar.edu.unju.fi.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}
