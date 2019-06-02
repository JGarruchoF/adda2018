package ejercicio3.pd.test;

import java.util.List;


import ejercicio3.pd.Problema3PD;
import ejercicio3.tipos.Punto;
import ejercicio3.tipos.Recta;
import us.lsi.pd.AlgoritmoPD;



public class Ejercicio3PDTest {
	public static void main(String[] arg) {
		AlgoritmoPD.isRandomize = false;
		AlgoritmoPD.conFiltro = false;
		AlgoritmoPD.metricasOK = true;
		
		List<Punto> puntos = List.of(Punto.create(3., 3.), Punto.create(4., 2.), Punto.create(3., 1.), Punto.create(2., 1.), Punto.create(1., 2.), Punto.create(2., 3.));
		Problema3PD p = Problema3PD.create(puntos);
		AlgoritmoPD<List<List<Punto>>, Recta, Problema3PD> a = AlgoritmoPD.createPD(p);
		a.ejecuta();
		muestraSolucion(a.getSolucion());
	}

	private static void muestraSolucion(List<List<Punto>> solucion) {
		System.out.println("Solucion:");
		for(List<Punto> lp : solucion) {
			System.out.println(lp);
		}
	}
	
}
