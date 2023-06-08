
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Gestion {

	public static void main(String[] args) {
		// TODO Esbozo de método generado automáticamente

		fichero miFichero = new fichero("Datos/ficheroNuevo.txt");
		Grupo dam = new Grupo("DAM");
		int indiceMenu;
		String mes;
		Scanner sc = new Scanner(System.in);
		dam.setPlantilla(recogerFichero(miFichero.devolverFichero()));
		do {
			System.out.println("\nIntroduce la opcion del menu que deseas realizar:");
			System.out.println(
					"1. Añadir Alumno \n2. Mostrar cumpleaños de un mes \n3. Mostrar alumno mayor y menor \n4. Mostrar Fichero ");
			System.out.println(
					"5. Mostrar los alumnos con edad > 18 \n6. Mostrar alumnos por rango de edades \n7. mostrar lista ordenada por edad");
			System.out.println("8. mostrar la media de edad de la plantilla\n9. Salir del menu");
			indiceMenu = sc.nextInt();
			sc.nextLine();

			if (dam.getPlantilla().size() == 0 && (indiceMenu != 1 && indiceMenu != 4 && indiceMenu > 9)) {
				System.out.println("Aun no hay alumnos en el grupo");
			} else {
				switch (indiceMenu) {
				case 1:
					dam.addAlumno(miFichero);
					break;
				case 2:
					System.out.println("Escribe el nombre del mes (En ingles)");
					mes = sc.nextLine().toUpperCase();
					System.out.println(dam.cumplePorMes(mes).toString());
					break;
				case 3:
					dam.mayorYMenor();
					break;
				case 4:
					miFichero.leerFichero();
					break;
				case 5:
					dam.mostrarMayores();
					break;
				case 6:
					for (Alumno alumnoN : dam.mostrarPorRango()) {
						System.out.println(alumnoN);
					}
					break;
				case 7:
					for (AlumnoEdad alumnoN : dam.ordenarAlumnos()) {
						System.out.println(alumnoN);
					}
					break;
				case 8:
					System.out.println("La media de edades es: " + dam.mediaEdades());
					break;
				case 9:
					System.out.println("Gracias por usar este menu");
					break;
				}
			}
		} while (indiceMenu != 9);
		
	}

	//Metodo que recoge los datos del fichero, y los carga en el proyecto
	public static ArrayList<Alumno> recogerFichero(ArrayList<String> texto) {
		String nombre;
		String fechaString;
		LocalDate fecha;
		String grupo;
		ArrayList<Alumno> devolver = new ArrayList<Alumno>();
		for (String registro : texto) {
			nombre = registro.substring(registro.indexOf("Nombre: ") + ("Nombre: ").length(), registro.indexOf(" |"));
			fechaString = registro.substring(registro.indexOf("Fecha de nacimiento: ") + ("Fecha de nacimiento: ").length(),
					registro.lastIndexOf(" |"));
			fecha = Fechas.fechaFichero(fechaString);
			grupo = registro.substring(registro.indexOf("Grupo: ") + ("Grupo: ").length(), registro.indexOf(")"));
			devolver.add(new Alumno(nombre, fecha, grupo));
		}
		return devolver;
	}

}
