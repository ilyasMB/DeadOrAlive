/***
 * 
 * Représentation de la grille et son évolution
 *
 */
public class Grid {
	int xMax;

	int yMax;

	int iteration;

	Cellule[][] cellules;

	public Grid(int xMax, int yMax, int iteration) {
		this.xMax = xMax;
		this.yMax = yMax;
		this.iteration = iteration;
		this.cellules = new Cellule[this.yMax][this.xMax];
		this.initGrid(yMax, xMax);
	}

	// constructeur par défaut
	public Grid() {
		this.xMax = 0;
		this.yMax = 0;
		this.iteration = 0;
	}

	/**
	 * Retourne le prochain état d'une cellule donnée
	 * 
	 * @param y la rangée de la cellule
	 * @param x la colonne de la cellule
	 * @return true/false si la cellule est vivante ou pas.
	 */
	private boolean nextState(int y, int x) {

		boolean nextState = false;
		int neighbors = countNeighbors(y, x);
		// Cas de cellule vivante
		if (cellules[y][x].getEtat()) {
			if (neighbors <= 1 || neighbors >= 4) {
				nextState = false;
			} else if (neighbors == 2 || neighbors == 3) {
				nextState = true;
			}
		}
		// cas de cellule morte
		else {
			if (neighbors == 3) {
				nextState = true;
			}
		}
		return nextState;
	}

	/**
	 * Compte le nombre de cellules vivantes autour d'une cellule donnée.
	 * 
	 * @param y la rangée de la cellule
	 * @param x la colonne de la cellule
	 * @return le nombre de cellules voisines vivantes
	 */
	private int countNeighbors(int y, int x) {
		int neighbors = 0;

		for (int i = y > 0 ? y - 1 : 0; i <= (y >= this.yMax ? this.yMax : y + 1); ++i) {
			for (int j = x > 0 ? x - 1 : 0; j <= (x >= this.xMax ? this.xMax : x + 1); ++j) {
				// Ne pas se vérifier soi-même.
				if (!(i == y && j == x)) {
					try {
						Cellule cel = this.cellules[i][j];
						neighbors += cel.etat ? 1 : 0;
					} catch (ArrayIndexOutOfBoundsException e) {
					}
				}
			}
		}

		return neighbors;
	}

	/***
	 * initiation de la grille avec des cellules mortes
	 * 
	 * @param yMax
	 * @param xMax
	 */
	private void initGrid(int yMax, int xMax) {
		for (int i = 0; i < yMax; i++) {
			for (int j = 0; j < xMax; j++) {
				this.cellules[i][j] = new Cellule(i, j, false);
			}
		}

	}

	/***
	 * calcul de l'évolution de la grille
	 */
	public void nextLive() {
		int count = 1;

		// init d'une grille temporaire
		Grid tempGrid = new Grid(xMax, yMax, this.iteration);

		while (count < this.iteration) {
			System.out.println("iteration  t + " + count);
			for (int i = 0; i < yMax; i++) {
				for (int j = 0; j < xMax; j++) {
					tempGrid.cellules[i][j].x = this.cellules[i][j].x;
					tempGrid.cellules[i][j].y = this.cellules[i][j].y;
					tempGrid.cellules[i][j].setEtat(this.nextState(i, j));
				}
			}

			tempGrid.toString();
			this.cellules = tempGrid.cellules;
			count++;

		}
	}

	/***
	 * dessin de la grille
	 */
	@Override
	public String toString() {
		for (int i = 0; i < this.yMax; ++i) {
			for (int j = 0; j < this.xMax; ++j) {
				if (this.cellules[i][j].etat) {
					System.out.print("#");
				} else {

					System.out.print(".");
				}

			}
			System.out.println();
		}

		return "Grid []";
	}

	public int getxMax() {
		return xMax;
	}

	public void setxMax(int xMax) {
		this.xMax = xMax;
	}

	public int getyMax() {
		return yMax;
	}

	public int getIteration() {
		return iteration;
	}

	public void setIteration(int iteration) {
		this.iteration = iteration;
	}

	public void setyMax(int yMax) {
		this.yMax = yMax;
	}

	public Cellule[][] getcellules() {
		return cellules;
	}

	public void setcellules(Cellule[][] cellules) {
		this.cellules = cellules;
	}

}
