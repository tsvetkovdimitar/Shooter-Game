package com.dimitar.src.main;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Avatar {
	
	protected int x, y;
	protected double velX = 0, velY = 0;
	
	protected ID id;
	protected SpriteSheet ss;
	
	public Avatar(int x, int y, ID id, SpriteSheet ss){
		
		this.x = x;
		this.y = y;
		this.id = id;
		this.ss = ss;
		
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

	public void setVelX(double velX) {
		this.velX = velX;
	}

	public double getVelY() {
		return velY;
	}

	public void setVelY(double velY) {
		this.velY = velY;
	}

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

}
