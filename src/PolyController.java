import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class PolyController {
	private PolyModel p_model;
	private PolyView p_view;
	private String HELP_MSG = "'Polynomial 1/Expression to be integrated or differentiated' field- Here enter the first polynomial to be\n"
			+ "added, subtracted, multiplied or divided, or the ploynomial that will be differentiated or integrated."
			+ "\n\n\n 'Polynomial 2/Integration or differentiation degree' field - Here enter the second polynomial to be added, subtracted,\n"
			+ "multiplied or divided, or the degree of integration/differentiation of the first polynomial, e.g. if we enter '1' here,\n"
			+ "press 'Differentiate', we will obtain the first derivative of the polynomial from the above field.\n"
			+ "\n\nINPUT FORMAT: enter the coefficients of the polynomial separated by a comma in DESCENDING order of their powers.\n"
			+ "\n\n'Result' field - displays the result of the selected operation. Also shows the remainder of the division\n"
			+ "\n\n'Clear' field - clears the result";
	PolyController(PolyModel model, PolyView view){
		p_model = model;
		p_view = view;
		view.addAdditionListener(new AddListener());
		view.addClearListener(new ClearListener());
		view.addSubListener(new SubListener());
		view.addMultListener(new MultListener());
		view.addDiffListener(new DiffListener());
		view.addIntListener(new IntListener());
		view.addDivListener(new DivListener());
		view.addHelpListener(new HelpListener());
	}
	
	class AddListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Polynomial p1 = new Polynomial();
			Polynomial p2 = new Polynomial();
			String userInput1 = p_view.getFirstPoly();
			String userInput2 = p_view.getSecondPoly();
			try {
			p1.process(userInput1);
			p2.process(userInput2);
			p_model.add(p1, p2);
			p_view.setResult(p_model.getValue());
			}catch(NumberFormatException nex) {
				JOptionPane.showMessageDialog(p_view,
					    "Please check your input",
					    "Input error",
					    JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	class ClearListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			p_model.reset();
			p_view.setResult(p_model.getValue());
		}
	}
	
	class SubListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Polynomial p1 = new Polynomial();
			Polynomial p2 = new Polynomial();
			String userInput1 = p_view.getFirstPoly();
			String userInput2 = p_view.getSecondPoly();
			try {
			p1.process(userInput1);
			p2.process(userInput2);
			p_model.sub(p1, p2);
			p_view.setResult(p_model.getValue());
			}catch(NumberFormatException nex) {
				JOptionPane.showMessageDialog(p_view,
					    "Please check your input",
					    "Input error",
					    JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	class MultListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Polynomial p1 = new Polynomial();
			Polynomial p2 = new Polynomial();
			String userInput1 = p_view.getFirstPoly();
			String userInput2 = p_view.getSecondPoly();
			try {
			p1.process(userInput1);
			p2.process(userInput2);
			p_model.mult(p1, p2);
			p_view.setResult(p_model.getValue());
			}catch(NumberFormatException nex) {
				JOptionPane.showMessageDialog(p_view,
					    "Please check your input",
					    "Input error",
					    JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	class DiffListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Polynomial p1 = new Polynomial();
			String userInput1 = p_view.getFirstPoly();
			String userInputDeg = p_view.getSecondPoly();
			try {
			p1.process(userInput1);
			p_model.diff(p1, Integer.parseInt(userInputDeg));
			p_view.setResult(p_model.getValue());
			}catch(NumberFormatException nex) {
				JOptionPane.showMessageDialog(p_view,
					    "Please check your input",
					    "Input error",
					    JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	class IntListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Polynomial p1 = new Polynomial();
			String userInput1 = p_view.getFirstPoly();
			String userInputDeg = p_view.getSecondPoly();
			try {
			p1.process(userInput1);
			p_model.integrate(p1, Integer.parseInt(userInputDeg));
			p_view.setResult(p_model.getValue());
			}catch(NumberFormatException nex) {
				JOptionPane.showMessageDialog(p_view,
					    "Please check your input",
					    "Input error",
					    JOptionPane.ERROR_MESSAGE);
			}

		}
	}
	
	class DivListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Polynomial p1 = new Polynomial();
			Polynomial p2 = new Polynomial();
			String userInput1 = p_view.getFirstPoly();
			String userInput2 = p_view.getSecondPoly();
			try {
			p1.process(userInput1);
			p2.process(userInput2);
			if(p2.isEmpty()) {
					JOptionPane.showMessageDialog(p_view,
						    "Division by 0",
						    "Input error",
						    JOptionPane.ERROR_MESSAGE);
				return;
			}
			p_model.div(p1, p2);
			p_view.setResult(p_model.getValue() + "  Remainder: " + p_model.getRemainder());
			}catch(NumberFormatException nex) {
				JOptionPane.showMessageDialog(p_view,
					    "Please check your input",
					    "Input error",
					    JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	class HelpListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(p_view,
				    HELP_MSG);
		}
	}
}
