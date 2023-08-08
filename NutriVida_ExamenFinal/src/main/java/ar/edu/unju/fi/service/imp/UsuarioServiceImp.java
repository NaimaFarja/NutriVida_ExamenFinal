package ar.edu.unju.fi.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Usuario;
import ar.edu.unju.fi.repository.UsuarioRepository;
import ar.edu.unju.fi.service.UsuarioService;

/**
 * Esta clase implementa la interfaz UsuarioService y define los métodos para gestionar los usuarios.
 *
 * La clase proporciona operaciones para agregar, eliminar, modificar, buscar por ID y obtener todos los usuarios.
 * También incluye métodos para obtener la sesión del usuario y para iniciar sesión.
 */

@Service
public class UsuarioServiceImp implements UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	Usuario usuarioSesion;
	
	/**
	 * Agrega un nuevo usuario a la base de datos.
	 * 
	 * @param usuario El objeto Usuario que representa el registro de usuario a ser agregado.
	 */
	
	@Override
	public void agregarUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	/**
	 * Elimina un usuario de la base de datos por su ID.
	 * 
	 * @param id El ID del usuario a ser eliminado.
	 */

	@Override
	public void eliminarUsuario(Long id) {
		usuarioRepository.deleteById(id);
	}
	
	/**
	 * Modifica un usuario en la base de datos.
	 * 
	 * @param usuario El objeto Usuario que representa el registro de usuario a ser modificado.
	 */

	@Override
	public void modificarUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	/**
	 * Busca un usuario en la base de datos por su ID.
	 * 
	 * @param id El ID del usuario a buscar.
	 * @return El objeto Usuario que corresponde al ID dado, o null si no se encuentra.
	 */

	@Override
	public Usuario buscarUsuarioById(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.orElse(null);
	}
	
	/**
	 * Obtiene una lista de todos los usuarios en la base de datos.
	 * 
	 * @return Una lista de objetos Usuario que representan todos los usuarios en la base de datos.
	 */

	@Override
	public List<Usuario> obtenerUsuarios(){
		return (List<Usuario>) usuarioRepository.findAll();
	}
	
	/**
	 * Obtiene el usuario que ha iniciado sesión actualmente.
	 * 
	 * @return El objeto Usuario que representa el usuario que ha iniciado sesión, o null si no hay sesión activa.
	 */
	
	@Override
	public Usuario obtenerSesionUsuario() {
		return this.usuarioSesion;
	}
	
	/**
	 * Inicia la sesión de un usuario en la aplicación.
	 * 
	 * @param usuario El objeto Usuario que representa al usuario que iniciará sesión.
	 */
	
	@Override
	public void iniciarSesion(Usuario usuario) {
		this.usuarioSesion = usuario;
	}
}
