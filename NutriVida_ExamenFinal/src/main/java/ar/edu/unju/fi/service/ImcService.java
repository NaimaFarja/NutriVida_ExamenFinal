package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.entity.Usuario;



public interface ImcService {
	void agregarImc(IndiceMasaCorporal indiceMasaCorporal);
	void eliminarImc(Long id);
	public List<IndiceMasaCorporal> obtenerImcByUsuario(Usuario usuario);
}
