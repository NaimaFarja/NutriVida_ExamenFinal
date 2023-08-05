package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Receta;



public interface RecetaService {
	public void agregarReceta(Receta receta);
	public void eliminarReceta(Long id);
	public void modificarReceta(Receta receta);
	public Receta buscarRecetaById(Long id);
	public List<Receta> obtenerRecetas();
}
