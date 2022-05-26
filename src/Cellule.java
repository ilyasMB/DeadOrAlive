/***
 * Représentatin d'une cellule à partir des ses coordonnées et son état
 *
 */
public class Cellule {

	Integer x;
	Integer y;
	Boolean etat;

	public Cellule(Integer x, Integer y, Boolean etat) {
		this.x = x;
		this.y = y;
		this.etat = etat;
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public Boolean getEtat() {
		return etat;
	}

	public void setEtat(Boolean etat) {
		this.etat = etat;
	}

}
