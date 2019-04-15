package pl.edu.pw.fizyka.pojava.przkaipioopo;

import java.awt.BorderLayout;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MainClass {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				Gui gui = new Gui();
				gui.setVisible(true);
				JPanel f = new JPanel();
				f.setSize(380, 670);
				
				AnimationPanel panel = new AnimationPanel();
				panel.setSize(630, 500);
				
				//Nie wiem dlaczego lata tylko jedna kulka !!!
				for (int i = 1; i<20 ; i++) {
					panel.addBall();
					System.out.println("Dodano kulkie");
				
				}
				
				//panel.setVisible(true);
				f.add(panel);
				//f.setVisible(true);
				gui.add(panel, BorderLayout.CENTER);
				ExecutorService exec = Executors.newFixedThreadPool(2);
				exec.execute(panel);
				
			
				
				exec.shutdown();
				
				
				
			}});
		
		
		
		
	}
	
}
