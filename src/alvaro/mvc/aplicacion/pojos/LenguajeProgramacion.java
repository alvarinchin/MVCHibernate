package alvaro.mvc.aplicacion.pojos;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class LenguajeProgramacion {

	private String nombre;

	private long id;

	private Collection<Empleado> empleados;

	public LenguajeProgramacion() {

	}

	public LenguajeProgramacion(String nombre) {

		this.nombre = nombre;
		this.empleados = new ArrayList<Empleado>();
	}

	public LenguajeProgramacion(String nombre, Collection<Empleado> lenguajes) {

		this.nombre = nombre;
		this.empleados = lenguajes;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "lenguajes")
	public Collection<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Collection<Empleado> empleados) {
		this.empleados = empleados;
	}

	@Column(unique = true)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@GeneratedValue
	@Id
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
