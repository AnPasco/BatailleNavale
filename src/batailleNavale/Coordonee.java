package batailleNavale;

public class Coordonee {
	private int coordX;
	private int coordY;

	public Coordonee(int coordX, int coordY) {
		this.coordX = coordX;
		this.coordY = coordY;
	}

	public int getCoordX() {
		return coordX;
	}

	public int getCoordY() {
		return coordY;
	}

	public boolean coord2Valide(Coordonee coordAVerif) {

		return ((this.coordX + 1 == coordAVerif.getCoordX() && this.coordY == coordAVerif.getCoordY())
				|| (this.coordX - 1 == coordAVerif.getCoordX() && this.coordY == coordAVerif.getCoordY())
				|| (this.coordY + 1 == coordAVerif.getCoordY() && this.coordX == coordAVerif.getCoordX()
						|| (this.coordY - 1 == coordAVerif.getCoordY() && this.coordX == coordAVerif.getCoordX())));
	}

	public boolean coord3Valide(boolean horizontal, Coordonee coordAVerif) {
		if (horizontal) {
			return ((this.coordX - 1 == coordAVerif.getCoordX() || this.coordX + 1 == coordAVerif.getCoordX())
					&& (this.coordY == coordAVerif.getCoordY()));

		} else {
			return ((this.coordY - 1 == coordAVerif.getCoordY() || this.coordY + 1 == coordAVerif.getCoordY())
					&& (this.coordX == coordAVerif.getCoordX()));

		}

	}

}
