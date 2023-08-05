package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Usuario;


public interface UsuarioService {
	public void agregarUsuario(Usuario usuario);
	public void eliminarUsuario(Long id);
	public void modificarUsuario(Usuario usuario);
	public Usuario buscarUsuarioById(Long id);
	public List<Usuario> obtenerUsuarios();
	public Usuario obtenerSesionUsuario();
	public void iniciarSesion(Usuario usuario);
}
