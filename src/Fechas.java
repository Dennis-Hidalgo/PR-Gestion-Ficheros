import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Fechas {
	
	//La fecha introducida por el usuario en forma de string, la trasformo en localdate
	public static LocalDate transformarFechaString(String datos) {
		
		LocalDate fechaLocalDate;
		String[] FechaString = datos.split("-");
		int[] resultado = new int[3];
		int contador=0;
		
		for(String numero : FechaString) {
			resultado[contador] = Integer.parseInt(numero);
			contador++;
		}
		
		fechaLocalDate = LocalDate.of(resultado[2], resultado[1], resultado[0]);
		return fechaLocalDate;
	}
	
	//Metodo que devuelve la edad, recibiendo el localdate, se llama a este metodo en el constructor para que
	//La edad se asigne automaticamente
	public static int obtenerEdad(LocalDate fecha) {
		return (int)ChronoUnit.YEARS.between(fecha, LocalDate.now());
	}
	
	//Metodo que recoge la edad del fichero en String y la transforma en localdate
	public static LocalDate fechaFichero(String fecha) {
		LocalDate fechaLocalDate;
		String[] FechaString = fecha.split("-");
		int[] resultado = new int[3];
		int contador=0;
		
		for(String numero : FechaString) {
			resultado[contador] = Integer.parseInt(numero);
			contador++;
		}
		
		fechaLocalDate = LocalDate.of(resultado[0], resultado[1], resultado[2]);
		return fechaLocalDate;
	}

}
