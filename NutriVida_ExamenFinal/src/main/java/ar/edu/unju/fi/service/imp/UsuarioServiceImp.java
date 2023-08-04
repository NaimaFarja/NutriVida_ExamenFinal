package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.repository.UsuarioRepository;
import ar.edu.unju.fi.service.UsuarioService;

/**
 * Implementación de la interfaz UsuarioService que proporciona la lógica de negocio para la gestión de usuarios.
 */

@Service
public class UsuarioServiceImp implements UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	Usuario usuarioSesion;
	
	 /**
     * Agrega un nuevo usuario al sistema.
     * @param usuario Usuario a ser agregado.
     */
	
	@Override
	public void agregarUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	/**
     * Elimina un usuario del sistema basado en su ID.
     * @param id ID del usuario a ser eliminado.
     */
	
	@Override
	public void eliminarUsuario(Long id) {
		usuarioRepository.deleteById(id);
	}
	
	/**
     * Modifica los datos de un usuario existente en el sistema.
     * @param usuario Usuario con los datos modificados.
     */

	@Override
	public void modificarUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	/**
     * Busca y recupera un usuario del sistema basado en su ID.
     * @param id ID del usuario a buscar.
     * @return El usuario encontrado, o null si no se encuentra.
     */
	
	@Override
	public Usuario buscarUsuarioById(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.orElse(null);
	}

	 /**
     * Obtiene una lista de todos los usuarios registrados en el sistema.
     * @return Lista de usuarios registrados.
     */
	
	@Override
	public List<Usuario> obtenerUsuarios(){
		return (List<Usuario>) usuarioRepository.findAll();
	}
	
	/**
     * Obtiene el usuario que ha iniciado sesión en el sistema.
     * @return El usuario que ha iniciado sesión, o null si no hay sesión iniciada.
     */
	
	@Override
	public Usuario obtenerSesionUsuario() {
		return this.usuarioSesion;
	}
	
	 /**
     * Inicia la sesión de un usuario en el sistema.
     * @param usuario Usuario que inicia sesión.
     */
	
	@Override
	public void iniciarSesion(Usuario usuario) {
		this.usuarioSesion = usuario;
	}
}