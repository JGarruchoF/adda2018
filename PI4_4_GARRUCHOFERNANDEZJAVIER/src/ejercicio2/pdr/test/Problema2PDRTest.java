package ejercicio2.pdr.test;

import ejercicio2.SolucionProblema2;
import ejercicio2.pdr.Problema2PDR;
import us.lsi.pd.AlgoritmoPD;
import us.lsi.pd.ProblemaPDRAdapt;

public class Problema2PDRTest {

	public static void main(String[] args) {
		
		AlgoritmoPD.isRandomize = false;
		AlgoritmoPD.conFiltro = false;
		AlgoritmoPD.metricasOK = true;
		
		Problema2PDR p = Problema2PDR.createInitial();
		AlgoritmoPD<SolucionProblema2, Boolean, ProblemaPDRAdapt<SolucionProblema2, Boolean, Problema2PDR>> a = AlgoritmoPD.createPDR(p);
		a.ejecuta();
		System.out.println(a.getSolucion());
		System.out.println(AlgoritmoPD.metricas);
	}

}
