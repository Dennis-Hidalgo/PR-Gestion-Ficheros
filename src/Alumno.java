import java.time.LocalDate;

public class Alumno {
	
	private String nombre;
	private LocalDate fechaNac;
	private String grupo;
	private int edad;
	
	public Alumno(String nombre, LocalDate fechaNac, String grupo) {
		super();
		this.nombre = nombre;
		this.fechaNac = fechaNac;
		this.grupo = grupo;
		this.edad = Fechas.obtenerEdad(fechaNac);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", fechaNac=" + fechaNac + ", grupo=" + grupo + ", edad=" + edad + "]";
	}
	
}
