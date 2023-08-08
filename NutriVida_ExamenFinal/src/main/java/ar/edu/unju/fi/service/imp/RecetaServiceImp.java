package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Receta;
import ar.edu.unju.fi.repository.RecetaRepository;
import ar.edu.unju.fi.service.RecetaService;

/**
 * Esta clase implementa la interfaz RecetaService y define los métodos para gestionar las recetas.
 * 
 * La clase proporciona operaciones para agregar, eliminar, modificar, buscar por ID y obtener todas las recetas.
 */

@Service
public class RecetaServiceImp implements RecetaService {
	
	@Autowired
	RecetaRepository recetaRepository;
	
	/**
	 * Agrega una nueva receta a la base de datos.
	 * 
	 * @param receta El objeto Receta que representa el registro de receta a ser agregado.
	 */

	@Override
	public void agregarReceta(Receta receta) {
		recetaRepository.save(receta);
	}
	
	/**
	 * Elimina una receta de la base de datos por su ID.
	 * 
	 * @param id El ID de la receta a ser eliminada.
	 */

	@Override
	public void eliminarReceta(Long id) {
		recetaRepository.deleteById(id);

	}
	
	/**
	 * Modifica una receta en la base de datos.
	 * 
	 * @param receta El objeto Receta que representa el registro de receta a ser modificado.
	 */

	@Override
	public void modificarReceta(Receta receta) {
		recetaRepository.save(receta);
	}
	
	/**
	 * Busca una receta en la base de datos por su ID.
	 * 
	 * @param id El ID de la receta a buscar.
	 * @return El objeto Receta que corresponde al ID dado, o null si no se encuentra.
	 */

	@Override
	public Receta buscarRecetaById(Long id) {
		// TODO Auto-generated method stub
		Optional<Receta> receta = recetaRepository.findById(id);
		return receta.orElse(null);
	}
	
	/**
	 * Obtiene una lista de todas las recetas en la base de datos.
	 * 
	 * @return Una lista de objetos Receta que representan todas las recetas en la base de datos.
	 */
	
	@Override
	public List<Receta> obtenerRecetas(){
		return (List<Receta>) recetaRepository.findAll();
	}

}