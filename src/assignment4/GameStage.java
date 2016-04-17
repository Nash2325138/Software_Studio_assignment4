package assignment4;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.lang.Thread.State;

import javax.imageio.ImageIO;

public class GameStage extends AbstractGameStage {
	public GameStage() {
		// TODO Auto-generated constructor stub
		windowHeight = 500;
		typingWidth = 400;
		displayWidth = 800;
		winScore = 100;
		state = GameState.BEGINNING;
		
		displayPanel = new DisplayPanel(new Rectangle(typingWidth, 0, displayWidth, windowHeight), this);
		displayPanel.setVisible(true);
		
		typingPanel = new TypingPanel(new Rectangle(0, 0, typingWidth, windowHeight), this);
		typingPanel.setVisible(true);
		
		this.add(typingPanel);
		this.add(displayPanel);
		this.setSize(new Dimension(typingWidth+displayWidth, windowHeight));

		try {
			winImage = ImageIO.read(new File("./materials/res/win.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void start() {
		// TODO Auto-generated method stub		
		
		
		new Thread(typingPanel).start();
		new Thread(displayPanel).start();
		this.setVisible(true);
	}

	@Override
	public void replay() {
		// TODO Auto-generated method stub

	}
	@Override
	public void end() {
		// TODO Auto-generated method stub
		
	}
	
}
