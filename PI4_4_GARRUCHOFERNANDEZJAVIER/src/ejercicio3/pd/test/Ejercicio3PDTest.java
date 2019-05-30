package ejercicio3.pd.test;

import java.util.ArrayList;
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
		System.out.println(a.getSolucion());
		System.out.println(AlgoritmoPD.metricas);
	}
	
	
////[(3.0,3.0), (4.0,2.0), (3.0,1.0) (2.0,1.0), (1.0,2.0), (2.0,3.0)
//	public static Problema3PD getSubProblema(Recta a, int np) {
//		List<Punto> puntos = List.of(Punto.create(3., 3.), Punto.create(4., 2.), Punto.create(3., 1.), Punto.create(2., 1.), Punto.create(1., 2.), Punto.create(2., 3.));
//		List<Punto> res = new ArrayList<>();
//		int i1 = 0;puntos.indexOf(a.getP1());
//		int i2 = 2;puntos.indexOf(a.getP2());
//		switch(np) {
//		case 0: 
//			res = puntos.subList(i1, i2); 
//			break;
//		case 1:
//			res = puntos.subList(i2, puntos.size()-1);
//			res.addAll(puntos.subList(0, i1)); 
//			break; 
//		}
//		return Problema3PD.create(res);
//	}
//	
//	public static List<Recta> getAlternativas() {
//		List<Punto> puntos = List.of(Punto.create(3., 3.), Punto.create(4., 2.), Punto.create(3., 1.), Punto.create(2., 1.), Punto.create(1., 2.), Punto.create(2., 3.));
//
//		List<Recta> alternativas = new ArrayList<>();
//		for(int i = 0; i<puntos.size(); i++) {
//			for(int j = i+2; j<puntos.size(); j++) {
//				if(i!=0 || j!=puntos.size()-1) {
//				Punto p1 = puntos.get(i);
//				Punto p2 = puntos.get(j);
//				alternativas.add(Recta.create(p1, p2));
//				}
//			}
//		}
//		return alternativas;
//	}
}
