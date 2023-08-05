package ar.edu.unju.fi.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Receta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="El nombre no puede estar vacio")
	private String nombre;
	
	@NotEmpty(message="Debe elegir una categoria")
	private String categoria;
	
	@ManyToMany
	@NotEmpty(message="Debe agregar los ingredientes")
	private List<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
	
	@NotEmpty(message="La receta debe tener una preparacion")
	private String preparacion;
	
	private String imagen;
	
	
	/**
	 * Constructor por defecto de la clase Receta.
	 */
	public Receta() {
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * Constructor con parámetros de la clase Receta.
	 *
	 * @param id          El identificador de la receta.
	 * @param nombre      El nombre de la receta.
	 * @param categoria   La categoría de la receta.
	 * @param ingredientes La lista de ingredientes de la receta.
	 * @param preparacion La preparación de la receta.
	 * @param imagen      La URL de la imagen asociada a la receta.
	 */
	public Receta(Long id, String nombre, String categoria, List<Ingrediente> ingredientes, String preparacion,
			String imagen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;
		this.ingredientes = ingredientes;
		this.preparacion = preparacion;
		this.imagen = imagen;
	}
	
	

	/**
	 * Obtiene el identificador de la receta.
	 *
	 * @return El identificador de la receta.
	 */
	public Long getId() {
		return id;
	}

	
	/**
	 * Establece el identificador de la receta.
	 *
	 * @param id El identificador de la receta a establecer.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	
	/**
	 * Obtiene el nombre de la receta.
	 *
	 * @return El nombre de la receta.
	 */
	public String getNombre() {
		return nombre;
	}

	
	/**
	 * Establece el nombre de la receta.
	 *
	 * @param nombre El nombre de la receta a establecer.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	/**
	 * Obtiene la categoría de la receta.
	 *
	 * @return La categoría de la receta.
	 */
	public String getCategoria() {
		return categoria;
	}

	
	/**
	 * Establece la categoría de la receta.
	 *
	 * @param categoria La categoría de la receta a establecer.
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	
	/**
	 * Obtiene la lista de ingredientes de la receta.
	 *
	 * @return La lista de ingredientes de la receta.
	 */
	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	
	/**
	 * Establece la lista de ingredientes de la receta.
	 *
	 * @param ingredientes La lista de ingredientes de la receta a establecer.
	 */
	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	
	/**
	 * Obtiene la preparación de la receta.
	 *
	 * @return La preparación de la receta.
	 */
	public String getPreparacion() {
		return preparacion;
	}

	
	/**
	 * Establece la preparación de la receta.
	 *
	 * @param preparacion La preparación de la receta a establecer.
	 */
	public void setPreparacion(String preparacion) {
		this.preparacion = preparacion;
	}

	
	/**
	 * Obtiene la URL de la imagen asociada a la receta.
	 *
	 * @return La URL de la imagen asociada a la receta.
	 */
	public String getImagen() {
		return imagen;
	}

	
	/**
	 * Establece la URL de la imagen asociada a la receta.
	 *
	 * @param imagen La URL de la imagen a establecer.
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "Receta [id=" + id + ", nombre=" + nombre + ", categoria=" + categoria + ", ingredientes=" + ingredientes
				+ ", preparacion=" + preparacion + ", imagen=" + imagen + "]";
	}
	
}
