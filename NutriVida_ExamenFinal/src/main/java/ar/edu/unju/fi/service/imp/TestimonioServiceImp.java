package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Testimonio;
import ar.edu.unju.fi.repository.TestimonioRepository;
import ar.edu.unju.fi.service.TestimonioService;

/**
 * Implementación de la interfaz TestimonioService que proporciona métodos para operaciones relacionadas con
 * los testimonios de los usuarios.
 */

@Service
public class TestimonioServiceImp implements TestimonioService {

	@Autowired
	TestimonioRepository testimonioRepository;
	
	/**
     * Agrega un nuevo testimonio.
     * @param testimonio El objeto Testimonio a agregar.
     */
	
	@Override
	public void agregarTestimonio(Testimonio testimonio) {
		// TODO Auto-generated method stub
		testimonioRepository.save(testimonio);
	}
	
	/**
     * Elimina un testimonio por su identificador único.
     * @param id El identificador del testimonio a eliminar.
     */

	@Override
	public void eliminarTestimonio(Long id) {
		// TODO Auto-generated method stub
		testimonioRepository.deleteById(id);
	}
	
	/**
     * Modifica un testimonio existente.
     * @param testimonio El objeto Testimonio modificado.
     */

	@Override
	public void modificarTestimonio(Testimonio testimonio) {
		// TODO Auto-generated method stub
		testimonioRepository.save(testimonio);
	}
	
	 /**
     * Busca un testimonio por su identificador único.
     * @param id El identificador del testimonio a buscar.
     * @return El testimonio encontrado o null si no existe.
     */

	@Override
	public Testimonio buscarTestimonioById(Long id) {
		// TODO Auto-generated method stub
		Optional<Testimonio> testimonio = testimonioRepository.findById(id);
		return testimonio.orElse(null);
	}
	
	/**
     * Obtiene una lista de todos los testimonios registrados.
     * @return Una lista de testimonios.
     */
	
	@Override
	public List<Testimonio> obtenerTestimonios(){
		return (List<Testimonio>) testimonioRepository.findAll();
	}
}

