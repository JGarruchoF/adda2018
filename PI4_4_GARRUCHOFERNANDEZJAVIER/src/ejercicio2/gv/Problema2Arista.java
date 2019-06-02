package ejercicio2.gv;

import ejercicio2.DatosProblema2;
import us.lsi.graphs.SimpleEdge;

public class Problema2Arista extends SimpleEdge<Problema2Vertice>{
	
	Boolean alternativa;

	public static Problema2Arista of(Problema2Vertice v1, Problema2Vertice v2, Boolean a) {
		Double peso = 0.;
		if(a && DatosProblema2.lista.get(v1.getIndice())%2==0) {
			peso = -1.;
		}
		if(v1.getIndice()==DatosProblema2.lista.size()-1 && v2.getDiferencia()>0) {
			peso = Double.MAX_VALUE;
		}
		return new Problema2Arista(v1, v2, peso, a);
	}

	private Problema2Arista(Problema2Vertice c1, Problema2Vertice c2, double weight, Boolean a) {
		super(c1, c2, weight);
		this.alternativa = a;
	}

	private Problema2Arista(Problema2Vertice c1, Problema2Vertice c2) {
		super(c1, c2);
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((alternativa == null) ? 0 : alternativa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Problema2Arista other = (Problema2Arista) obj;
		if (alternativa == null) {
			if (other.alternativa != null)
				return false;
		} else if (!alternativa.equals(other.alternativa))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Problema2Arista [alternativa=" + alternativa + ", weight=" + weight + ", source=" + source + ", target="
				+ target + "]\n";
	}


	
	
	
}
