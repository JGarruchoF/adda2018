package ejercicio2.bt;

import java.util.ArrayList;
import java.util.List;

import ejercicio2.DatosProblema2;
import ejercicio2.SolucionProblema2;
import us.lsi.bt.EstadoBT;

public class Problema2BT implements EstadoBT<SolucionProblema2, Boolean, Problema2BT>{
	
	
	private int indice;
	private SolucionProblema2 solP;
	private Double cantidadNumPar;
	private Integer suma;
	private Integer diferencia;
	
	List<Boolean> camino; //Almacena la lista de alternativas que se ha ido tomando
	
	private Problema2BT(int indice, SolucionProblema2 solP, Double cantidadNumPar, Integer suma, Integer diferencia) {
		super();
		this.indice = indice;
		this.solP = solP;
		this.cantidadNumPar = cantidadNumPar;
		this.suma = suma;
		this.diferencia = diferencia;
		this.camino = new ArrayList<>();
	}
	
	public static Problema2BT createInitial() {
		return new Problema2BT(0, SolucionProblema2.create(), 0., 0, ejercicio2.DatosProblema2.objetivo);
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
		
		camino.add(a);
		
		Integer num = ejercicio2.DatosProblema2.lista.get(indice);
		
		if(a) this.solP.add(num);
		this.cantidadNumPar = a && num%2 == 0  ? ++cantidadNumPar : cantidadNumPar;
		this.suma = a ? this.suma+num : this.suma;
		this.diferencia =  DatosProblema2.objetivo - suma;
		this.indice = this.indice + 1;
		return this;
	}

	@Override
	public Problema2BT retrocede(Boolean a) {
		camino.remove(camino.size()-1);
		this.indice = this.indice - 1;
		Integer num = ejercicio2.DatosProblema2.lista.get(indice);	
		this.suma = a?this.suma - num : this.suma;
		this.diferencia =  DatosProblema2.objetivo - suma;
		this.cantidadNumPar  = num%2==0 && a? --cantidadNumPar : cantidadNumPar;
		if(a)this.solP.retrocede(); //borra el ultimo elemento de la lista de numeros de la solucion
		
		return this;
	}

	@Override
	public int size() {
		return ejercicio2.DatosProblema2.lista.size() - indice;
	}

	@Override
	public boolean esCasoBase() {
		return size() == 0 || diferencia==0;
	}

	@Override
	public List<Boolean> getAlternativas() {
		List<Boolean> alternativas = new ArrayList<>();
		if(diferencia >= ejercicio2.DatosProblema2.lista.get(indice)) alternativas.add(Boolean.TRUE);	
		if(!esCasoBase()) alternativas.add(Boolean.FALSE);
		return alternativas;
	}
	
	@Override
	public Double getObjetivo() {
		return this.cantidadNumPar;
	}	
	
	@Override
	public Double getObjetivoEstimado(Boolean alternativa) {
		Double paresEstimado = cantidadNumPar;
		for(int i = indice; i < DatosProblema2.lista.size(); i++) {
			if(DatosProblema2.lista.get(i)%2==0) paresEstimado++;
		}
		return paresEstimado;
	}
	
	@Override
	public boolean estaFueraDeRango() {
		return diferencia < 0;
	}
	
	@Override
	public SolucionProblema2 getSolucion() {
		SolucionProblema2 res = null;
		List<Integer> numeros = new ArrayList<>();
		Integer suma = 0;
		for(int i = 0; i<camino.size(); i++) {
			if(camino.get(i)) {
				Integer num = DatosProblema2.lista.get(i);
				suma += num;
				numeros.add(num);
			}
		}
		if(suma == DatosProblema2.objetivo) res = SolucionProblema2.create(numeros);
		return res;
	}

	public int getIndice() {
		return indice;
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
