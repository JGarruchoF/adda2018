package us.lsi.iterativo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


import us.lsi.common.Accumulators;
import us.lsi.common.Lists2;
import us.lsi.common.Streams2;
import us.lsi.math.Math2;

import org.apache.commons.math3.fraction.BigFraction;
import org.apache.commons.math3.fraction.BigFractionField;
import org.apache.commons.math3.linear.FieldMatrix;


public class EjemplosIterativos {

	/**
	 * @param n Un entero
	 * @param k Un entero
	 * @return Valor del n�mero combinatorio n sobre k calculado de forma iterativa
	 */
	public static int binom(int n, int k) {
		List<Integer> lsa = Arrays.asList(1);
		int i = 1;
		while (i <= n) {
			List<Integer> ls = Lists2.newList();
			for (int s = 0; s <= i; s++) {
				if (s == 0 || s == i) {
					ls.add(1);
				} else if (s == 1 || s == i - 1) {
					ls.add(i);
				} else {
					ls.add(lsa.get(s - 1) + lsa.get(s));
				}
			}
			i = i + 1;
			lsa = Lists2.newList(ls);
		}
		return lsa.get(k);
	}
	
	/**
	 * @param b Base 
	 * @param n Exponente
	 * @return Resultado de elevar b a n calculado de forma iterativa
	 */
	public static long pot(int b,int n){
		int e = b;
		int a = 1;
		while( n > 0){
	        	if(n%2==1){
			     a = a * e;
			}
			e = e * e;
			n = n/2;
		}
		return a;
	}
	
	/**
	 * Adaptaci�n del algoritmo anterior pot(b,n) para el c�lculo de los n�mero de Fibonacci
	 * 
	 * @param n T�rmino
	 * @return Valor del n-esimo n�mero de Fibonacci calculado de forma iterativa
	 */
	public static long fib(int n){
			int i = 0;
		    int a = 1;
			int b = 0;
			while(i < n){
				i = i+1;
				int a0 = a;
				a = a0+b;
				b = a0;
			}
			return b;
	}

	
	/**
	 * Adaptaci�n del algoritmo anterior pot(b,n), siendo b, a, e de tipo Matriz. Alternativamente 
	 * se podria usar el m�todo e.power(n) para calcular la potencia de la basea asociada a la recurrencia
	 * 
	 * @param n T�rmino de la secuencia
	 * @param cf Coeficientes de la secuencia
	 * @param vi Valores iniciales de la secuencia
	 * @return Valor del t�rmino n-esimo calculado de forma iterativa
	 */
	public static BigInteger secuencia(Integer n, Integer[] cf, Integer[] vi){
		if(cf.length != vi.length) return null;
		int k = cf.length;
		FieldMatrix<BigFraction> e = Matrices.getBase(k,cf);			
		FieldMatrix<BigFraction> a = Matrices.getId(k,BigFractionField.getInstance());
		FieldMatrix<BigFraction> c = Matrices.getColumn(vi);
		while(n > 0){
	        if(n%2==1){
			     a = a.multiply(e);
			}
			e = e.multiply(e);
			n = n/2;
		}	
		FieldMatrix<BigFraction> r = a.multiply(c);
		return r.getEntry(1, 0).getNumerator();
}

	/**
	 * @param a Un entero
	 * @param b Un entero
	 * @return M�ximo Com�n Divisor de los dos enteros calculado de forma iterativa
	 */
	public static long mcd(int a,int b) {
		while(b > 0){
		   int a0 = a;
		   a = b;
		   b = a0%b;   
	    }
		return a;
	}
	public static <E> Boolean estaOrdenada(List<E> ls, Comparator<E> cmp) {
		return estaOrdenada(ls, 0, cmp);
	}
	public static <E> Boolean estaOrdenada(List<E> ls, int i, Comparator<E> cmp) {
		Boolean r;
		if(ls.size() -i < 2) {
			r = true;
		} else {
			r = cmp.compare(ls.get(i),ls.get(i+1))<=0 && estaOrdenada(ls,i+1,cmp);
		}
		return r;
	}
	public static <E> Boolean estaOrdenada2(List<E> ls,Comparator<E> cmp) {
		return IntStream.range(0,ls.size()-1)
				.allMatch(i->cmp.compare(ls.get(i),ls.get(i+1))<=0);
	}
	
