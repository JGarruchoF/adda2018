package ejercicio2.gv.test;

import java.util.List;
import java.util.function.Predicate;

import ejercicio2.DatosProblema2;
import ejercicio2.SolucionProblema2;
import ejercicio2.gv.Problema2Arista;
import ejercicio2.gv.Problema2Vertice;
import us.lsi.astar.AStarAlgorithm;
import us.lsi.astar.AStarGraph;
import us.lsi.astar.AStarSimpleVirtualGraph;



public class Problema2GVTest {
	
	public static void main(String[] arg) {
	
	AStarGraph<Problema2Vertice,Problema2Arista> graph = AStarSimpleVirtualGraph.of(x->x.getEdgeWeight());
	Problema2Vertice startVertex = Problema2Vertice.of(0, 0., 0, DatosProblema2.objetivo);
	Predicate<Problema2Vertice> goal = (Problema2Vertice v)-> v.getIndice()>=DatosProblema2.lista.size(); 
	AStarAlgorithm<Problema2Vertice,Problema2Arista> a = AStarAlgorithm.of(graph, startVertex, goal, null);

	List<Problema2Arista> aristas = a.getPath().getEdgeList();
	
	SolucionProblema2 s = Problema2Vertice.getSolucion(aristas);
	System.out.println(s);
	}
}
