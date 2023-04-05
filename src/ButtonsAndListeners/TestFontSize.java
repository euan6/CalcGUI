package ButtonsAndListeners;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;

class FontFrame extends JFrame implements ActionListener{

	// Set up labels, buttons, border and initial size
	private JLabel x, fontSize;
	private JButton increase, decrease;
	private int initial = 18;
	private Border line, margin, compound;

	public FontFrame() {
		setLayout(new GridLayout(2, 2));

		// Create labels
		x = new JLabel("X", JLabel.RIGHT);
		fontSize = new JLabel("18", JLabel.LEFT);

		// Set up font
		Font f = new Font("monospace", Font.BOLD, 18);
		x.setFont(f);
		fontSize.setFont(f);

		// Set up border of buttons
		line = new LineBorder(Color.BLACK);
		margin = new EmptyBorder(5, 15, 5, 15);
		compound = new CompoundBorder(line, margin);

		// Create increase button
		increase = createButton("Increase");
		JPanel incPanel = createPanel(increase);

		// Create decrease button
		decrease = createButton("Decrease");
		JPanel decPanel = createPanel(decrease);

		// Add labels and buttons to frame
		add(x);
		add(fontSize);
		add(incPanel);
		add(decPanel);
	}
	
	public JButton createButton(String text) {
		JButton b = new JButton(text);
		b.setForeground(Color.BLACK);
		b.setBackground(Color.WHITE);
		b.setBorder(compound);
		b.addActionListener(this);
		return b;
	}
	
	public JPanel createPanel(JButton btn) {
		JPanel p = new JPanel();
		p.add(btn);
		p.setPreferredSize(new Dimension(100, 50));
		return p;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == increase) {
			if (initial >= 1) {
				Font font = x.getFont();
				int size = font.getSize() + 1;
				initial++;
				fontSize.setText(String.valueOf(initial));
				x.setFont(font.deriveFont((float)size));
			}
		} else if (e.getSource() == decrease) {
			if (initial > 1) {
				Font font = x.getFont();
				int size = font.getSize() - 1;
				initial--;
				fontSize.setText(String.valueOf(initial));
				x.setFont(font.deriveFont((float)size));
			}
		}
	}
}

public class TestFontSize {

	public static void main(String[] args) {
		FontFrame f = new FontFrame();
		f.setSize(300, 170);
		f.setTitle("Font Size Changer");
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
