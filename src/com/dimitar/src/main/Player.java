package com.dimitar.src.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Avatar{

	public Player(int x, int y) {
		super(x, y);
		
		velX = 1;
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, 32, 32);
		
	}

	@Override
	public Rectangle getBounds() {
		
		return null;
	}

	
}
