package ButtonsAndListeners;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

class CalcFrame extends JFrame implements ActionListener {

	// Set up label, textfield, buttons and panel
	private JLabel result;
	private JTextField input;
	private JButton clear, add, sub, mul, div;
	private JPanel btnPanel;
	private double accumulator = 0;
	private Border line, margin, compound;

	public CalcFrame() {
		setLayout(new GridLayout(3, 1));

		// Create result label
		result = new JLabel("0.0", JLabel.RIGHT);
		result.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));

		// Create textfield
		input = new JTextField();
		input.setHorizontalAlignment(SwingConstants.RIGHT);
		input.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));

		// Set up border of buttons
		line = new LineBorder(Color.GRAY);
		margin = new EmptyBorder(5, 15, 5, 15);
		compound = new CompoundBorder(line, margin);

		// Create buttons
		clear = createButton("CLR");
		add = createButton("+");
		sub = createButton("-");
		mul = createButton("*");
		div = createButton("/");

		// Create button panel
		btnPanel = new JPanel(new GridLayout(1, 5));

		// Set up font
		Font f = new Font("monospace", Font.BOLD, 14);
		result.setFont(f);
		input.setFont(f);
		btnPanel.setFont(f);

		// Add elements to the frame
		btnPanel.add(clear);
		btnPanel.add(add);
		btnPanel.add(sub);
		btnPanel.add(mul);
		btnPanel.add(div);
		add(result);
		add(input);
		add(btnPanel);
	}

	public JButton createButton(String text) {
		JButton b = new JButton(text);
		b.setForeground(Color.BLACK);
		b.setBackground(Color.WHITE);
		b.setBorder(compound);
		b.addActionListener(this);
		return b;
	}

	public void doClear() {
		accumulator = 0;
		result.setText(String.valueOf(accumulator));
		input.setText("");
	}

	public void doAdd() {
		String text = input.getText();
		if (isNumeric(text)) {
			double value = Double.parseDouble(text);
			accumulator += value;
			result.setText(String.valueOf(accumulator));
			input.setText("");
		} else {
			input.setText("");
		}
	}

	public void doSub() {
		String text = input.getText();
		if (isNumeric(text)) {
			double value = Double.parseDouble(text);
			accumulator -= value;
			result.setText(String.valueOf(accumulator));
			input.setText("");
		} else {
			input.setText("");
		}
	}

	public void doMul() {
		if (accumulator == 0) {
			result.setText(String.valueOf(accumulator));
			input.setText("");
		} else {
			String text = input.getText();
			if (isNumeric(text)) {
				double value = Double.parseDouble(text);
				accumulator *= value;
				result.setText(String.valueOf(accumulator));
				input.setText("");
			} else {
				input.setText("");
			}
		}
	}

	public void doDiv() {
		if (accumulator == 0) {
			result.setText(String.valueOf(accumulator));
			input.setText("");
		} else {
			String text = input.getText();
			if (isNumeric(text)) {
				double value = Double.parseDouble(text);
				accumulator /= value;
				result.setText(String.valueOf(accumulator));
				input.setText("");
			} else {
				input.setText("");
			}
		}
	}

	private boolean isNumeric(String text) {
		try {
			Double.parseDouble(text);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == clear) {
			doClear();
		} else if (e.getSource() == add) {
			doAdd();
		} else if (e.getSource() == sub) {
			doSub();
		} else if (e.getSource() == mul) {
			doMul();
		} else if (e.getSource() == div) {
			doDiv();
		}
	}
}

public class TestCalculator {

	public static void main(String[] args) {
		CalcFrame c = new CalcFrame();
		c.setSize(350, 270);
		c.setTitle("Calculator");
		c.setVisible(true);
		c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
