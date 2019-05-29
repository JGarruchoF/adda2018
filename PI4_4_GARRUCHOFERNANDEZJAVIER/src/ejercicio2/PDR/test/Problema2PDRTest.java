package ejercicio2.PDR.test;

import java.util.Arrays;
import java.util.List;

import ejercicio2.SolucionProblema2;
import ejercicio2.PDR.Problema2PDR;
import us.lsi.bt.AlgoritmoBT;
import us.lsi.pd.AlgoritmoPD;
import us.lsi.pd.ProblemaPDRAdapt;

public class Problema2PDRTest {

	public static void main(String[] args) {
		ejercicio2.DatosProblema2.objetivo = 10;
		List<Integer> nums = Arrays.asList(1,2,3,2, 8); //sol: [2,8]
		ejercicio2.DatosProblema2.lista = nums;
		
		
		AlgoritmoPD.isRandomize = false;
		AlgoritmoPD.conFiltro = false;
		AlgoritmoPD.metricasOK = true;
		
		Problema2PDR p = Problema2PDR.createInitial();
		AlgoritmoPD<SolucionProblema2, Boolean, ProblemaPDRAdapt<SolucionProblema2, Boolean, Problema2PDR>> a = AlgoritmoPD.createPDR(p);
		a.ejecuta();
		System.out.println(a.getSolucion());
		System.out.println(a.metricas);
	}

}
