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
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class TypingPanel extends JPanel implements KeyListener, Runnable {
	private GameStage gs;
	private String[] knownFilePath, unknownFilePath;
	private JTextField textField;
	private HashMap<String, String> knownMap;
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
		
		this.knownFilePath = new String[100];
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
		int i = 0;
		System.out.println("Before iterate knownMap");
		for(HashMap.Entry<String, String> entry : knownMap.entrySet()){
			//System.out.println(entry.getKey() + " " + entry.getValue());
			knownFilePath[i++] = entry.getKey();
		}
		scanner.close();
		try {
			fileInput.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
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
}