package alvaro.mvc.aplicacion.pojos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Ciudad {

	private Long id;

	private String nombre;

	private Collection<Empleado> empleados;

	public Ciudad() {
		this.empleados=new ArrayList<Empleado>();
	}

	public Ciudad(String nombre) {
		super();
		this.nombre = nombre;
		this.empleados=new ArrayList<Empleado>();

	}

	public Ciudad(String nombre, Set<Empleado> empleados) {
		this.nombre = nombre;
		this.empleados = empleados;
	}

	public void addEmpleado(Empleado empleado) {
		this.empleados.add(empleado);
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "ciudad")
	public Collection<Empleado> getEmpleados() {
		return  empleados;
	}

	public void setEmpleados(Collection<Empleado> empleados) {
		this.empleados = empleados;
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

}
