package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Ingrediente;
import ar.edu.unju.fi.repository.IngredienteRepository;
import ar.edu.unju.fi.service.IngredienteService;


@Service
public class IngredienteServiceImp implements IngredienteService {
	
	@Autowired
	IngredienteRepository ingredienteRepository;

	@Override
	public void agregarIngrediente(Ingrediente ingrediente) {
		ingredienteRepository.save(ingrediente);
	}

	@Override
	public void eliminarIngrediente(Long id) {
		ingredienteRepository.deleteById(id);
	}

	@Override
	public Ingrediente buscarIngredienteById(Long id) {
		Optional<Ingrediente> ingrediente = ingredienteRepository.findById(id);
		return ingrediente.orElse(null);
	}

	@Override
	public List<Ingrediente> obtenerIngredientes(){
		return (List<Ingrediente>) ingredienteRepository.findAll();
	}
	
	@Override
	public boolean verificarIngrediente(String nombre) {
		Optional<Ingrediente> ingrediente = ingredienteRepository.findByNombre(nombre);
		if(ingrediente.isPresent()) {
			return true;
		}else {
			return false;
		}
		
	}
}

