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

/**
 * Entidad que representa el Índice de Masa Corporal (IMC) de un usuario.
 */

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
    
	/**
     * Constructor vacío.
     */
	
    public IndiceMasaCorporal() {
		// TODO Auto-generated constructor stub
	}
    
    /**
     * Constructor parametrizado.
     * @param id Identificador del índice de masa corporal.
     * @param fecha Fecha en que se calculó el índice.
     * @param usuario Objeto Usuario asociado al índice.
     * @param estado Estado de acuerdo al resultado del cálculo del IMC.
     * @param peso Peso del usuario en kilogramos.
     */

	public IndiceMasaCorporal(Long id, LocalDate fecha, Usuario usuario, String estado, Double peso) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.usuario = usuario;
		this.estado = estado;
		this.peso = peso;
	}
	
	/**
     * Obtiene el identificador del índice de masa corporal.
     * @return Identificador del índice de masa corporal.
     */

	public Long getId() {
		return id;
	}
	
	/**
     * Establece el identificador del índice de masa corporal.
     * @param id Identificador del índice de masa corporal.
     */

	public void setId(Long id) {
		this.id = id;
	}
	
	/**
     * Obtiene la fecha en que se calculó el índice.
     * @return Fecha en que se calculó el índice.
     */

	public LocalDate getFecha() {
		return fecha;
	}
	
	/**
     * Establece la fecha en que se calculó el índice.
     * @param fecha Fecha en que se calculó el índice.
     */

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	/**
     * Obtiene el objeto Usuario asociado al índice de masa corporal.
     * @return Objeto Usuario asociado al índice de masa corporal.
     */

	public Usuario getUsuario() {
		return usuario;
	}
	
	/**
     * Establece el objeto Usuario asociado al índice de masa corporal.
     * @param usuario Objeto Usuario asociado al índice de masa corporal.
     */

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	/**
     * Obtiene el estado de acuerdo al resultado del cálculo del IMC.
     * @return Estado del usuario según el IMC.
     */

	public String getEstado() {
		return estado;
	}
	
	/**
     * Establece el estado de acuerdo al resultado del cálculo del IMC.
     * @param estado Estado del usuario según el IMC.
     */

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	/**
     * Obtiene el peso del usuario en kilogramos.
     * @return Peso del usuario en kilogramos.
     */

	public Double getPeso() {
		return peso;
	}
	
	/**
     * Establece el peso del usuario en kilogramos.
     * @param peso Peso del usuario en kilogramos.
     */

	public void setPeso(Double peso) {
		this.peso = peso;
	}
	
	/**
     * Calcula el Índice de Masa Corporal (IMC) y determina el estado del usuario.
     */
    
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

