package assignment4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

enum DuckDirection{
	UP, DOWN;
}

public class DisplayPanel extends JPanel implements Runnable {
	private BufferedImage ballImage, bgImage, winImage;
	private int ballX, bgShiftX;
	GameStage gs;
	YellowDuck duck;
	private class YellowDuck extends JPanel{
		private int X, Y;
		private final int anchorY;
		private BufferedImage image;
		private DuckDirection direction;
		private GameStage gs;
		public YellowDuck(GameStage gs) {
			// TODO Auto-generated constructor stub
			this.gs = gs;
			try{
				image = ImageIO.read(new File("./materials/res/duck.png"));
			} catch(IOException e) {
				e.printStackTrace();
			}
			X = gs.getDisplayWidth()/2-150;
			Y = anchorY = 350;
			//System.out.println("YellowDuck constructed");
			direction = DuckDirection.UP;
			this.setBounds(gs.getTypingWidth() + X, Y, image.getWidth(), image.getHeight());
			this.setVisible(true);
			this.setOpaque(false);
		}
		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			//System.out.println("inner paintComponent");
			this.setBounds(gs.getTypingWidth() + X, Y, image.getWidth(), image.getHeight());
			g.drawImage(image, 0, 0, null);
		}
	}
	
	public DisplayPanel(Rectangle rec, GameStage gs) {
		// TODO Auto-generated constructor stub
		this.gs = gs;
		
		this.setLayout(null);
		this.setOpaque(true);
		this.setBackground(Color.BLUE);
		this.setBounds(rec);
		
		try{
			ballImage = ImageIO.read(new File("./materials/res/b.png"));
			bgImage = ImageIO.read(new File("./materials/res/bg.png"));
			winImage = ImageIO.read(new File("./materials/res/win.png"));
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		this.duck = new YellowDuck(gs);
		this.duck.setVisible(true);
		this.add(this.duck);
		
		bgShiftX = 0;
		ballX = this.gs.getTypingWidth() + gs.getDisplayWidth() + 100;
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		//System.out.println("Outer paintComponent");
		g.drawImage(this.bgImage, gs.getTypingWidth() + bgShiftX, 0, null);
		g.drawImage(this.ballImage, ballX, duck.anchorY, null);
		duck.repaint();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try{
				Thread.sleep(80);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			if(duck.direction==DuckDirection.UP && duck.Y > duck.anchorY+10){
				duck.direction = DuckDirection.DOWN;
			} else if(duck.direction==DuckDirection.DOWN && duck.Y < duck.anchorY-10){
				duck.direction = DuckDirection.UP;
			}
			
			if(duck.direction==DuckDirection.UP) duck.Y++;
			else if(duck.direction==DuckDirection.DOWN) duck.Y--;
			duck.repaint();
		}
	}
}
