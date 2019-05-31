package ejercicio3.pd;

import java.util.ArrayList;
import java.util.List;

import ejercicio3.tipos.Punto;
import ejercicio3.tipos.Recta;
//import ejercicio3.tipos.SolucionProblema3;
import us.lsi.pd.AlgoritmoPD.Sp;
import us.lsi.pd.AlgoritmoPD.Tipo;
import us.lsi.pd.ProblemaPD;

public class Problema3PD implements ProblemaPD<List<List<Punto>>, Recta, Problema3PD>{
	
	private List<Punto> puntos;

	
	public static Problema3PD create(List<Punto> puntos) {
		return new Problema3PD(puntos);
	}

	private Problema3PD(List<Punto> puntos) {
		super();
		this.puntos = puntos;
	}

	@Override
	public Tipo getTipo() {
		return Tipo.Min;
	}

	@Override
	public int size() {
		return puntos.size()-3;
	}

	@Override
	public boolean esCasoBase() {
		return puntos.size()<=3;
	}

	@Override
	public Sp<Recta> getSolucionParcialCasoBase() {
		return Sp.create(null, 0.);
	}

	@Override
	public Problema3PD getSubProblema(Recta a, int np) {
		List<Punto> puntos = new ArrayList<>();
		int i1 = this.puntos.indexOf(a.getP1());
		int i2 = this.puntos.indexOf(a.getP2());
		switch(np) {
		case 0:
			puntos.addAll(this.puntos.subList(i1, i2+1));
			break;
		case 1:
			puntos.addAll(this.puntos.subList(i2, this.puntos.size()));
			puntos.addAll(this.puntos.subList(0, i1+1)); 
			break;
		}
		return Problema3PD.create(puntos);
	}

	@Override
	public Sp<Recta> getSolucionParcialPorAlternativa(Recta a, List<Sp<Recta>> ls) {	
		
		Double propiedad = 0.;
		for(Sp<Recta> sp : ls) {
			if(sp.alternativa!=null)
			propiedad += sp.alternativa.getLongitud();
		}
		return Sp.create(a, propiedad+a.getLongitud());
	}

	
	@Override
	public List<Recta> getAlternativas() {
		//devuelve cada una de las aristas posibles entre los puntos de la lista
		List<Recta> alternativas = new ArrayList<>();
		for(int i = 0; i<this.puntos.size(); i++) {
			for(int j = i+2; j<this.puntos.size(); j++) {
				if(i!=0 || j!=puntos.size()-1) {
				Punto p1 = this.puntos.get(i);
				Punto p2 = this.puntos.get(j);
				
				alternativas.add(Recta.create(p1, p2));
				}
			}
		}
		return alternativas;
	}

	@Override
	public int getNumeroSubProblemas(Recta a) { 
		//Al dividir el poligono en dos siempre saldran 2 subproblemas
		return 2;
	}

	@Override
	public List<List<Punto>> getSolucionReconstruidaCasoBase(Sp<Recta> sp) {	
		//en el caso base la solucion son los 3 puntos que forman el triangulo
		List<List<Punto>> res = new ArrayList<>();
		res.add(this.puntos);
		return res;
	}

	@Override
	public List<List<Punto>> getSolucionReconstruidaCasoRecursivo(Sp<Recta> sp, List<List<List<Punto>>> ls) {
		
		List<List<Punto>> res = new ArrayList<>();
		for(List<List<Punto>> sol : ls) { 
		
			res.addAll(sol);
		}
		return res;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((puntos == null) ? 0 : puntos.hashCode());
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
		Problema3PD other = (Problema3PD) obj;
		if (puntos == null) {
			if (other.puntos != null)
				return false;
		} else if (!puntos.equals(other.puntos))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Problema3PD [puntos=" + puntos + "]";
	}
	
	

}
