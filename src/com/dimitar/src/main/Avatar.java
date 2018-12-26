package com.dimitar.src.main;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Avatar {
	
	protected int x, y;
	protected double velX = 0, velY = 0;
	
	public Avatar(int x, int y){
		
		this.x = x;
		this.y = y;
		
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getVelX() {
		return velX;
	}

	public void setVelX(float velX) {
		this.velX = velX;
	}

	public double getVelY() {
		return velY;
	}

	public void setVelY(float velY) {
		this.velY = velY;
	}

}
