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

	private Long id;

	private String nombre;

	private Ciudad ciudad;

	private Collection<LenguajeProgramacion> lenguajes;

	public Empleado() {

	}

	public Empleado(String nombre, Ciudad ciudad, Collection<LenguajeProgramacion> lenguajes) {

		this.nombre = nombre;
		this.ciudad = ciudad;
		this.lenguajes = lenguajes;

	}

	@ManyToMany(fetch = FetchType.LAZY)
	public Collection<LenguajeProgramacion> getLenguajes() {
		return lenguajes;
	}

	public void setLenguajes(Collection<LenguajeProgramacion> lenguajes) {
		this.lenguajes = lenguajes;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(unique = true)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

}
