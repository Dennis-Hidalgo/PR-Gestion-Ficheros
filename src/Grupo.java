
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grupo {

	private ArrayList<Alumno> plantilla = new ArrayList<Alumno>();
	private String nombre;

	public Grupo(String nombre) {
		super();
		this.nombre = nombre;
	}

	public ArrayList<Alumno> getPlantilla() {
		return plantilla;
	}

	public void setPlantilla(ArrayList<Alumno> plantilla) {
		this.plantilla = plantilla;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Grupo [plantilla=" + plantilla + ", nombre=" + nombre + "]";
	}

	public void addAlumno2(String nombre, LocalDate fecha, String grupo) {
		plantilla.add(new Alumno(nombre, fecha, grupo));
	}

	public void addAlumno(fichero fichero) {
		String nombreAlumno;
		LocalDate fechaAlumno;
		String grupoAlumno;
		String datosFecha;
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el nombre del alumno");
		nombreAlumno = Validaciones.validarString();
		do {
			System.out.println("Introducir la fecha de nacimiento del alumno (formato: DD-MM-AAAA)");
			datosFecha = Validaciones.validarString();
		} while (!Validaciones.formatoFecha(datosFecha));
		fechaAlumno = Fechas.transformarFechaString(datosFecha);
		System.out.println("Introduce el grupo al que pertenece el alumno");
		grupoAlumno = Validaciones.validarString();
		plantilla.add(new Alumno(nombreAlumno, fechaAlumno, grupoAlumno));
		fichero.escribirFichero(plantilla.get(plantilla.size()-1));
	}
	
	
	public ArrayList<Alumno> cumplePorMes(String mes) {
		ArrayList<Alumno> resultado = new ArrayList<Alumno>();
		for (Alumno alumno : plantilla) {
			if (alumno.getFechaNac().getMonth().toString().equals(mes)) {
				resultado.add(alumno);
			}
		}
		return resultado;
	}

	//Creo una nueva clase que recoja los datos de nombre y edad
	public ArrayList<AlumnoEdad> ordenarAlumnos() {
		ArrayList<Integer> edades = recogerEdadesOrdenadas();
		ArrayList<AlumnoEdad> lista = new ArrayList<AlumnoEdad>();
		int i = 0;
		int j = 0;
		boolean encontrado;
		//Bucle que ordena las edades, y las relaciona con el nombre correspondiente
		do {
			do {
				if (edades.get(i) == plantilla.get(j).getEdad()) {
					encontrado = true;
					lista.add(new AlumnoEdad(plantilla.get(j).getNombre(), edades.get(i)));
				} else {
					encontrado = false;
					j++;
				}
			} while (!encontrado);
			i++;
			j = 0;
		} while (i < edades.size());
		i = 0;
		return lista;
	}

	
	public void mostrarMayores() {
		ArrayList<Alumno> lista = new ArrayList<Alumno>();

		for (Alumno alumno : plantilla) {
			if (alumno.getEdad() >= 18) {
				lista.add(alumno);
			}
		}
		for (Alumno elemento : lista) {
			System.out.println(elemento.toString());
		}
	}

	
	public ArrayList<Integer> recogerEdadesOrdenadas() {
		ArrayList<Integer> edades = new ArrayList<Integer>();
		for (Alumno alumno : plantilla) {
			edades.add(alumno.getEdad());
		}
		Collections.sort(edades);
		Collections.reverse(edades);
		return edades;
	}
	

	public void mayorYMenor() {
		ArrayList<AlumnoEdad> lista = ordenarAlumnos();
		System.out.println("Mayor : " + lista.get(0).toString());
		System.out.println("Menor : " + lista.get(lista.size() - 1).toString());
	}

	
	public double mediaEdades() {
		int resultado = 0;
		for (int n : recogerEdadesOrdenadas()) {
			resultado += n;
		}
		return (resultado / recogerEdadesOrdenadas().size());
	}

	
	public ArrayList<Alumno> mostrarPorRango() {
		ArrayList<Alumno> lista = new ArrayList<Alumno>();
		int mayor;
		int menor;
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce la mayor edad (incluida)");
		mayor = sc.nextInt();
		sc.nextLine();
		System.out.println("Introduce la menor edad(Incluida)");
		menor = sc.nextInt();
		sc.nextLine();

		for (Alumno alumno : plantilla) {
			if (alumno.getEdad() >= menor && alumno.getEdad() <= mayor) {
				lista.add(alumno);
			}
		}
		return lista;
	}
}
