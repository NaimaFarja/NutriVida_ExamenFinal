package ar.edu.unju.fi.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class IndiceMasaCorporal {
	
	//nos conviene usar Long para poder usar sus funciones
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	private LocalDate fecha;
    
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    
	private String estado;
	
	@NotNull(message = "El campo peso no puede estar vacio.")
	private Double peso;
    
    public IndiceMasaCorporal() {
		// TODO Auto-generated constructor stub
	}

	public IndiceMasaCorporal(Long id, LocalDate fecha, Usuario usuario, String estado, Double peso) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.usuario = usuario;
		this.estado = estado;
		this.peso = peso;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}
    
	public void calcularImc() {
		Double alturaCuadrada = (this.usuario.getEstatura()/100)*(this.usuario.getEstatura()/100);
		Double resultado = this.peso / alturaCuadrada;
		if(resultado<18.5) {
			this.estado = resultado.intValue() + " - Está por debajo de su peso ideal.";
		}else {
			if(resultado>=18.5 && resultado <=25) {
				this.estado = resultado.intValue() + " - Está en su peso normal.";
			}else {
				this.estado = resultado.intValue() + " - Tiene sobrepeso.";
			}
		}
	}
	
	
}

