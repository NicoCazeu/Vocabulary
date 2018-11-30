package com.softcaze.vocabulary;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MainFrame {
	private static int score = 0;
	private static int scoreTotal = 0;
	private static int countLine = 0;
	private static int randomValue = 0;
	private static String frenchWord = "";
	private static String englishWord = "";
	
	public static void main(String[] args) {
		JFrame jFrame = new JFrame();
		JButton btnNext = new JButton("Next");
		JTextField txEnglishValue = new JTextField();
		JTextField txFrenchValue = new JTextField();
		JLabel lblScoreTotal = new JLabel();
		JLabel lblScore = new JLabel();
		
		Random randValue = new Random();
		countLine = getCountLine();
		randomValue = randValue.nextInt(countLine);
						
		englishWord = getEnglishWord(getRandomLine(randomValue));
		frenchWord = getFrenchWord(getRandomLine(randomValue));
		
		lblScore.setText(String.valueOf(score));
		lblScoreTotal.setText("/ 0");
		
		lblScore.setBounds(90, 200, 50, 10);
		lblScoreTotal.setBounds(110, 200, 50, 10);
		
		txEnglishValue.setText(englishWord);
		txEnglishValue.setHorizontalAlignment(JTextField.CENTER);
		txEnglishValue.setEditable(false);
		txFrenchValue.setHorizontalAlignment(JTextField.CENTER);
		txFrenchValue.setForeground(Color.BLACK);	
		
		jFrame.setVisible(true);
		jFrame.setSize(500, 300);
		jFrame.setTitle("Vocabulary");
		jFrame.setResizable(false);
		jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
		jFrame.setLocationRelativeTo(null);
		
		btnNext.setBounds((int)jFrame.getBounds().getX()/2 - 125, 175, 200, 50);
		txEnglishValue.setBounds((int)jFrame.getBounds().getX()/2 - 125, 50, 200, 50);
		txFrenchValue.setBounds((int)jFrame.getBounds().getX()/2 - 125, 110, 200, 50);
		
		btnNext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(txFrenchValue.getForeground() == Color.RED) {
					txFrenchValue.setForeground(Color.BLACK);
					
					randomValue = randValue.nextInt(countLine);
					
					englishWord = getEnglishWord(getRandomLine(randomValue));
					frenchWord = getFrenchWord(getRandomLine(randomValue));
					
					txEnglishValue.setText(englishWord);
					txFrenchValue.setText("");
				}
				else {
					if(txFrenchValue != null && txFrenchValue.getText().equals(frenchWord)) {					
						score += 1;
						lblScore.setText(String.valueOf(score));
						
						randomValue = randValue.nextInt(countLine);
						englishWord = getEnglishWord(getRandomLine(randomValue));
						frenchWord = getFrenchWord(getRandomLine(randomValue));
						
						txEnglishValue.setText(englishWord);
						txFrenchValue.setText("");
					}
					else {
						txFrenchValue.setText(frenchWord);
						txFrenchValue.setForeground(Color.RED);	
					}
					
					scoreTotal += 1;
					lblScoreTotal.setText("/ " + String.valueOf(scoreTotal));
				}
			}
		});
		
		jFrame.setLayout(null);
		jFrame.add(btnNext);
		jFrame.add(txFrenchValue);
		jFrame.add(txEnglishValue);
		jFrame.add(lblScore);
		jFrame.add(lblScoreTotal);
	}
	
	public static String getRandomLine(int random) {
		File file = new File("C:\\Users\\Nicolas\\eclipse-workspace\\Vocabulary\\vocabulary\\listVocabulary.txt");
		String line = "";
		
		try {
						
			BufferedReader bufReader2 = new BufferedReader(new FileReader(file));
			
			for(int i = 0; i < countLine; i++) {
				line = bufReader2.readLine();
				if(randomValue == i) {
					break;
				}
			}
			return line;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return line;
	}
	
	public static String getFrenchWord(String str) {
		return str.split(";")[1];
	}
	
	public static String getEnglishWord(String str) {
		return str.split(";")[0];
	}
	
	public static int getCountLine() {
		File file = new File("C:\\Users\\Nicolas\\Desktop\\TOEIC\\listVocabulary.txt");
		int result = 0;
		
		try {
			BufferedReader bufReader = new BufferedReader(new FileReader(file));
			
			int countLine = 0;
			
			while(bufReader.readLine() != null) {
				countLine++;
			}
			
			return countLine;
		}
		catch (Exception e) {
			
		}
		
		return result;
	}
}
