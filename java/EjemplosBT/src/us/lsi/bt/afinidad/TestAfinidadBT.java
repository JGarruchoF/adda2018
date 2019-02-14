package us.lsi.bt.afinidad;


import java.util.function.Predicate;

import us.lsi.afinidad.datos.DatosAfinidad;
import us.lsi.afinidad.datos.SolucionAfinidad;
import us.lsi.bt.AlgoritmoBT;


public class TestAfinidadBT {
	
	public static void main(String[] args) {
		
		//creaProblema y lanza algoritmo
		AlgoritmoBT.metricasOK = true;
		AlgoritmoBT.conFiltro = true;
		DatosAfinidad.create("ficheros/afinidad_test1.txt");
		EstadoAfinidadBT p=  EstadoAfinidadBT.create();
		var a= AlgoritmoBT.create(p);
		a.ejecuta();
		
		//recuperasoluci�n		
//		System.out.println(AlgoritmoBT.getMejorValor()+" ,"+a.solucion);
		Predicate<SolucionAfinidad> pp = x->x.getAfinidad().equals(a.getSolucion().getAfinidad());
		System.out.println(a.getSolucionesFiltradas(pp));
	}
}

