import java.util.Scanner;

public class Test {
	public static void main (String[] args) {
		PolyModel m = new PolyModel();
		PolyView v = new PolyView(m);
		PolyController c = new PolyController(m,v);
	}
}
