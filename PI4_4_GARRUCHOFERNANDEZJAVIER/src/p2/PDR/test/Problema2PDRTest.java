package p2.PDR.test;

import java.util.Arrays;
import java.util.List;

import p2.PDR.DatosProblema2;
import p2.PDR.Problema2PDR;
import p2.PDR.SolucionProblema2;
import us.lsi.pd.AlgoritmoPD;
import us.lsi.pd.ProblemaPDRAdapt;

public class Problema2PDRTest {

	public static void main(String[] args) {
		DatosProblema2.objetivo = 24;
		List<Integer> nums = Arrays.asList(1, 3, 1, 1, 2, 5, 8, 10, 6, 11);
		DatosProblema2.lista.addAll(nums);
		
		Problema2PDR p = Problema2PDR.createInitial();
		AlgoritmoPD<SolucionProblema2, Boolean, ProblemaPDRAdapt<SolucionProblema2, Boolean, Problema2PDR>> a = AlgoritmoPD.createPDR(p);
		a.ejecuta();
		System.out.println(a.getSolucion());
	}

}
