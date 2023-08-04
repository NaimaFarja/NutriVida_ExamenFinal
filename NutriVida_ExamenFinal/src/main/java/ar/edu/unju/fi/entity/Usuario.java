package ar.edu.unju.fi.entity;

import java.time.LocalDate;
import java.time.Period;
//import java.util.ArrayList;
//import java.util.List;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
//import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

/**
 * Representa a un usuario en el sistema.
 */

public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "El campo nombre no puede estar vacio.")
	private String nombre;
	
	@NotEmpty(message = "El campo apellido no puede estar vacio.")
	private String apellido;
	
	@NotEmpty(message = "El campo email no puede estar vacio.")
	@Email
	private String email;
	
	@NotEmpty(message = "El campo telefono no puede estar vacio.")
	private String telefono;
	
	@NotEmpty(message = "Debe seleccionar una opcion.")
	private String sexo;
	
	@NotNull(message = "Debe ingresar una fecha de nacimiento.")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNac;
	
	@NotNull(message = "El campo estatura no puede estar vacio.")
	private Double estatura;
	
	@OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<IndiceMasaCorporal> imc = new ArrayList<IndiceMasaCorporal>();
	
	@OneToMany(mappedBy = "usuario", orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Testimonio> testimonios = new ArrayList<Testimonio>();
	
	private Boolean admin=false;
	
	/**
	 * Constructor vacio
	 */
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	/**
     * Constructor parametrizado.
     *
     * @param id          ID del usuario.
     * @param nombre      Nombre del usuario.
     * @param apellido    Apellido del usuario.
     * @param email       Dirección de correo electrónico del usuario.
     * @param telefono    Número de teléfono del usuario.
     * @param sexo        Género del usuario.
     * @param fechaNac    Fecha de nacimiento del usuario.
     * @param estatura    Estatura del usuario.
     * @param imc         Lista de índices de masa corporal asociados al usuario.
     * @param testimonios Lista de testimonios asociados al usuario.
     */
	public Usuario(Long id, String nombre, String apellido, String email, String telefono, String sexo,
			LocalDate fechaNac, Double estatura, List<IndiceMasaCorporal> imc, List<Testimonio> testimonios) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.sexo = sexo;
		this.fechaNac = fechaNac;
		this.estatura = estatura;
		this.imc = imc;
		this.testimonios = testimonios; 
	}

	/**
	 * Getters y Setters
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public Double getEstatura() {
		return estatura;
	}

	public void setEstatura(Double estatura) {
		this.estatura = estatura;
	}

	public List<IndiceMasaCorporal> getImc() {
		return imc;
	}

	public void setImc(List<IndiceMasaCorporal> imc) {
		this.imc = imc;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	
	public List<Testimonio> getTestimonio() {
		return testimonios;
	}

	public void setTestimonio(List<Testimonio> testimonios) {
		this.testimonios = testimonios;
	}

	/**
     * Calcula la edad del usuario en años, con respecto a la fecha actual.
     *
     * @return Edad del usuario en años.
     */
	
	public int calcularEdad() {
		LocalDate fechaActual = LocalDate.now();
		Period periodo = Period.between(fechaNac, fechaActual);
		return periodo.getYears();
	}
	
	/**
     * Calcula el peso ideal del usuario basado en su estatura y edad.
     *
     * @return Peso ideal del usuario.
     */
	
	public double calcularPesoIdeal() {
		
		double pesoId = estatura - 100 + ((this.calcularEdad()/10)*0.9);
		return pesoId;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", telefono=" + telefono + ", sexo=" + sexo + ", fechaNac=" + fechaNac + ", estatura=" + estatura
				+ ", imc=" + imc + ", testimonios=" + testimonios + ", admin=" + admin + "]";
	}
}