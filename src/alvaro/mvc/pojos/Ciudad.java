package alvaro.mvc.pojos;


import javax.persistence.*;

@Entity

public class Ciudad {
	
	private long id;
	private String nombre;
	
	public Ciudad(){
		
	}
	
	
	public Ciudad(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
