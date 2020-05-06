import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class PolyModel {
	private Polynomial result = new Polynomial();
	private Polynomial remainder = new Polynomial();
	PolyModel(){
		reset();
	}
	public void add(Polynomial poly1, Polynomial poly2) {
		this.reset();
		int leadPoly, zeroDeg;
		if(poly1.deg > poly2.deg) {
			zeroDeg = poly1.deg - poly2.deg;
			poly2.deg = poly1.deg;
			leadPoly = 1;
		}
		else {
			zeroDeg = poly2.deg - poly1.deg;
			poly1.deg = poly2.deg;
			leadPoly = 2;
		}
		double[] aux = new double[poly1.deg];
		for(int i = 0; i < poly1.deg; i ++)
			aux[i] = 0;
		int j = 0;
		if(leadPoly == 1) {
			for(int i = zeroDeg; i < poly1.deg; i ++) 
				aux[i] = poly2.coeff[j++];
			poly2.coeff = aux;
		}
		else if(leadPoly == 2) {
			for(int i = zeroDeg; i < poly1.deg; i ++)
				aux[i] = poly1.coeff[j++];
			poly1.coeff = aux;
		}
		result.deg = poly1.deg;
		for(int i = 0; i < poly1.deg; i ++) {
			result.coeff[i] = poly1.coeff[i] + poly2.coeff[i];
		}	
	}
	public void sub(Polynomial poly1, Polynomial poly2) {
		this.reset();
		int leadPoly, zeroDeg;
		if(poly1.deg > poly2.deg) {
			zeroDeg = poly1.deg - poly2.deg;
			poly2.deg = poly1.deg;
			leadPoly = 1;
		}
		else {
			zeroDeg = poly2.deg - poly1.deg;
			poly1.deg = poly2.deg;
			leadPoly = 2;
		}
		double[] aux = new double[poly1.deg];
		for(int i = 0; i < poly1.deg; i ++)
			aux[i] = 0;
		int j = 0;
		if(leadPoly == 1) {
			for(int i = zeroDeg; i < poly1.deg; i ++) 
				aux[i] = poly2.coeff[j++];
			poly2.coeff = aux;
		}
		else if(leadPoly == 2) {
			for(int i = zeroDeg; i < poly1.deg; i ++) 
				aux[i] = poly1.coeff[j++];
			poly1.coeff = aux;
		}
		result.deg = poly1.deg;
		for(int i = 0; i < poly1.deg; i ++) {
			result.coeff[i] = poly1.coeff[i] - poly2.coeff[i];
		}
	}
	public void mult(Polynomial poly1, Polynomial poly2) {
		this.reset();
		result.deg = poly1.deg + poly2.deg - 1;
		for(int i = 0; i < poly1.deg; i ++)
			for(int j = 0; j < poly2.deg; j ++)
				result.coeff[i + j] += poly1.coeff[i] * poly2.coeff[j];
	}
	public void diff(Polynomial poly1, int deg) {
		for(int j = 0; j < deg; j ++) {
			Polynomial aux = new Polynomial();
		aux.deg = poly1.deg-1;
		for(int i = 0;i < poly1.deg; i++) {
			aux.coeff[i] = poly1.coeff[i];
			aux.coeff[i] *= (poly1.deg - i - 1);
		}
		result = aux;
		poly1 = aux;
		}
	}
	public void integrate(Polynomial poly1, int deg) {
		for(int j = 0; j < deg; j ++) {
			Polynomial aux = new Polynomial();
			aux.deg = poly1.deg + 1;
			aux.coeff = poly1.coeff;
			aux.coeff[poly1.deg] = 0;
			for(int i = 0; i < aux.deg - 1; i ++) {
				aux.coeff[i] /= (poly1.deg - i);
			}
			result = aux;
			poly1 = aux;
		}
	}
	public void div(Polynomial poly1, Polynomial poly2) {
		Polynomial q = new Polynomial();
		for(int i = 0; i < poly1.deg; i ++)
			q.coeff[i] = poly1.coeff[i];
		q.deg = poly1.deg;
		double normalizer = poly2.coeff[0];
		for(int i = 0; i < poly1.deg - poly2.deg + 1; i ++) {
			q.coeff[i] /= normalizer;
			double coef = q.coeff[i];
			if(coef != 0) {
				for(int j = 1; j < poly2.deg; j++) {
					q.coeff[i + j] += -poly2.coeff[j] * coef;
				}
			}
		}
		result = q;
		int remainderBound = poly1.deg - poly2.deg;
		result.deg -= remainderBound;
		remainder.deg = remainderBound;
		int j = 0;
		for(int i = result.deg; i < result.deg + remainderBound; i ++) {
			remainder.coeff[j] = result.coeff[i];
			j++;
		}
	}
	public void reset() {
		result = new Polynomial();
		result.process("0");
		remainder = new Polynomial();
		remainder.process("0");
	}
	public String getValue() {
		return result.toString();
	}
	public String getRemainder() {
		return remainder.toString();
	}
	public void setValue(Polynomial p) {
		result = p;
	}

}
