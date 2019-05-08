package pl.edu.pw.fizyka.pojava.przkaipioopo;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;





public class AnimationPanel extends JPanel implements Runnable{
	
	
	private static final long serialVersionUID = 1L;
	
	List<Ball> balls = new ArrayList<Ball>();
	
	
	public AnimationPanel() {
	       // default constructor
		}
	//Adding new default balls to the list "balls"
	
	public void addBall(){
		Ball b = new Ball();
		balls.add(b);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (Ball pr : balls) {
			pr.paint(g);
		}

	}
	
	
	public void run() {
		while(1<2){
			for (Ball pr : balls) {
				pr.setX(pr.getX()+pr.getVX());
				if(pr.getX()+pr.getR()>700)
					pr.setVX(pr.getVX()*-1);
				if(pr.getX()<0)
					pr.setVX(pr.getVX()*-1);
				pr.setY(pr.getY()+pr.getVY());
				if(pr.getY()+pr.getR()>300)
					pr.setVY(pr.getVY()*-1);
				if(pr.getY()<0)
					pr.setVY(pr.getVY()*-1);
				
				
				
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			repaint();
			}
	}
	
	

}
