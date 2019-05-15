package p2.BT.test;

import java.util.Arrays;

import p2.SolucionProblema2;
import p2.BT.Problema2BT;
import us.lsi.bt.AlgoritmoBT;

public class Problema2BTTest {

	public static void main(String[] args) {
		
		p2.DatosProblema2.objetivo = 4;
		p2.DatosProblema2.lista.addAll(Arrays.asList(3, 2, 1));
		AlgoritmoBT.metricasOK = true;
		Problema2BT p = Problema2BT.createInitial();
		AlgoritmoBT<SolucionProblema2, Boolean, Problema2BT> a = AlgoritmoBT.create(p);
		a.ejecuta();
		System.out.println("Solucion: "+a.getSolucion());
		System.out.println(AlgoritmoBT.metricas);


	}

}
