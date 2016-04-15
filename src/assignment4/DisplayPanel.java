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
	private BufferedImage ballImage, duckImage, bgImage, winImage;
	private int duckX, ballX, bgX;
	GameStage gs;
	public DisplayPanel(Rectangle rec, GameStage gs) {
		// TODO Auto-generated constructor stub
		this.gs = gs;
		
		this.setLayout(null);
		this.setOpaque(true);
		this.setBackground(Color.BLUE);
		this.setBounds(rec);
		
		try{
			ballImage = ImageIO.read(new File("./materials/res/b.png"));
			duckImage = ImageIO.read(new File("./materials/res/duck.png"));
			bgImage = ImageIO.read(new File("./materials/res/bg.png"));
			winImage = ImageIO.read(new File("./materials/res/win.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
		duckX = this.gs.getDisplayWidth()/2-200;
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		System.out.println(gs.getDisplayWidth()/2);
		g.drawImage(this.bgImage, gs.getTypingWidth(), 0, null);
		g.drawImage(this.duckImage, gs.getTypingWidth() + duckX, 350, null);
	}
}
