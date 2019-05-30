package ejercicio2.bt.test;


import ejercicio2.SolucionProblema2;
import ejercicio2.bt.Problema2BT;
import us.lsi.bt.AlgoritmoBT;

public class Problema2BTTest {

	public static void main(String[] args) {
			
		AlgoritmoBT.metricasOK = true;
		AlgoritmoBT.conFiltro = false;
		AlgoritmoBT.isRandomize = false;
	
		Problema2BT p = Problema2BT.createInitial();
		AlgoritmoBT<SolucionProblema2, Boolean, Problema2BT> a = AlgoritmoBT.create(p);
		a.ejecuta();
		System.out.println("Solucion: "+a.getSolucion());
		System.out.println(AlgoritmoBT.metricas);


	}

}
