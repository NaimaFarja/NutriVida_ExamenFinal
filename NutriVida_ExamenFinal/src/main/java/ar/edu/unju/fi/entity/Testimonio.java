package ar.edu.unju.fi.entity;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;

/**
 * Entidad que representa un testimonio de usuario.
 */

@Entity
public class Testimonio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne()
    @JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@NotEmpty(message="Debes dejar tu comentario")
	private String comentario;
	
	private LocalDate fecha;
	
	/*
	 * Constructor vacio
	 */
	
	public Testimonio() {
		// TODO Auto-generated constructor stub
	}

	 /**
     * Constructor parametrizado.
     * @param id Identificador del testimonio.
     * @param usuario Objeto Usuario asociado al testimonio.
     * @param comentario Texto del testimonio.
     * @param fecha Fecha del testimonio.
     */
	
	public Testimonio(Long id, Usuario usuario, String comentario, LocalDate fecha) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.comentario = comentario;
		this.fecha = fecha;
	}
	
	/**
     * Obtiene el identificador del testimonio.
     * @return Identificador del testimonio.
     */

	public Long getId() {
		return id;
	}
	
	/**
     * Establece el identificador del testimonio.
     * @param id Identificador del testimonio.
     */

	public void setId(Long id) {
		this.id = id;
	}
	
	/**
     * Obtiene el objeto Usuario asociado al testimonio.
     * @return Objeto Usuario asociado al testimonio.
     */

	public Usuario getUsuario() {
		return usuario;
	}
	
	/**
     * Establece el objeto Usuario asociado al testimonio.
     * @param usuario Objeto Usuario asociado al testimonio.
     */

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
     * Obtiene el texto del testimonio.
     * @return Texto del testimonio.
     */
	
	public String getComentario() {
		return comentario;
	}

	/**
     * Establece el texto del testimonio.
     * @param comentario Texto del testimonio.
     */
	
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	/**
     * Obtiene la fecha del testimonio.
     * @return Fecha del testimonio.
     */

	public LocalDate getFecha() {
		return fecha;
	}
	
	/**
     * Establece la fecha del testimonio.
     * @param fecha Fecha del testimonio.
     */

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

}
