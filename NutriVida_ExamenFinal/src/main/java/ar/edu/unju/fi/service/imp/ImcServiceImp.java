package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.repository.ImcRepository;
import ar.edu.unju.fi.service.ImcService;


@Service
public class ImcServiceImp implements ImcService {
	
	@Autowired
	ImcRepository imcRepository;

	@Override
	public void agregarImc(IndiceMasaCorporal indiceMasaCorporal) {
		imcRepository.save(indiceMasaCorporal);
	}

	@Override
	public void eliminarImc(Long id) {
		imcRepository.deleteById(id);
	}

	@Override
	public List<IndiceMasaCorporal> obtenerImcByUsuario(Usuario usuario) {
		return imcRepository.findByUsuario(usuario);
	}
}

