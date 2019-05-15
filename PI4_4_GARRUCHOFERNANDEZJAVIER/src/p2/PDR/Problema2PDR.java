package p2.PDR;

import java.util.ArrayList;
import java.util.List;

import p2.DatosProblema2;
import p2.SolucionProblema2;
import us.lsi.pd.AlgoritmoPD.Sp;
import us.lsi.pd.AlgoritmoPD.Tipo;
import us.lsi.pd.ProblemaPDR;

public class Problema2PDR implements ProblemaPDR<SolucionProblema2, Boolean, Problema2PDR>{

	//PROPIEDADES
	private Integer diferencia;
	private Integer suma;
	//Propiedades derivadas
	private Double cantidadNumPar;
	//indice
	int indice;
	
	
	public static Problema2PDR createInitial() {	
		return new Problema2PDR(0, 0, 0.);
	}
	
	public static Problema2PDR create(Problema2PDR problema, Boolean alternativa) {
		return new Problema2PDR(problema, alternativa);
	}

	private Problema2PDR(Integer suma, int indice, Double cantidadNumPar) {
		super();
		this.suma = suma;
		this.indice = indice;
		this.diferencia = DatosProblema2.objetivo - suma;
		this.cantidadNumPar = cantidadNumPar;
		System.out.println(this);
		System.out.println(esCasoBase());
		if(esCasoBase())System.out.println(getObjetivo());
		System.out.println();
	}


	private Problema2PDR(Problema2PDR problema, Boolean alternativa) {
		super();
		this.indice = problema.indice;
		Integer num = DatosProblema2.lista.get(indice);
		this.suma = alternativa?problema.suma + num : problema.suma;
		this.diferencia = DatosProblema2.objetivo - suma;
		this.cantidadNumPar = alternativa && num%2==0 ? problema.cantidadNumPar + 1 : problema.cantidadNumPar; 
		this.indice = problema.indice + 1;

		System.out.println(this);
		System.out.println(esCasoBase());
		if(esCasoBase())System.out.println(getObjetivo());
		System.out.println();

	}
	@Override
	public Tipo getTipo() {
		return Tipo.Min;
	}
	@Override
	public int size() {
		return p2.DatosProblema2.lista.size()  - indice;
	}
	@Override
	public boolean esCasoBase() {
		return indice == DatosProblema2.lista.size(); //|| diferencia == 0;
	}
	@Override
	public Sp<Boolean> getSolucionParcialCasoBase() {
		return Sp.create(null, 0.);
	}
	@Override
	public Problema2PDR getSubProblema(Boolean alternativa) {
		return Problema2PDR.create(this, alternativa);
	}
	@Override
	public Sp<Boolean> getSolucionParcialPorAlternativa(Boolean alternativa, Sp<Boolean> sol) {
		return Sp.create(alternativa,  
				alternativa && DatosProblema2.lista.get(indice)%2==0? sol.propiedad+1 : sol.propiedad);
	}
	@Override
	public List<Boolean> getAlternativas() { 
		List<Boolean> res = new ArrayList<>();
		Integer siguiente = p2.DatosProblema2.lista.get(indice);
		if(diferencia >= siguiente) res.add(Boolean.TRUE);
		res.add(Boolean.FALSE);
		System.out.println(res);
		return res;
	}
	@Override
	public SolucionProblema2 getSolucionReconstruidaCasoBase(Sp<Boolean> sp) {
		return SolucionProblema2.create();
	}
	@Override
	public SolucionProblema2 getSolucionReconstruidaCasoRecursivo(Sp<Boolean> sp, SolucionProblema2 sol) {
		if(sp.alternativa) sol.add(indice);
		return sol;
	}
	
	@Override
	public Double getObjetivo() {
		Double r = null;
		if(esCasoBase()) r = (double) cantidadNumPar - diferencia*1000;
		return r;
	}
	
	@Override
	public Double getObjetivoEstimado(Boolean alternativa) {	
		//TODO
		return null;
	}

	public Integer getDiferencia() {
		return diferencia;
	}

	public Integer getSuma() {
		return suma;
	}

	public int getIndice() {
		return indice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cantidadNumPar == null) ? 0 : cantidadNumPar.hashCode());
		result = prime * result + ((diferencia == null) ? 0 : diferencia.hashCode());
		result = prime * result + indice;
		result = prime * result + ((suma == null) ? 0 : suma.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Problema2PDR other = (Problema2PDR) obj;
		if (cantidadNumPar == null) {
			if (other.cantidadNumPar != null)
				return false;
		} else if (!cantidadNumPar.equals(other.cantidadNumPar))
			return false;
		if (diferencia == null) {
			if (other.diferencia != null)
				return false;
		} else if (!diferencia.equals(other.diferencia))
			return false;
		if (indice != other.indice)
			return false;
		if (suma == null) {
			if (other.suma != null)
				return false;
		} else if (!suma.equals(other.suma))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Problema2PDR [diferencia=" + diferencia + ", suma=" + suma + ", cantidadNumPar=" + cantidadNumPar
				+ ", indice=" + indice + "]";
	}

	
}