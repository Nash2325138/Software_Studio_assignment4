package assignment4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class TypingPanel extends JPanel {
	private JTextField textField;
	private GameStage gs;
	public TypingPanel(Rectangle rec, GameStage gs) {
		// TODO Auto-generated constructor stub
		this.gs = gs;
		
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
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
	}
}