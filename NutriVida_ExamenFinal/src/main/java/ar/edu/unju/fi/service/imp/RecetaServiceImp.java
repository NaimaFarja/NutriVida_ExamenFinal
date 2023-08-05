package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import  ar.edu.unju.fi.entity.Receta;
import  ar.edu.unju.fi.repository.RecetaRepository;
import  ar.edu.unju.fi.service.RecetaService;



/**
 * Esta clase es una implementación de la interfaz RecetaService y se encarga de brindar los servicios relacionados con la entidad Receta.
 * Los servicios implementados realizan operaciones CRUD (Create, Read, Update, Delete) y otras operaciones relacionadas con Receta.
 */
@Service
public class RecetaServiceImp implements RecetaService {
	
	@Autowired
	RecetaRepository recetaRepository;

	
	 /**
     * Agrega una nueva Receta a la base de datos.
     *
     * @param receta El objeto Receta a agregar.
     */
	@Override
	public void agregarReceta(Receta receta) {
		recetaRepository.save(receta);
	}

	
	/**
     * Elimina una Receta de la base de datos según su identificador.
     *
     * @param id El identificador de la Receta a eliminar.
     */
	@Override
	public void eliminarReceta(Long id) {
		recetaRepository.deleteById(id);

	}
	
	

	/**
     * Modifica una Receta existente en la base de datos.
     *
     * @param receta El objeto Receta modificado a actualizar en la base de datos.
     */
	@Override
	public void modificarReceta(Receta receta) {
		recetaRepository.save(receta);
	}

	
	  /**
     * Busca una Receta en la base de datos por su identificador.
     *
     * @param id El identificador de la Receta a buscar.
     * @return El objeto Receta encontrado o null si no existe.
     */
	@Override
	public Receta buscarRecetaById(Long id) {
		// TODO Auto-generated method stub
		Optional<Receta> receta = recetaRepository.findById(id);
		return receta.orElse(null);
	}
	
	
	 /**
     * Obtiene una lista de todas las Recetas almacenadas en la base de datos.
     *
     * @return Una lista que contiene todos los objetos Receta en la base de datos.
     */
	@Override
	public List<Receta> obtenerRecetas(){
		return (List<Receta>) recetaRepository.findAll();
	}

	//EDITANDOO
}