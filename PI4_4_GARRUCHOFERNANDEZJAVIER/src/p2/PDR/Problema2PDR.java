package p2.PDR;

import java.util.ArrayList;
import java.util.List;

import p2.SolucionProblema2;
import us.lsi.pd.AlgoritmoPD.Sp;
import us.lsi.pd.AlgoritmoPD.Tipo;
import us.lsi.pd.ProblemaPDR;

public class Problema2PDR implements ProblemaPDR<SolucionProblema2, Integer, Problema2PDR>{

	//PROPIEDADES
	private List<Integer> numeros;
	private static Integer objetivo = p2.DatosProblema2.objetivo;

	private Integer suma;
	//Propiedades derivadas
	private Double cantidadNumPar;
	//indice
	int indice;
	
	
	public static Problema2PDR createInitial() {	
		return new Problema2PDR(new ArrayList<Integer>(), 0, 0);
	}
	
	public static Problema2PDR create(Problema2PDR problema, Integer alternativa) {
		return new Problema2PDR(problema, alternativa);
	}

	private Problema2PDR(List<Integer> numeros, Integer suma, int indice) {
		super();
		this.numeros = numeros;
		this.suma = suma;
		this.indice = indice;
		this.cantidadNumPar = cantidadNumPar(numeros);
	}


	private Problema2PDR(Problema2PDR problema, Integer alternativa) {
		super();
		this.numeros = problema.numeros;
		this.suma = problema.suma;
		this.indice = problema.indice + 1;
		this.cantidadNumPar = problema.cantidadNumPar;
		if(alternativa > 0) {
			Integer num = p2.DatosProblema2.lista.get(indice);
			this.numeros.add(num);
			this.suma = this.suma+p2.DatosProblema2.lista.get(indice);
			if(num%2==0) {
				this.cantidadNumPar++;
			}
		}

	}

	public Tipo getTipo() {
		return Tipo.Max;
	}

	public int size() {
		return p2.DatosProblema2.lista.size() - indice - 1;
	}

	public boolean esCasoBase() {
		return indice == this.size()-1;// || this.suma == this.objetivo;
	}

	public Sp<Integer> getSolucionParcialCasoBase() {
		return Sp.create(0, cantidadNumPar);
	}

	public Problema2PDR getSubProblema(Integer alternativa) {
		return Problema2PDR.create(this, alternativa);
	}

	public Sp<Integer> getSolucionParcialPorAlternativa(Integer alternativa, Sp<Integer> sol) {
		return Sp.create(alternativa,  
				alternativa > 0 ? sol.propiedad+1 : sol.propiedad );
	}

	public List<Integer> getAlternativas() { //error probablemente aqui
		List<Integer> res = new ArrayList<>();
		res.add(0);
		Integer num = p2.DatosProblema2.lista.get(indice);

		if(objetivo - suma - num > 0.) res.add(1);
		//depurado
		System.out.println("suma:" +suma);
		System.out.println("obj:" +objetivo);
		System.out.println("alts: "+res);
		//depurado
		return res;
	}

	public SolucionProblema2 getSolucionReconstruidaCasoBase(Sp<Integer> sp) {
		return SolucionProblema2.create();
	}

	public SolucionProblema2 getSolucionReconstruidaCasoRecursivo(Sp<Integer> sp, SolucionProblema2 sol) {
		Integer num = p2.DatosProblema2.lista.get(indice);
		if(sp.alternativa > 0) sol.add(num);
		return sol;
	}

	//metodo auxiliar que calcula la cantidad de numeros pares en una lista
	private Double cantidadNumPar(List<Integer> numeros) {
		return numeros.stream().mapToDouble(i->i%2==0?1.:0.).sum();
	}
}