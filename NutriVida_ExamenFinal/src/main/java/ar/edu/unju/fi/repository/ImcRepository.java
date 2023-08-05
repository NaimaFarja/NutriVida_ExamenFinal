package ar.edu.unju.fi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.entity.Usuario;


public interface ImcRepository extends CrudRepository<IndiceMasaCorporal, Long> {
	List<IndiceMasaCorporal> findByUsuario(Usuario usuario);
}
