package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.repository.ImcRepository;
import ar.edu.unju.fi.service.ImcService;

/**
 * Implementación de la interfaz ImcService que proporciona métodos para operaciones relacionadas con
 * los registros de IndiceMasaCorporal.
 */

@Service
public class ImcServiceImp implements ImcService {
	
	@Autowired
	ImcRepository imcRepository;

	/**
     * Agrega un nuevo registro de IndiceMasaCorporal.
     * @param indiceMasaCorporal El objeto IndiceMasaCorporal a agregar.
     */
	
	@Override
	public void agregarImc(IndiceMasaCorporal indiceMasaCorporal) {
		imcRepository.save(indiceMasaCorporal);
	}
	
	/**
     * Elimina un registro de IndiceMasaCorporal por su identificador único.
     * @param id El identificador del registro a eliminar.
     */

	@Override
	public void eliminarImc(Long id) {
		imcRepository.deleteById(id);
	}
	
	/**
     * Obtiene una lista de registros de IndiceMasaCorporal asociados a un Usuario específico.
     * @param usuario El Usuario para el cual se buscan registros de IndiceMasaCorporal.
     * @return Una lista de registros de IndiceMasaCorporal relacionados con el Usuario proporcionado.
     */

	@Override
	public List<IndiceMasaCorporal> obtenerImcByUsuario(Usuario usuario) {
		return imcRepository.findByUsuario(usuario);
	}
}

