package assignment4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class TypingPanel extends JPanel {
	private JTextField textField;
	public TypingPanel(Rectangle rec) {
		// TODO Auto-generated constructor stub
		this.setOpaque(true);
		this.setLayout(null);
		this.setBackground(Color.CYAN);
		this.setBounds(rec);
		
		textField = new JTextField();
		textField.setBounds(0, this.getBounds().height-30, this.getBounds().width, 30);
		textField.setVisible(true);
		textField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TypingPanel.this.textField.setText("");
			}
		});
		this.add(textField);
		
	}
}