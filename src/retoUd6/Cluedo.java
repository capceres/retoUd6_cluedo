package retoUd6;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Logger;

public class Cluedo {
	
	//Este metodo recibe un array y lo copia en uno nuevo añadiendo elementos
	private static String[] actualizarArray(String[] arrayAntiguo, int num) {
		
		String[] arrayNuevo = new String[arrayAntiguo.length + num];
		System.arraycopy(arrayAntiguo, 0, arrayNuevo, 0, arrayAntiguo.length);
		
		return arrayNuevo;
		
	}
	
	//Este metodo elige un elemento aleatorio de entre todos los existentes en un array
	private static String barajarArray(String[] elArray) {
		
		int numeroRandom = (int) (Math.random() * elArray.length);
		return elArray[numeroRandom];
		
	}
	

	public static void main(String[] args) {
		//array de personajes, armas y habitacions
		String[] personajes = {"Amapola", "Celeste", "Prado", "Mora", "Rubio", "Blanco"};
		String[] armas = {"bate", "pistola", "candelabro", "cuchillo", "cuerda", "hacha", "pesa", "veneno", "trofeo"};
		String[] habitaciones = {"casa de invitados", "teatro", "spa", "observatorio", "comedor", "terraza", "salón", "cocina", "vestíbulo"}; 

		//ArrayList o lista dinamica de Jugador
		ArrayList<Jugador> jugadas = new ArrayList<>();
		
		//se comienza una nueva partida
		boolean bandera = true;
		boolean bandera2 = true;
		
		while (bandera) {
			//mensaje de bienvenida
			System.out.print("Bienvenid@ a una nueva partida de Cluedo. A continuación, se mostrarán las cartas de inicio del juego." + "\n");
		
			//se muestran todas las cartas
			System.out.println("\n" + "-- PERSONAJES ------------ ");
			for(int i=0; i< personajes.length; i++) {
				System.out.println(personajes[i]);
			}
			
			System.out.println("\n" + "-- ARMAS ------------ ");
			for(int i=0; i< armas.length; i++) {
				System.out.println(armas[i]);
			}
			
			System.out.println("\n" + "-- HABITACIONES ------------ ");
			for(int i=0; i< habitaciones.length; i++) {
				System.out.println(habitaciones[i]);
			}
			
			//se consulta al usuario si quiere añadir algo mas		
			String addCarta = "s";
			
			Scanner sc = new Scanner(System.in);
			while("s".equals(addCarta)) {
				
				System.out.println("\n" + "¿Quieres añadir alguna carta más? Escribe 's' o 'n': ");
				addCarta = sc.next();
				
				if ("s".equals(addCarta)) {
					System.out.println("\n" + "Escribe un número entre el 1-4 según qué carta quieres añadir: " + "\n" + "1.Personaje" + "\n" + "2.Arma" + "\n" + "3.Habitación" + "\n" + "4.Salir");
					int numCarta = sc.nextInt();
					
					//segun la respuesta se puede modificar un tipo de carta
					switch (numCarta) {
					
						case 1: {
							//personajes
							System.out.println("\n" + "¿Cuántos personajes quieres añadir?: ");
							int num = sc.nextInt();
							personajes = actualizarArray(personajes, num);
							sc.nextLine();
							
							for (int i = personajes.length - num; i < personajes.length; i++) {
								System.out.println("\n" + "Introduce el nombre del nuevo personaje " + (i+1) + "/" + personajes.length + ": ");
								String introDato = sc.nextLine();
								personajes[i] = introDato;
							}					
							System.out.println("\n" + "El nuevo listado de personajes es: " + Arrays.toString(personajes));
							break;
							}
						
						case 2: {
							//armas
							System.out.println("\n" + "¿Cuántas armas quieres añadir?: ");
							int num = sc.nextInt();
							personajes = actualizarArray(armas, num);
							sc.nextLine();
							
							for (int i = armas.length - num; i < armas.length; i++) {
								System.out.println("\n" + "Introduce el nombre del nuevo arma " + (i+1) + "/" + armas.length + ": ");
								String introDato = sc.nextLine();
								armas[i] = introDato;
							}					
							System.out.println("\n" + "El nuevo listado de armas es: " + Arrays.toString(armas));
							break;
							}
						
						case 3: {
							//habitaciones
							System.out.println("\n" + "¿Cuántas habitaciones quieres añadir?: ");
							int num = sc.nextInt();
							habitaciones = actualizarArray(habitaciones, num);
							sc.nextLine();
							
							for (int i = habitaciones.length - num; i < habitaciones.length; i++) {
								System.out.println("\n" + "Introduce el nombre de la nueva habitación " + (i+1) + "/" + habitaciones.length + ": ");
								String introDato = sc.nextLine();
								habitaciones[i] = introDato;
							}					
							System.out.println("\n" + "El nuevo listado de habitaciones es: " + Arrays.toString(habitaciones));
							break;
							}
						
						case 4: {
							//salir
							addCarta = "n";
							break;
						}
					}
					
					
				} else if ("n".equals(addCarta)) {
					System.out.println("\n" + "¡Genial, sigamos!");
					addCarta = null;
					
				} else {
					System.out.println("\n" + "Debe introducir el valor 's' o 'n'." );
					addCarta = "s";
				}
				
			}
			
			//se informa de que las cartas de van a barajar
			System.out.println("\n" + "Se va a proceder a barajar las cartas de manera aleatoria...");
			LocalDateTime horaActual = LocalDateTime.now();
			
			Jugador asesino = new Jugador(barajarArray(personajes), barajarArray(armas), barajarArray(habitaciones), horaActual);
			jugadas.add(asesino);
			
			System.out.println("\n" + "--- ¡Cartas barajadas! ¿Quién será el asesino? ---");
			
			
			//se consulta si se desea ver las cartas del asesino, para ello se requiere una clave
			System.out.println("\n" + "¿Quieres ver las 3 cartas con el nombre del asesino, el arma y la habitación del crimen? Escribe 's' o 'n': ");
			String verCartas = "s";
			
			while("s".equals(verCartas)) {
				verCartas = sc.next();
				
				if ("s".equals(verCartas)) {
					System.out.println("\n" + "Introduce la clave para ver los datos del asesino: ");
					String clave = "clave123";
					String userPass = sc.next();
					
					if(clave.equals(userPass)) {
						System.out.println("\n" + "Los datos del asesino son estos: " + asesino.mostrarJugador());
					} else {
						System.out.println("\n" + "La clave no es correcta. No tienes permiso para ver los datos del asesino.");
					}
					
					verCartas = null;
					
					
				} else if ("n".equals(verCartas)) {
					verCartas = null;
					
				} else {
					System.out.println("\n" + "Debe introducir el valor 's' o 'n'." );
					verCartas = "s";
				}
			}
			
			
			//se consulta si se quiere una nueva combinacion de cartas para el juego
			System.out.println("\n" + "¿Quieres crear una nueva combinación de cartas para el juego? Escribe 's' o 'n': ");
			bandera2 = true;
			
			while(bandera2) {				
				String nuevaPartida = sc.next();

				if ("s".equals(nuevaPartida)) {
					bandera2 = false;
	 
					
				} else if ("n".equals(nuevaPartida)) {
					bandera = false;
					bandera2 = false;
					System.out.println("\n" + "Fin del juego, esperamos que hayas disfrutado de tu partida de Cluedo :)");
					sc.close();
					
				} else {
					System.out.println("\n" + "Debe introducir el valor 's' o 'n'." );
				}
				
				
			}
			
			
			
			//se escribe una nueva linea en un fichero de texto con los datos del asesino
			try {
				String directorioActual = System.getProperty("user.dir");

				FileWriter fw=new FileWriter(directorioActual + "listadoAsesinos.txt", true);
				System.out.println("\n" + "Los datos del asesino se han añadido al archivo: " + directorioActual + "listadoAsesinos.txt" + "\n");

				//Se rellena en archivo de texto, el \n crea un salto de linea
				fw.write(asesino.mostrarJugador() + "\n");

				//Se cierra el canal y se libera memoria
				fw.close();

			} catch (IOException ex) {
				Logger.getAnonymousLogger();
			}
			
			
			
		}
		

	}

}
