package ejercicio3.tipos;

public class Punto {
	
	private Double coordX;
	private Double coordY;
	
	public static Punto create(Double coordX, Double coordY) {
		return new Punto(coordX, coordY);
	}
	
	private Punto(Double coordX, Double coordY) {
		super();
		this.coordX = coordX;
		this.coordY = coordY;
	}

	public Double getX() {
		return coordX;
	}

	public Double getY() {
		return coordY;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coordX == null) ? 0 : coordX.hashCode());
		result = prime * result + ((coordY == null) ? 0 : coordY.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Punto other = (Punto) obj;
		if (coordX == null) {
			if (other.coordX != null)
				return false;
		} else if (!coordX.equals(other.coordX))
			return false;
		if (coordY == null) {
			if (other.coordY != null)
				return false;
		} else if (!coordY.equals(other.coordY))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Punto [coordX=" + coordX + ", coordY=" + coordY + "]";
	}
	
	

}
