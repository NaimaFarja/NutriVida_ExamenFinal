package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Ingrediente;


public interface IngredienteService {
	public void agregarIngrediente(Ingrediente ingrediente);
	public void eliminarIngrediente(Long id);
	public Ingrediente buscarIngredienteById(Long id);
	public List<Ingrediente> obtenerIngredientes();
	public boolean verificarIngrediente(String nombre);
}
