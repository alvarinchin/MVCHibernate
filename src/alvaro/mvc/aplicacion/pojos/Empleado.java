package alvaro.mvc.aplicacion.pojos;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Empleado {

	@Id
	@GeneratedValue
	private Long id;
	@Column(unique=true)
	private String nombre;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Ciudad ciudad;
	
	public Empleado(){
		
	}
	
	public Empleado(String nombre, Ciudad ciudad) {
	
		this.nombre = nombre;
		this.ciudad = ciudad;
	}

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
	
	

	public Ciudad getCiudad() {
		return ciudad;
	}
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

}
