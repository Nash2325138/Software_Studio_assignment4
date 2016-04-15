package assignment4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class DisplayPanel extends JPanel {
	private BufferedImage ballImage, duckImage, hImage, winImage;
	public DisplayPanel(Rectangle rec) {
		// TODO Auto-generated constructor stub
		this.setLayout(null);
		this.setOpaque(true);
		this.setBackground(Color.darkGray);
		this.setBounds(rec);
		
		try{
			duckImage = ImageIO.read(new File("./materials/res/duck.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		this.repaint();
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(this.duckImage, 0, 0, null);
	}
}
