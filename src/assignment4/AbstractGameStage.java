package assignment4;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class AbstractGameStage extends JFrame{
	private int currentScore, winScore;
	
	abstract public void start();
	abstract public void replay();
	public void addScore(int addition){
		this.currentScore += addition;
	}
	public int getScore(){
		return currentScore;
	}
	public void setWinScore(int winScore){
		this.winScore = winScore;
	}
}
