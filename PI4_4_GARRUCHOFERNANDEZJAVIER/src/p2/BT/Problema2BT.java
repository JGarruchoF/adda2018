package p2.BT;

import java.util.ArrayList;
import java.util.List;

import p2.SolucionProblema2;
import us.lsi.bt.EstadoBT;

public class Problema2BT implements EstadoBT<SolucionProblema2, Boolean, Problema2BT>{
	
	private int indice;
	private SolucionProblema2 solP;
	private Double cantidadNumPar;
	private Integer suma;
	private Integer diferencia;
	
	private Problema2BT(int indice, SolucionProblema2 solP, Double cantidadNumPar, Integer suma, Integer diferencia) {
		super();
		this.indice = indice;
		this.solP = solP;
		this.cantidadNumPar = cantidadNumPar;
		this.suma = suma;
		this.diferencia = diferencia;
	}
	
	public static Problema2BT createInitial() {
		return new Problema2BT(0, SolucionProblema2.create(), 0., 0, p2.DatosProblema2.objetivo);
	}

	@Override
	public Tipo getTipo() {
		return Tipo.Max;
	}

	@Override
	public Problema2BT getEstadoInicial() {
		return Problema2BT.createInitial();
	}

	@Override
	public Problema2BT avanza(Boolean a) {
		Integer num = p2.DatosProblema2.lista.get(indice);
		if(a)this.solP.add(indice);
		this.cantidadNumPar = num%2 == 0 && a ? ++cantidadNumPar : cantidadNumPar;
		this.suma = a? this.suma+num : this.suma;
		this.diferencia = a? this.diferencia - num : this.diferencia;
		this.indice = this.indice + 1;
		
		System.out.println(this);

		return this;
	}

	@Override
	public Problema2BT retrocede(Boolean a) {
		this.indice = this.indice - 1;
		Integer num = p2.DatosProblema2.lista.get(indice);
		this.diferencia = a? this.diferencia + num : this.diferencia;
		this.suma = a?this.suma - num : this.suma;
		this.cantidadNumPar  = num%2==0 && a? --cantidadNumPar : cantidadNumPar;
		if(a)this.solP.retrocede();
		return this;
	}

	@Override
	public int size() {
		return p2.DatosProblema2.lista.size() - indice;
	}

	@Override
	public boolean esCasoBase() {
		boolean res = size() == 0;
		//System.out.println("Es caso base: " + res+" ");
		return res;
	}

	@Override
	public List<Boolean> getAlternativas() {
		List<Boolean> alternativas = new ArrayList<>();
		
		if(esCasoBase()) return alternativas;

		if(diferencia >= p2.DatosProblema2.lista.get(indice)) alternativas.add(Boolean.TRUE);
		alternativas.add(Boolean.FALSE);
		System.out.println(alternativas);
		return alternativas;
	}
	
	@Override
	public Double getObjetivo() {
		Double res = (double) this.cantidadNumPar + 1 - diferencia*1000; //sin + 1 no da solucion
		System.out.println("obj: "+res);
		return res;
	}	
	
	@Override
	public Double getObjetivoEstimado(Boolean alternativa) {	
		//TODO
		return null;
	}
	
	@Override
	public SolucionProblema2 getSolucion() {
		return this.solP.copy();
	}

	public int getIndice() {
		return indice;
	}

	public SolucionProblema2 getSolP() {
		return solP;
	}

	public Double getCantidadNumPar() {
		return cantidadNumPar;
	}

	public Integer getSuma() {
		return suma;
	}

	public Integer getDiferencia() {
		return diferencia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cantidadNumPar == null) ? 0 : cantidadNumPar.hashCode());
		result = prime * result + ((diferencia == null) ? 0 : diferencia.hashCode());
		result = prime * result + indice;
		result = prime * result + ((solP == null) ? 0 : solP.hashCode());
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
		Problema2BT other = (Problema2BT) obj;
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
		if (solP == null) {
			if (other.solP != null)
				return false;
		} else if (!solP.equals(other.solP))
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
		return "Problema2BT [indice=" + indice + ", solP=" + solP + ", cantidadNumPar=" + cantidadNumPar + ", suma="
				+ suma + ", diferencia=" + diferencia + "]";
	}

	
	
	

}
