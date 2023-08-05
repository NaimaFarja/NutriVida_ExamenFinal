package ar.edu.unju.fi.service;

import java.util.List;



import ar.edu.unju.fi.entity.Testimonio;



public interface TestimonioService {
	public void agregarTestimonio(Testimonio testimonio);
	public void eliminarTestimonio(Long id);
	public void modificarTestimonio(Testimonio testimonio);
	public Testimonio buscarTestimonioById(Long id);
	public List<Testimonio> obtenerTestimonios();
}