	public static <E> List<E> inversa(List<E> ls) {
		return inversa(ls, 0);
	}
	public static <E> List<E> inversa(List<E> ls, int i) {
		List<E> r;
		if(ls.size() -i == 0) {
			r = new ArrayList<>();
		} else {			
			r = inversa(ls,i+1);
			r.add(ls.get(i));
		}
		return r;
	}
//	public static <E> List<E> inversa2(List<E> ls) {
//		Accumulator<List<E>,List<E>,List<E>>  a = null;
//		return Streams2.accumulateLeft(ls.stream(),a);
//	}
	public static <E> List<E> inversa3(List<E> ls) {
		Integer i = 0;
		List<E> b = new ArrayList<>();;
		while(i < ls.size()){	
			b.add(0,ls.get(i));
			i++;
		}
		return b;
	}
	public static Integer cercano(List<Integer>ls, Integer m){
		if(ls.isEmpty()) return null;
		return cercano(ls,m,0,ls.size());
	}
	public static Integer cercano(List<Integer>ls, Integer m,Integer i,Integer j){
		Integer r;
		if(j-i==1){
			r = ls.get(i);
		} else if(j-i==2) {
			if(m-ls.get(i) <= ls.get(i+1)-m){
				r = ls.get(i);
			} else {
			 	r = ls.get(i+1);
			}
		} else {
			Integer k = (i+j)/2;
			Integer em = ls.get(k);
			if(m==em){
				r = em;
			} if (m>em){
				r = cercano(ls,m,k,j);
			} else {
				r = cercano(ls,m,i,k);
			}
		}
		return r;	
	} 
	
	
	
	
	public static void main(String[] args) {
//		System.out.println(binom(10,5));
//		System.out.println(fib(10));
//		System.out.println(pot(8,5));
//		System.out.println(mcd(10546,3280));
		var s = List.of(1,2,3,41,55,64,71,88);
//		Comparator<Integer> cmp = Comparator.naturalOrder();
//		System.out.println(estaOrdenada(s,cmp));
//		System.out.println(estaOrdenada2(s,cmp));
//		System.out.println(inversa(s));
//		System.out.println(inversa3(s));
//		var r = cercano(s,60);
//		System.out.println(r);
//		var s = List.of(1,0,1,1,0,1,0,1);
		var xValue = 7;
//		var enteros = Stream.iterate(0,x->x+1);
		var ss = Streams2.elementsAndPosition(s.stream())
						 .map(t->t.v1.toString()+"*Math2.pow(x,"+t.v2.toString()+")")
						 .collect(Collectors.joining("+"));
		System.out.println(ss);
		var pot = Stream.iterate(1, x->x*xValue);
		var value1 = Streams2.zip(s.stream(), pot, (x,y)->x*y)
				.reduce(0,(x,y)->x+y);
		var ac = Accumulators.<Integer,Integer>createInmutable(0, (b,e)->b*xValue+e);		
		var value2 = 1*Math2.pow(xValue,0)+2*Math2.pow(xValue,1)+3*Math2.pow(xValue,2)+41*Math2.pow(xValue,3)+55*Math2.pow(xValue,4)+64*Math2.pow(xValue,5)+71*Math2.pow(xValue,6)+88*Math2.pow(xValue,7);	
		var value3 = Streams2.accumulateRight(s.stream(), ac);
		System.out.println(value1+","+value2+","+value3);
		var n = 8;
		var sec = Stream.iterate(n, x->x>0,x->x/2);
		var value4 = Streams2.accumulateRight(sec.map(x->x%2).map(x->x.toString()), Accumulators.joining(""));
		System.out.println(value4);
		Stream.iterate(n, x->x>0,x->x/2).map(x->x%2).forEach(x->System.out.print(x+" "));;
	}

}
