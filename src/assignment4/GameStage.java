package assignment4;

import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JLabel;


public class GameStage extends AbstractGameStage implements Runnable{
	
	public GameStage() {
		// TODO Auto-generated constructor stub
		windowHeight = 500;
		typingWidth = 400;
		displayWidth = 800;
		
		this.setSize(new Dimension(typingWidth+displayWidth, windowHeight));
		displayPanel = new DisplayPanel(new Rectangle(typingWidth, 0, displayWidth, windowHeight), this);
		displayPanel.setVisible(true);
		
		typingPanel = new TypingPanel(new Rectangle(0, 0, typingWidth, windowHeight), this);
		typingPanel.setVisible(true);
		new Thread(typingPanel).start();
				
		this.add(typingPanel);
		this.add(displayPanel);
		new Thread(displayPanel).start();
		this.setVisible(true);
	}
	@Override
	public void start() {
		// TODO Auto-generated method stub

	}

	@Override
	public void replay() {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
