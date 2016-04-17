package assignment4;


import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;

enum GameState{
	BEGINNING, RUNNING, END
}

public abstract class AbstractGameStage extends JFrame{
	protected int currentScore, winScore;
	protected GameState state;
	protected int windowHeight, typingWidth, displayWidth;
	protected TypingPanel typingPanel;
	protected DisplayPanel displayPanel;
	protected BufferedImage winImage;
	
	abstract public void start();
	abstract public void replay();
	abstract public void end();
	public void addScore(int addition){
		this.currentScore += addition;
		this.displayPanel.updateScore(currentScore);
		if(currentScore >= winScore) this.end(); 
	}
	public int getScore(){
		return currentScore;
	}
	public void setWinScore(int winScore){
		this.winScore = winScore;
	}
	
	public int getTypingWidth(){
		return typingWidth;
	}
	public int getDisplayWidth(){
		return displayWidth;
	}
	public int getWindowHeight(){
		return windowHeight;
	}
	public boolean isWin(){
		return (currentScore >= winScore);
	}
}
