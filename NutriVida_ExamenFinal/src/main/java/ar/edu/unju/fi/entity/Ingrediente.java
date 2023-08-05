package ar.edu.unju.fi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Ingrediente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "El campo nombre no puede estar vacio.")
	private String nombre;
	
	/**
	 * Constructor por defecto de la clase Ingrediente.
	 */
	public Ingrediente() {
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * Constructor con parámetros de la clase Ingrediente.
	 *
	 * @param id     El identificador del ingrediente.
	 * @param nombre El nombre del ingrediente.
	 */
	public Ingrediente(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	
	/**
	 * Obtiene el identificador del ingrediente.
	 *
	 * @return El identificador del ingrediente.
	 */
	public Long getId() {
		return id;
	}

	
	/**
	 * Establece el identificador del ingrediente.
	 *
	 * @param id El identificador del ingrediente a establecer.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	
	/**
	 * Obtiene el nombre del ingrediente.
	 *
	 * @return El nombre del ingrediente.
	 */
	public String getNombre() {
		return nombre;
	}

	
	/**
	 * Establece el nombre del ingrediente.
	 *
	 * @param nombre El nombre del ingrediente a establecer.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	//EDITANDOO
}