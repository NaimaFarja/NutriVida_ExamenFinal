package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Testimonio;
import ar.edu.unju.fi.repository.TestimonioRepository;
import ar.edu.unju.fi.service.TestimonioService;

/**
 * Esta clase implementa la interfaz TestimonioService y define los métodos para gestionar los testimonios.
 * 
 * La clase proporciona operaciones para agregar, eliminar, modificar, buscar por ID y obtener todos los testimonios.
 */

@Service
public class TestimonioServiceImp implements TestimonioService {

	@Autowired
	TestimonioRepository testimonioRepository;
	
	/**
	 * Agrega un nuevo testimonio a la base de datos.
	 * 
	 * @param testimonio El objeto Testimonio que representa el registro de testimonio a ser agregado.
	 */
	
	@Override
	public void agregarTestimonio(Testimonio testimonio) {
		// TODO Auto-generated method stub
		testimonioRepository.save(testimonio);
	}
	
	/**
	 * Elimina un testimonio de la base de datos por su ID.
	 * 
	 * @param id El ID del testimonio a ser eliminado.
	 */

	@Override
	public void eliminarTestimonio(Long id) {
		// TODO Auto-generated method stub
		testimonioRepository.deleteById(id);
	}
	
	/**
	 * Modifica un testimonio en la base de datos.
	 * 
	 * @param testimonio El objeto Testimonio que representa el registro de testimonio a ser modificado.
	 */

	@Override
	public void modificarTestimonio(Testimonio testimonio) {
		// TODO Auto-generated method stub
		testimonioRepository.save(testimonio);
	}
	
	/**
	 * Busca un testimonio en la base de datos por su ID.
	 * 
	 * @param id El ID del testimonio a buscar.
	 * @return El objeto Testimonio que corresponde al ID dado, o null si no se encuentra.
	 */

	@Override
	public Testimonio buscarTestimonioById(Long id) {
		// TODO Auto-generated method stub
		Optional<Testimonio> testimonio = testimonioRepository.findById(id);
		return testimonio.orElse(null);
	}
	
	/**
	 * Obtiene una lista de todos los testimonios en la base de datos.
	 * 
	 * @return Una lista de objetos Testimonio que representan todos los testimonios en la base de datos.
	 */
	
	@Override
	public List<Testimonio> obtenerTestimonios(){
		return (List<Testimonio>) testimonioRepository.findAll();
	}
}
