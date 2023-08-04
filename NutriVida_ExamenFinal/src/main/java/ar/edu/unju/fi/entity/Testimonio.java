package ar.edu.unju.fi.entity;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;


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
	
	public Testimonio() {
		// TODO Auto-generated constructor stub
	}

	public Testimonio(Long id, Usuario usuario, String comentario, LocalDate fecha) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.comentario = comentario;
		this.fecha = fecha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

}
