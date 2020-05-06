import java.text.DecimalFormat;
import java.util.StringTokenizer;
public class Polynomial {
	public double[] coeff;
	public final int LEN_MAX = 10000;
	int deg = 0;
	Polynomial() {
		coeff = new double[LEN_MAX];
	}
	public void process(String in) throws NumberFormatException{
		int currCoeff = 0;
		StringTokenizer st = new StringTokenizer(in, ",");
		while(st.hasMoreElements()) {
			coeff[currCoeff++] = Integer.parseInt((String) st.nextElement());
		}
		this.deg = currCoeff;	
	}
	public void print() {
		for(int i = 0; i < this.deg; i ++)
			System.out.println(this.coeff[i]);
	}
	public String toString() {
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		String s = new String();
		if(this.isEmpty())
			s = "0";
		for(int i = 0; i < this.deg; i ++) {
			if(this.coeff[i] > 0 && i!=0)
				s += "+";
			if(coeff[i] != 0)
			s = s  + df.format(coeff[i]) + "*" + "x^" + (this.deg-i-1);
			
		}
		return s;
	}
	public Boolean isEmpty() {
		for(int i = 0; i < this.deg; i ++) {
			if(this.coeff[i] != 0)
				return false;
		}
		return true;
	}
}
