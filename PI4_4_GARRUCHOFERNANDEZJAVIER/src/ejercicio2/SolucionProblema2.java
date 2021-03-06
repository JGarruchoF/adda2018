package ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class SolucionProblema2 {
	
	private List<Integer> numeros;
	
	private SolucionProblema2(List<Integer> numeros) {
		super();
		this.numeros = numeros;
	}
	private SolucionProblema2() {
		super();
		this.numeros = new ArrayList<>();
	}
	
	public static SolucionProblema2 create() {
		return new SolucionProblema2();
	}
	
	public static SolucionProblema2 create(List<Integer> numeros) {
		return new SolucionProblema2(numeros);
	}

	public List<Integer> getNumeros() {
		return new ArrayList<>(numeros);
	}

	public Double getCantidadNumPar() {
		return this.getNumeros().stream().mapToDouble(i->i%2==0?1.:0.).sum();
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeros == null) ? 0 : numeros.hashCode());
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
		SolucionProblema2 other = (SolucionProblema2) obj;
		if (numeros == null) {
			if (other.numeros != null)
				return false;
		} else if (!numeros.equals(other.numeros))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Objetivo: " + ejercicio2.DatosProblema2.objetivo+", solucion: "+ numeros + ", cantidad de numeros pares: " + getCantidadNumPar();
	}
	public void add(Integer num) {;
		numeros.add(num);
	}
	public void retrocede() {
		numeros.remove(numeros.size()-1);
	}

	

}
