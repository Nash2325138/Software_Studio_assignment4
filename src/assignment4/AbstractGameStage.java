package assignment4;


import javax.swing.JFrame;
import javax.swing.JLabel;

public abstract class AbstractGameStage extends JFrame{
	protected int currentScore, winScore;
	protected int windowHeight, typingWidth, displayWidth;
	protected TypingPanel typingPanel;
	protected DisplayPanel displayPanel;
	
	abstract public void start();
	abstract public void replay();
	public void addScore(int addition){
		this.currentScore += addition;
		this.displayPanel.updateScore(currentScore);
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
