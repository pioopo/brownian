package pl.edu.pw.fizyka.pojava.przkaipioopo;

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Thread{

	private int x = 10;
	private int y = 10;
	private int vX = 1;
	private int vY = 2;
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
