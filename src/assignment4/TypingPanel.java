package assignment4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TypingPanel extends JPanel implements KeyListener, Runnable {
	private GameStage gs;
	private String[] knownFilePath, unknownFilePath;
	private JTextField textField;
	private HashMap<String, String> knownMap;
	private int []knownOrder;
	private int []unknownOrder;
	private int knownIter=0, unknownIter=0;
	private boolean isKnownLeft;
	private int wordY;
	private BufferedImage knownImg, unknownImg;
	public TypingPanel(Rectangle rec, GameStage gs) {
		// TODO Auto-generated constructor stub
		this.gs = gs;
		
		this.setOpaque(true);
		this.setLayout(null);
		this.setBackground(Color.CYAN);
		this.setBounds(rec);
		

		this.textField = new JTextField();
		this.textField.setBounds(0, this.getBounds().height-30, this.getBounds().width, 30);
		this.textField.setVisible(true);
		this.textField.addKeyListener(this);
		this.add(textField);
		
		this.knownFilePath = new String[51];
		File file = new File("materials/known_words.txt");
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Scanner scanner = new Scanner(fileInput);
		
		knownMap = new HashMap<String, String>();
		while(scanner.hasNext()){
			String line = scanner.nextLine();
			//System.out.println(line);
			String[] store = line.split(" ");
			knownMap.put(store[0], store[1]);
		}
		int j = 0;
		System.out.println("Before iterate knownMap");
		for(HashMap.Entry<String, String> entry : knownMap.entrySet()){
			//System.out.println(entry.getKey() + " " + entry.getValue());
			knownFilePath[j++] = entry.getKey();
		}
		scanner.close();
		try {
			fileInput.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		file = new File("materials/unknown_words.txt");
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("yoyo");
		}
		scanner = new Scanner(fileInput);
		j=0;
		this.unknownFilePath = new String[73];
		while(scanner.hasNext()){
			unknownFilePath[j++] = scanner.next();
			//System.out.println(unknownFilePath[j-1]);
		}
		scanner.close();
		
		this.knownOrder = new int[51];
		this.unknownOrder = new int[73];
		System.out.println(knownOrder.length);
		System.out.println(unknownOrder.length);
		this.shuffleOrder(knownOrder, knownOrder.length);
		this.shuffleOrder(unknownOrder, unknownOrder.length);
		
		this.wordUpdate();
		
		Random random = new Random();
		isKnownLeft = random.nextBoolean();
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		if(isKnownLeft){
			g.drawImage(knownImg, 10, wordY, null);
			g.drawImage(unknownImg, 150, wordY, null);
		} else {
			g.drawImage(unknownImg, 10, wordY, null);
			g.drawImage(knownImg, gs.getTypingWidth()/2, wordY, null);
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try {
				Thread.sleep(45);
				if(wordY < this.gs.getHeight() - 70) wordY+=2;
				else wordUpdate();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			this.repaint();
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			textField.setText("");
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private void shuffleOrder(int[] order, int size)
	{
		Random random = new Random();
		for(int i=0 ; i<size ; i++) order[i] = i;
		for(int i=0 ; i<size ; i++) {
			int toSwap = random.nextInt(size);
			int temp = order[toSwap];
			order[toSwap] = order[i];
			order[i] = temp;
		}
	}
	private void wordUpdate()
	{
		try {
			String path = new String("materials/img/known/" + knownFilePath[knownOrder[knownIter++]]);
			knownImg = ImageIO.read(new File(path));
			path = new String("materials/img/unknown/" + unknownFilePath[unknownOrder[unknownIter++]]);
			unknownImg = ImageIO.read(new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wordY = 0;
	}
}