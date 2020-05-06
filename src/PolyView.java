import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PolyView extends JFrame{
	private JTextField p_firstPoly = new JTextField(30);
	private JTextField p_secondPoly = new JTextField(30);
	private JButton p_addBtn = new JButton("Add");
	private JButton p_subBtn = new JButton("Subtract");
	private JButton p_multBtn = new JButton("Multiply");
	private JButton p_divBtn = new JButton("Divide");
	private JButton p_diffBtn = new JButton("Differentiate");
	private JButton p_intBtn = new JButton("Integrate");
	private JTextField p_result = new JTextField(30);
	private JButton p_clear = new JButton("Clear");
	private JButton p_helpBtn = new JButton("Help");
	private PolyModel p_model;
	
	PolyView (PolyModel model){
		p_model = model;
		p_model.setValue(new Polynomial());
		JPanel content = new JPanel();
		content.setLayout(new FlowLayout());
		content.add(new JLabel("Polynomial 1 /Expression to be integrated or differentiated :  "));
		content.add(p_firstPoly);
		content.add(new JLabel("Polynomial 2 / Integration or Differentiation degree : "));
		content.add(p_secondPoly);
		content.add(p_addBtn);
		content.add(p_subBtn);
		content.add(p_multBtn);
		content.add(p_divBtn);
		content.add(p_diffBtn);
		content.add(p_intBtn);
		content.add(p_result);
		content.add(p_clear);
		content.add(p_helpBtn);
		this.setContentPane(content);
		this.setSize(700, 300);
		this.setTitle("Polynomial Processing");
		this.setVisible(true);
	}
	void addAdditionListener(ActionListener pAdd) {
		p_addBtn.addActionListener(pAdd);
	}
	void addClearListener(ActionListener pClr) {
		p_clear.addActionListener(pClr);
	}
	void addSubListener(ActionListener pSub) {
		p_subBtn.addActionListener(pSub);
	}
	void addMultListener(ActionListener pMult) {
		p_multBtn.addActionListener(pMult);
	}
	void addDiffListener(ActionListener pDiff) {
		p_diffBtn.addActionListener(pDiff);
	}
	void addIntListener(ActionListener pInt) {
		p_intBtn.addActionListener(pInt);
	}
	void addDivListener(ActionListener pDiv) {
		p_divBtn.addActionListener(pDiv);
	}
	void addHelpListener(ActionListener pHelp) {
		p_helpBtn.addActionListener(pHelp);
	}
	String getFirstPoly() {
		return p_firstPoly.getText();
	}
	String getSecondPoly() {
		return p_secondPoly.getText();
	}
	void setResult(String res) {
		p_result.setText(res);
	}
}
