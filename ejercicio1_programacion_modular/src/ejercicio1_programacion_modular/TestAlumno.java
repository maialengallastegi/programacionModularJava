package ejercicio1_programacion_modular;
import java.util.Scanner;

public class TestAlumno {

	/* 
	 * Preguntar cu�ntos alumnos matriculados hay y guardar esa cantidad.
	 * Seg�n el n�mero de alumnos matriculados, preguntar sus nombres y sus edades.
	 * Mostrar la informaci�n obtenida anteriormente: Nombre y edad de cada alumno
	 * Obtener la media de la edades de los alumnos
	 * Mostrar qu� alumno es el que tiene mayor edad (mostrando el alumno y su edad)
	 * Mostrar qu� alumno es el que tiene menor edad (mostrando el alumno y su edad)
	 * Obtener el alumno con el nombre m�s largo.
	 */

	// preguntar nombre de alumnos

	public static String[] nombres (int matriculados, Scanner sc) {
		String[] nombres = new String[matriculados];

		for (int i=0; i<matriculados; i++) {
			System.out.println("introduce el nombre del alumno n�mero "+(i+1));
			nombres[i]=sc.next();
		}

		return nombres;

	}

	// preguntar a�os de alumnos

	public static int[] anos (int matriculados, Scanner sc) {
		int[] anos = new int[matriculados];

		for (int i=0; i<matriculados; i++) {
			System.out.println("introduce el nombre del alumno n�mero "+(i+1));
			anos[i]=sc.nextInt();
		}

		return anos;

	}

	public static void media_mayor_menor(int[]anos) {
		int suma=0;
		int mayor=0;
		int menor=100;
		float media;
		for(int i=0; i<anos.length; i++) {
			if (anos[i]>mayor) {
				mayor=anos[i];
			}
			if (anos[i]<menor) {
				menor=anos[i];
			}
			suma+=anos[i];
		}

		media=(float)suma/anos.length;
		System.out.println("La media de edad de los matriculados es: "+media);
		System.out.println("El alumno m�s joven tiene: "+menor+" a�os.");
		System.out.println("El alumno m�s viejo tiene: "+mayor+" a�os.");
	}

	public static void largo(String[]nombres) {
		int largo_letras=nombres[0].length();
		String nombre_largo=nombres[0];
		
		for(int i=0; i<nombres.length; i++) {
		
			if (nombres[i].length()>largo_letras) {
				nombre_largo=nombres[i];
			}
		}
		System.out.println("El nombre con m�s letras es: "+nombre_largo);
	}


	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int matriculados=0;
		boolean error = true;
		String[] nombres;
		int[] anos;

		do{
			try{
				System.out.println("�Cu�ntos alumnos matriculados hay?"); 
				matriculados = sc.nextInt();
				error = false;
			}catch(Exception e) {
				System.out.println("El n�mero tiene que ser entero");
				error=true;
				sc.next();
			}
		}while(error);

		nombres=nombres(matriculados, sc);
		anos=anos(matriculados, sc);

		for(int i=0; i<matriculados; i++) {
			System.out.println(nombres[i]+" - "+anos[i]+" a�os"); 
		}
		media_mayor_menor(anos);
		largo(nombres);
		sc.close();

	}

}
