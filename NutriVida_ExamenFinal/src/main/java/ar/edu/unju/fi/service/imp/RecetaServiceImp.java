package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Receta;
import ar.edu.unju.fi.repository.RecetaRepository;
import ar.edu.unju.fi.service.RecetaService;


@Service
public class RecetaServiceImp implements RecetaService {
	
	@Autowired
	RecetaRepository recetaRepository;

	@Override
	public void agregarReceta(Receta receta) {
		recetaRepository.save(receta);
	}

	@Override
	public void eliminarReceta(Long id) {
		recetaRepository.deleteById(id);

	}

	@Override
	public void modificarReceta(Receta receta) {
		recetaRepository.save(receta);
	}

	@Override
	public Receta buscarRecetaById(Long id) {
		// TODO Auto-generated method stub
		Optional<Receta> receta = recetaRepository.findById(id);
		return receta.orElse(null);
	}
	
	@Override
	public List<Receta> obtenerRecetas(){
		return (List<Receta>) recetaRepository.findAll();
	}

}