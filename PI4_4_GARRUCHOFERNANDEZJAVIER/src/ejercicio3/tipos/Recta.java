package ejercicio3.tipos;

public class Recta {
	

	private Punto p1;
	private Punto p2;
	private Double longitud;
	
	public static Recta create(Punto p1, Punto p2) {
		return new Recta(p1,p2);
	}
	
	private Recta(Punto p1, Punto p2) {
		super();
		this.p1 = p1;
		this.p2 = p2;
		this.longitud = Math.sqrt(Math.pow((p2.getX() - p1.getX()),2.) + Math.pow((p2.getY() - p1.getY()),2.));
	}

	public Punto getP1() {
		return p1;
	}

	public Punto getP2() {
		return p2;
	}
	
	public Double getLongitud() {
		return longitud;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((p1 == null) ? 0 : p1.hashCode());
		result = prime * result + ((p2 == null) ? 0 : p2.hashCode());
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
		Recta other = (Recta) obj;
		if (p1 == null) {
			if (other.p1 != null)
				return false;
		} else if (!p1.equals(other.p1))
			return false;
		if (p2 == null) {
			if (other.p2 != null)
				return false;
		} else if (!p2.equals(other.p2))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Recta [p1=" + p1 + ", p2=" + p2 + ", longitud=" + longitud + "]";
	}
	
	

}
