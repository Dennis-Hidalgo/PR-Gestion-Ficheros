import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class fichero {

	private String ruta;

	public fichero(String ruta) {
		super();
		this.ruta = ruta;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	@Override
	public String toString() {
		return "fichero [ruta=" + ruta + "]";
	}

	public void escribirFichero(Alumno alumno) {
		FileWriter guardar = null;
		try {
			guardar = new FileWriter(ruta, true);// true = append
			guardar.write("Nombre: " + alumno.getNombre() + " | Fecha de nacimiento: " + alumno.getFechaNac() + " | Grupo: "
					+ alumno.getGrupo() + (char) 13);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Un error incontrolado");
		} finally {
			try {
				if (guardar != null) {
					guardar.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	@SuppressWarnings("finally")
	public ArrayList<String> devolverFichero() {

		FileReader fichero = null;
		BufferedReader lector = null;
		String cadena;
		ArrayList<String> contenido = new ArrayList<String>();

		try {
			fichero = new FileReader(ruta);
			lector = new BufferedReader(fichero);

			while ((cadena = lector.readLine()) != null) {
				contenido.add("(" + cadena + ")");
			}

		} catch (FileNotFoundException e) {
			System.out.println("No se encuentra el fichero");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error inesperado");
			e.printStackTrace();
		} finally {
			try {
				if (lector != null) {
					lector.close();
				}
				if (fichero != null) {
					fichero.close();
				}

			} catch (IOException e) {
				System.out.println("Error al cerrar el fichero");
				e.printStackTrace();
			} finally {
				return contenido;
			}

		}

	}
	
	public void leerFichero() {

        FileReader fichero = null;
        BufferedReader lector = null;
        String cadena;

        try {
            fichero = new FileReader(ruta);
            lector = new BufferedReader(fichero);

            while ((cadena = lector.readLine()) != null) {
                System.out.println(cadena);
            }

        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el fichero");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error de entrada/salida");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error inesperado");
            e.printStackTrace();
        } finally {
            try {
                if (lector != null) {
                    lector.close();
                }
                if (fichero != null) {
                    fichero.close();
                }

            } catch (IOException e) {
                System.out.println("Error al cerrar el fichero");
                e.printStackTrace();
            }

        }

    }

}
