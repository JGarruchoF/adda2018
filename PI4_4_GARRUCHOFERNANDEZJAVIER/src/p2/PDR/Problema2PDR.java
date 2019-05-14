package p2.PDR;

import java.util.ArrayList;
import java.util.List;

import us.lsi.pd.AlgoritmoPD.Sp;
import us.lsi.pd.AlgoritmoPD.Tipo;
import us.lsi.pd.ProblemaPDR;

public class Problema2PDR implements ProblemaPDR<SolucionProblema2, Boolean, Problema2PDR>{

	//PROPIEDADES
	private List<Integer> numeros;
	private Integer objetivo;
	private Integer suma;
	//Propiedades derivadas
	private Double cantidadNumPar;
	//indice
	int indice;
	
	
	public static Problema2PDR createInitial() {	
		return new Problema2PDR(new ArrayList<Integer>(), 0, DatosProblema2.objetivo, 0);
	}
	
	public static Problema2PDR create(Problema2PDR problema, Boolean alternativa) {
		return new Problema2PDR(problema, alternativa);
	}

	private Problema2PDR(List<Integer> numeros, Integer suma, Integer objetivo, int indice) {
		super();
		this.numeros = numeros;
		this.suma = suma;
		this.objetivo = objetivo;
		this.cantidadNumPar = cantidadNumPar(numeros);
		this.indice = indice;
	}


	private Problema2PDR(Problema2PDR problema, Boolean alternativa) {
		super();
		this.numeros = problema.numeros;
		this.suma = problema.suma;
		this.cantidadNumPar = problema.cantidadNumPar;
		this.indice = problema.indice + 1;
		if(alternativa) {
			this.numeros.add(this.indice);
		}

	}

	public Tipo getTipo() {
		return Tipo.Max;
	}

	public int size() {
		return DatosProblema2.lista.size() - indice - 1;
	}

	public boolean esCasoBase() {
		return indice == this.size()-1;// || this.suma == this.objetivo;
	}

	public Sp<Boolean> getSolucionParcialCasoBase() {
		return Sp.create(false, cantidadNumPar);
	}

	public Problema2PDR getSubProblema(Boolean alternativa) {
		return Problema2PDR.create(this, alternativa);
	}

	public Sp<Boolean> getSolucionParcialPorAlternativa(Boolean alternativa, Sp<Boolean> sol) {
		return Sp.create(alternativa,  
				alternativa ? sol.propiedad+1 : sol.propiedad );
	}

	public List<Boolean> getAlternativas() {
		List<Boolean> res = new ArrayList<>();
		res.add(false);
		if(24 - suma != 0.) res.add(true);
		return res;
	}

	public SolucionProblema2 getSolucionReconstruidaCasoBase(Sp<Boolean> sp) {
		return SolucionProblema2.create();
	}

	public SolucionProblema2 getSolucionReconstruidaCasoRecursivo(Sp<Boolean> sp, SolucionProblema2 sol) {
		if(sp.alternativa) sol.add(DatosProblema2.lista.get(indice));
		return sol;
	}

	//metodo auxiliar que calcula la cantidad de numeros pares en una lista
	private Double cantidadNumPar(List<Integer> numeros) {
		return numeros.stream().mapToDouble(i->i%2==0?1.:0.).sum();
	}
}