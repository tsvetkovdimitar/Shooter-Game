package com.dimitar.src.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends Avatar{
	
	private Handler handler;

	public Bullet(int x, int y, ID id, Handler handler, int mx, int my, SpriteSheet ss) {
		super(x, y, id, ss);
		this.handler = handler;
		
		velX = (mx - x) / 10;
		velY = (my - y) / 10;
	}

	@Override
	public void tick() {
		
		x += velX;
		y += velY;
		
		for(int i = 0; i < handler.avatar.size(); i++){
			
			Avatar tempAvatar = handler.avatar.get(i);
			
			if(tempAvatar.getId() == ID.Block){
				
				if(getBounds().intersects(tempAvatar.getBounds())){
					
					handler.removePlayer(this);
					
				}
				
			}
			
		}
	}

	@Override
	public void render(Graphics g) {
		
		g.setColor(Color.green);
		g.fillOval(x, y, 8, 8);
	}

	@Override
	public Rectangle getBounds() {
		
		return new Rectangle(x, y, 8, 8);
	}
	
	

}
