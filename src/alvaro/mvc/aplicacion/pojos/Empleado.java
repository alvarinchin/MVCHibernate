package alvaro.mvc.aplicacion.pojos;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Empleado {

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique=true)
	private String nombre;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Ciudad ciudad;
	
	@ManyToMany(fetch=FetchType.LAZY)
	private Collection <LenguajeProgramacion> lenguajes;
	
	public Empleado(){
		
	}
	
	public Empleado(String nombre, Ciudad ciudad, Collection<LenguajeProgramacion> lenguajes) {
	
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.lenguajes= lenguajes;
		
	}

	public Collection<LenguajeProgramacion> getLenguajes() {
		return lenguajes;
	}

	public void setLenguajes(Collection<LenguajeProgramacion> lenguajes) {
		this.lenguajes = lenguajes;
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
	
	@ManyToOne(fetch=FetchType.LAZY)
	public Ciudad getCiudad() {
		return ciudad;
	}
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

}
