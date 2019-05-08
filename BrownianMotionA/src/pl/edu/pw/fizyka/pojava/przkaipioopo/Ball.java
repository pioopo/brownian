package pl.edu.pw.fizyka.pojava.przkaipioopo;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Ball extends Thread{

	Random randomGenerator = new Random();
	private int x = randomGenerator.nextInt(100);
	private int y = randomGenerator.nextInt(100);
	private int vX = randomGenerator.nextInt(60) + 1;
	private int vY = randomGenerator.nextInt(60) + 1;
	private int r = 3;
	 
	public int getX(){
		return x;	
	}
	
	public int getY(){
		return y;
	}
	
	public int getVX(){
		return vX;
	}
	
	public int getVY(){
		return vY;
	}
	
	public void setX(int i){
		x = i;
	}
	
	public void setY(int i){
		y = i;
	}
	
	public void setVX(int i){
		vX = i;
	}
	
	public void setVY(int i){
		vY = i;
	}
	
	public int getR(){
		return r;
	}
	
	public void paint(Graphics g){
		g.setColor(Color.black);
        g.fillOval(x, y, 2*r, 2*r);
        
    }
}
