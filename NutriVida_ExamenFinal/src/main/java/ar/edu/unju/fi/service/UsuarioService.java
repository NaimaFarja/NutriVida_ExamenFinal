package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Usuario;

/**
 * Interfaz que define los métodos de servicio para la gestión de usuarios.
 */

public interface UsuarioService {

	/**
     * Agrega un nuevo usuario al sistema.
     *
     * @param usuario Usuario a ser agregado.
     */
	public void agregarUsuario(Usuario usuario);
	
	/**
     * Elimina un usuario del sistema basado en su ID.
     *
     * @param id ID del usuario a ser eliminado.
     */
	public void eliminarUsuario(Long id);
	
	/**
     * Modifica los datos de un usuario existente en el sistema.
     *
     * @param usuario Usuario con los datos modificados.
     */
	public void modificarUsuario(Usuario usuario);
	
	/**
     * Busca y recupera un usuario del sistema basado en su ID.
     *
     * @param id ID del usuario a buscar.
     * @return El usuario encontrado, o null si no se encuentra.
     */
	public Usuario buscarUsuarioById(Long id);
	
	/**
     * Obtiene una lista de todos los usuarios registrados en el sistema.
     *
     * @return Lista de usuarios registrados.
     */
	public List<Usuario> obtenerUsuarios();
	
	/**
     * Obtiene el usuario que ha iniciado sesión en el sistema.
     *
     * @return El usuario que ha iniciado sesión, o null si no hay sesión iniciada.
     */
	public Usuario obtenerSesionUsuario();
	
	/**
     * Inicia la sesión de un usuario en el sistema.
     *
     * @param usuario Usuario que inicia sesión.
     */
	public void iniciarSesion(Usuario usuario);
}