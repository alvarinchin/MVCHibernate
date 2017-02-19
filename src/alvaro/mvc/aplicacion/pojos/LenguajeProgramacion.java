package alvaro.mvc.aplicacion.pojos;

import java.util.Collection;

import javax.persistence.*;

@Entity
public class LenguajeProgramacion {

	public LenguajeProgramacion() {

	}

	public LenguajeProgramacion(String nombre) {

		this.nombre = nombre;
	}

	@Column(unique = true)
	private String nombre;

	@GeneratedValue
	@Id
	private long id;

	private Collection<Empleado> empleados;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "lenguajes")
	public Collection<Empleado> getLenguajes() {
		return empleados;
	}

	public void setLenguajes(Collection<Empleado> empleados) {
		this.empleados = empleados;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
