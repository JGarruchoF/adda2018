package ejercicio2.gv;

import ejercicio2.DatosProblema2;
import us.lsi.graphs.SimpleEdge;

public class Problema2Arista extends SimpleEdge<Problema2Vertice>{
	Boolean alternativa;

	public static Problema2Arista of(Problema2Vertice v1, Problema2Vertice v2, Boolean a) {
		Double peso = a && DatosProblema2.lista.get(v1.getIndice())%2==0? -1. : 10.;
		return new Problema2Arista(v1, v2, peso, a);
	}

	private Problema2Arista(Problema2Vertice c1, Problema2Vertice c2, double weight, Boolean a) {
		super(c1, c2, weight);
		this.alternativa = a;
	}

	private Problema2Arista(Problema2Vertice c1, Problema2Vertice c2) {
		super(c1, c2);
	}
	
	
	
}
