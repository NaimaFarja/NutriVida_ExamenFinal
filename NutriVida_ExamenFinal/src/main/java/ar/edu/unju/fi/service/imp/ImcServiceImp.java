package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.IndiceMasaCorporal;
import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.repository.ImcRepository;
import ar.edu.unju.fi.service.ImcService;

/**
 * Esta clase implementa la interfaz ImcService y define los métodos para gestionar los índices de masa corporal (IMC).
 * 
 * La clase proporciona operaciones para agregar, eliminar y obtener los índices de masa corporal asociados a un usuario.
 */

@Service
public class ImcServiceImp implements ImcService {
	
	@Autowired
	ImcRepository imcRepository;
	
	/**
	 * Agrega un nuevo índice de masa corporal a la base de datos.
	 * 
	 * @param indiceMasaCorporal El objeto IndiceMasaCorporal que representa el registro de IMC a ser agregado.
	 */

	@Override
	public void agregarImc(IndiceMasaCorporal indiceMasaCorporal) {
		imcRepository.save(indiceMasaCorporal);
	}
	
	/**
	 * Elimina un índice de masa corporal de la base de datos por su ID.
	 * 
	 * @param id El ID del índice de masa corporal a ser eliminado.
	 */

	@Override
	public void eliminarImc(Long id) {
		imcRepository.deleteById(id);
	}
	
	/**
	 * Obtiene una lista de índices de masa corporal asociados a un usuario específico.
	 * 
	 * @param usuario El objeto Usuario para el cual se buscarán los índices de masa corporal.
	 * @return Una lista de objetos IndiceMasaCorporal que corresponden al usuario dado.
	 */

	@Override
	public List<IndiceMasaCorporal> obtenerImcByUsuario(Usuario usuario) {
		return imcRepository.findByUsuario(usuario);
	}
}