import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/***
 * Class de lancement du programme (main)
 *
 */
public class DeadOrAlive {

	// instanciation de la grille avec des valeurs par défaut
	static Grid grid = new Grid();

	public static void main(String[] args) throws IOException {

		// Lecture du fichier d'entrèe
		readFile();
		// Affichage de la grille du départ
		grid.toString();
		// calcul et affichage de l'évolution de la grille
		grid.nextLive();

	}

	private static void readFile() throws IOException {
		// récupération du fichier d'entrée depuis le datasource
		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream("src/dataSource/input.txt"), StandardCharsets.UTF_8));) {

			String line;
			int x, y;
			// récuoèration des paramètres : xMax, yMax et nb itération
			line = br.readLine();
			if (line != null) {
				String[] splited = line.split("\\s+");
				x = Integer.parseInt(splited[0]);// + 2;
				y = Integer.parseInt(splited[1]);// + 2;
				int nbIteration = Integer.parseInt(splited[2]);
				grid = new Grid(x, y, nbIteration);

			}
			// récupération des coordonnées des cellules vivantes
			while ((line = br.readLine()) != null) {
				String[] splited = line.split("\\s+");
				x = Integer.parseInt(splited[0]); // + 1;
				y = Integer.parseInt(splited[1]); // + 1;
				grid.cellules[y][x].etat = true;

			}

		}

	}

}
