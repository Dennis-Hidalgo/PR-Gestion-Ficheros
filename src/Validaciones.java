import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Validaciones {

	//Metodo que valida que el formato de la fecha sea correcto
	public static boolean formatoFecha(String fecha) {
		boolean diaCorrecto = false;
		boolean mesCorrecto = false;
		boolean yearCorrecto = false;
		boolean todoCorrecto = false;
		if (fecha.split("-").length != 3) {
			System.out.println("formato Invalido");
		} else {
			String[] datos = fecha.split("-");
			try {
				int day = Integer.parseInt(datos[0]);
				int month = Integer.parseInt(datos[1]);
				int year = Integer.parseInt(datos[2]);

				//Condicionales para verificar que el numero de dias, coincida con el mes y que el mes exista
				if (day > 1 && day <= 31) {
					diaCorrecto = true;
				}
				if (month > 1 && month <= 12) {
					mesCorrecto = true;
					if (month == 2 && day > 28) {
						diaCorrecto = false;
					}
					if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) {
						diaCorrecto = false;
					}
				}
				if (year > 1900 && year < LocalDate.now().getYear()) {
					yearCorrecto = true;
				}

				if (diaCorrecto && mesCorrecto && yearCorrecto) {
					todoCorrecto = true;
				} else {
					System.out.println("Formato invalido");
				}
			} catch (NumberFormatException e) {
				System.err.println("NO introducir letras");
			}
			
		}
		return todoCorrecto;
	}

	
	public static String validarString() {
		boolean correcto;
		String cadena;
		int longitud;
		Scanner sc = new Scanner(System.in);
		do {
			cadena = sc.nextLine().trim();
			longitud = cadena.length();
			if (longitud == 0) {
				System.err.println("No puedes ingresar espacios en blanco, vuelve a introducirlo");
			}
		} while (cadena.length() == 0);
		return cadena;
	}
}

