package lvl1;

import java.util.ArrayList;

public class Undo {

	private static ArrayList<String> bbdd;
	private static Undo instance;

	private Undo() {
		bbdd = new ArrayList<String>();
	}

	public static Undo getInstance() { //Singleton
		if (instance == null) {
			instance = new Undo();
		}
		return instance;
	}

	public void addComand(String word) {
		bbdd.add(word);
		System.out.println("La palabra " + word + " se ha guardado correctamente.");
	}

	public void deleteComand(String word) {
		bbdd.remove(find(word));
		System.out.println("La palabra " + word + " se ha borrado correctamente.");
	}

	public void showComands() {
		bbdd.forEach(s -> System.out.println(s));
	}

	private int find(String word) {
		int i = 0;
		int index = 0;
		boolean match = false;
		while (match) {
			match = bbdd.get(i).equalsIgnoreCase(word);
			if (match == true) {
				index = i;
			}
			i++;
		}
		return index;
	}

}
