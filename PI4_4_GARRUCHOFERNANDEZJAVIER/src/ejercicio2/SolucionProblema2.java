package ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class SolucionProblema2 {
	
	private List<Integer> numeros;
	private Double cantidadNumPar;
	
	private SolucionProblema2(List<Integer> numeros, Double cantidadNumPar) {
		super();
		this.numeros = numeros;
		this.cantidadNumPar = cantidadNumPar;
	}
	private SolucionProblema2() {
		super();
		this.numeros = new ArrayList<>();
		this.cantidadNumPar = 0.;
	}
	
	public static SolucionProblema2 create() {
		return new SolucionProblema2();
	}
	
	public static SolucionProblema2 create(List<Integer> numeros, Double cantidadNumPar) {
		return new SolucionProblema2(numeros, cantidadNumPar);
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
		result = prime * result + ((cantidadNumPar == null) ? 0 : cantidadNumPar.hashCode());
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
		if (cantidadNumPar == null) {
			if (other.cantidadNumPar != null)
				return false;
		} else if (!cantidadNumPar.equals(other.cantidadNumPar))
			return false;
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
	public void add(Integer indice) {
		Integer num = ejercicio2.DatosProblema2.lista.get(indice);
		numeros.add(num);
		if(num%2==0) cantidadNumPar++;
	}
	public void retrocede() {
		numeros.remove(numeros.size()-1);
	}
	
	public SolucionProblema2 copy() {
		return SolucionProblema2.create(this.numeros, this.cantidadNumPar);
	}
	

}
