package ejercicio2.gv;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ejercicio2.DatosProblema2;
import ejercicio2.SolucionProblema2;
import us.lsi.graphs.ActionVirtualVertex;

public class Problema2Vertice extends ActionVirtualVertex<Problema2Vertice, Problema2Arista, Boolean>{

	int indice;
	
	Double cantidadNumPar;
	Integer suma;
	Integer diferencia;
	
	public static Problema2Vertice of(int indice, Double cantidadNumPar, Integer suma, Integer diferencia) {
		return new Problema2Vertice(indice, cantidadNumPar, suma, diferencia);
	}
	
	private Problema2Vertice(int indice, Double cantidadNumPar, Integer suma, Integer diferencia) {
		super();
		this.indice = indice;
		this.cantidadNumPar = cantidadNumPar;
		this.suma = suma;
		this.diferencia = diferencia;
		
		///
		System.out.println(this);
		///
		
	}

	@Override
	public boolean isValid() {
		return diferencia>=0 && indice>=0 && indice < DatosProblema2.lista.size();
	}

	@Override
	protected List<Boolean> actions() {
		List<Boolean> res = new ArrayList<>();
		if(diferencia >= DatosProblema2.lista.get(indice)) res.add(Boolean.TRUE);
		if(diferencia > 0) res.add(Boolean.FALSE);
		return res;
	}

	@Override
	protected Problema2Vertice getThis() {
		return this;
	}

	@Override
	protected Problema2Vertice neighbor(Boolean a) {
		Integer num = DatosProblema2.lista.get(indice);
		Double cantidadNumPar = a && num %2==0? this.cantidadNumPar+1: this.cantidadNumPar;
		Integer suma = a? this.suma+num : this.suma;
		Integer diferencia = DatosProblema2.objetivo - suma;
		return Problema2Vertice.of(indice+1, cantidadNumPar, suma, diferencia);
	}

	@Override
	protected Problema2Arista getEdge(Boolean a) {
		return Problema2Arista.of(this, neighbor(a), a);
	}

	public int getIndice() {
		return indice;
	}

	public Double getCantidadNumPar() {
		return cantidadNumPar;
	}

	public Integer getSuma() {
		return suma;
	}

	public Integer getDiferencia() {
		return diferencia;
	}

	public static SolucionProblema2 getSolucion(List<Problema2Arista> aristas) {
		List<Integer> numeros = aristas.stream().filter(a->a.alternativa).map(a->DatosProblema2.lista.get(a.getSource().getIndice())).collect(Collectors.toList());
		Double cantidadNumPar = numeros.stream().mapToDouble(n->n%2==0? 1:0).sum();
		return SolucionProblema2.create(numeros, cantidadNumPar);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cantidadNumPar == null) ? 0 : cantidadNumPar.hashCode());
		result = prime * result + ((diferencia == null) ? 0 : diferencia.hashCode());
		result = prime * result + indice;
		result = prime * result + ((suma == null) ? 0 : suma.hashCode());
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
		Problema2Vertice other = (Problema2Vertice) obj;
		if (cantidadNumPar == null) {
			if (other.cantidadNumPar != null)
				return false;
		} else if (!cantidadNumPar.equals(other.cantidadNumPar))
			return false;
		if (diferencia == null) {
			if (other.diferencia != null)
				return false;
		} else if (!diferencia.equals(other.diferencia))
			return false;
		if (indice != other.indice)
			return false;
		if (suma == null) {
			if (other.suma != null)
				return false;
		} else if (!suma.equals(other.suma))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Problema2Vertice [indice=" + indice + ", cantidadNumPar=" + cantidadNumPar + ", suma=" + suma
				+ ", diferencia=" + diferencia + "]";
	}

	

}
