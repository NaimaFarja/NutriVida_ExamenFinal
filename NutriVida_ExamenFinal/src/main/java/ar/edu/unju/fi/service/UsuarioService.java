package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Usuario;

/**
 * Esta interfaz define los métodos que deben ser implementados para gestionar los usuarios.
 * 
 * La interfaz proporciona operaciones para agregar, eliminar, modificar, buscar por ID y obtener todos los usuarios.
 * También incluye métodos para obtener la sesión del usuario y para iniciar sesión.
 */

public interface UsuarioService {
	
	/**
	 * Agrega un nuevo usuario a la base de datos.
	 * 
	 * @param usuario El objeto Usuario que representa el registro de usuario a ser agregado.
	 */
	
	public void agregarUsuario(Usuario usuario);
	
	/**
	 * Elimina un usuario de la base de datos por su ID.
	 * 
	 * @param id El ID del usuario a ser eliminado.
	 */
	
	public void eliminarUsuario(Long id);
	
	/**
	 * Modifica un usuario en la base de datos.
	 * 
	 * @param usuario El objeto Usuario que representa el registro de usuario a ser modificado.
	 */
	
	public void modificarUsuario(Usuario usuario);
	
	/**
	 * Busca un usuario en la base de datos por su ID.
	 * 
	 * @param id El ID del usuario a buscar.
	 * @return El objeto Usuario que corresponde al ID dado, o null si no se encuentra.
	 */
	
	public Usuario buscarUsuarioById(Long id);
	
	/**
	 * Obtiene una lista de todos los usuarios en la base de datos.
	 * 
	 * @return Una lista de objetos Usuario que representan todos los usuarios en la base de datos.
	 */
	
	public List<Usuario> obtenerUsuarios();
	
	/**
	 * Obtiene el usuario que ha iniciado sesión actualmente.
	 * 
	 * @return El objeto Usuario que representa el usuario que ha iniciado sesión, o null si no hay sesión activa.
	 */
	
	public Usuario obtenerSesionUsuario();
	
	/**
	 * Inicia la sesión de un usuario en la aplicación.
	 * 
	 * @param usuario El objeto Usuario que representa al usuario que iniciará sesión.
	 */
	
	public void iniciarSesion(Usuario usuario);
}
