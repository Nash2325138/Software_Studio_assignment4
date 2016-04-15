package assignment4;

import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JPanel;

public class GameStage extends AbstractGameStage implements Runnable{

	private TypingPanel typingPanel;
	private DisplayPanel displayPanel;
	
	public GameStage() {
		// TODO Auto-generated constructor stub
		this.setSize(new Dimension(900, 600));
		displayPanel = new DisplayPanel(new Rectangle(400, 0, 500, 600));
		displayPanel.setVisible(true);
		
		typingPanel = new TypingPanel(new Rectangle(0, 0, 400, 600));
		typingPanel.setVisible(true);
		
		this.add(typingPanel);
		this.add(displayPanel);
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
