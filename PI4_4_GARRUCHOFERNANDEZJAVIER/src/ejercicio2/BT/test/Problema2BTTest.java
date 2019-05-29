package ejercicio2.BT.test;

import java.util.Arrays;
import java.util.List;

import ejercicio2.SolucionProblema2;
import ejercicio2.BT.Problema2BT;
import us.lsi.bt.AlgoritmoBT;

public class Problema2BTTest {

	public static void main(String[] args) {
		
		ejercicio2.DatosProblema2.objetivo = 10;
		List<Integer> nums = Arrays.asList(1,2,3, 2, 8);
		ejercicio2.DatosProblema2.lista = nums;
		
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
