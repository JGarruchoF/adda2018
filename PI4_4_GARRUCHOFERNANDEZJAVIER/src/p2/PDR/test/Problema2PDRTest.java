package p2.PDR.test;

import java.util.Arrays;
import java.util.List;

import p2.SolucionProblema2;
import p2.PDR.Problema2PDR;
import us.lsi.bt.AlgoritmoBT;
import us.lsi.pd.AlgoritmoPD;
import us.lsi.pd.ProblemaPDRAdapt;

public class Problema2PDRTest {

	public static void main(String[] args) {
		p2.DatosProblema2.objetivo = 24;
		List<Integer> nums = Arrays.asList(1, 3, 1, 1, 2, 5, 8, 10, 6, 11);
		p2.DatosProblema2.lista.addAll(nums);
		
		
		AlgoritmoPD.isRandomize = false;
		AlgoritmoPD.metricasOK = true;
		
		Problema2PDR p = Problema2PDR.createInitial();
		AlgoritmoPD<SolucionProblema2, Integer, ProblemaPDRAdapt<SolucionProblema2, Integer, Problema2PDR>> a = AlgoritmoPD.createPDR(p);
		a.ejecuta();
		System.out.println(a.getSolucion());
		System.out.println(AlgoritmoBT.metricas);
	}

}
