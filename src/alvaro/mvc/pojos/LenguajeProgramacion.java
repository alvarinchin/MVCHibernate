package alvaro.mvc.pojos;

import javax.persistence.*;

@Entity
public class LenguajeProgramacion {

	public LenguajeProgramacion() {

	}

	public LenguajeProgramacion(String nombre) {

		this.nombre = nombre;
	}
	@Column(unique=true)
	private String nombre;
	private long id;

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
