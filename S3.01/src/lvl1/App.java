package lvl1;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		menu();

	}

	static void menu() {
		int opcion;
		do {
			opcion = askNum(
					"Elige una opción: \n1: Añadir palabra. \n2: Ver palabras. \n3: Eliminar palabras. \n0: Salir");
			switch (opcion) {

			case 1:
				int numWords;
				do {
					numWords = askNum("¿Cuántas palabras quieres añadir?");
					if (numWords <= 0) {
						System.out.println("No has seleccionado una cantidad.");
					}
				} while (numWords <= 0);
				for (int i = 0; i < numWords; i++) {
					String word = askWord("Introduce la palabra a añadir");
					Undo u = Undo.getInstance();
					u.addComand(word);
				}
				break;

			case 2:
				Undo x = Undo.getInstance();
				x.showComands();
				break;

			case 3:
				do {
					numWords = askNum("¿Cuántas palabras quieres borrar?");
					if (numWords <= 0) {
						System.out.println("No has seleccionado una cantidad.");
					}
				} while (numWords <= 0);
				for (int i = 0; i < numWords; i++) {
					String word = askWord("Introduce la palabra que quieres borrar");
					Undo y = Undo.getInstance();
					y.deleteComand(word);
				}
				break;

			case 0:
				System.out.println("¡Adiós!");
				break;

			default:
				System.out.println("La opción elegida no es correcta");
			}
		} while (opcion != 0 || opcion < 0 && opcion > 3);
	}

	static String askWord(String message) {
		Scanner sc = new Scanner(System.in);
		System.out.println(message);
		String dato = sc.nextLine();
		return dato;
	}

	static int askNum(String mensaje) {
		Scanner sc = new Scanner(System.in);
		System.out.println(mensaje);
		int dato = sc.nextInt();
		sc.nextLine();
		return dato;
	}

}
