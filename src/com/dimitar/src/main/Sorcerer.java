package com.dimitar.src.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Sorcerer extends Avatar{
	
	Handler handler;
	Game game;

	public Sorcerer(int x, int y, ID id, Handler handler, Game game) {
		super(x, y, id);
		this.handler = handler;	
		this.game = game;
	}

	@Override
	public void tick() {
		
		x += velX;
		y += velY;
		
		collision();
		
		if(handler.isUp()){
			
			velY = -5;
			
		}
		
		else if(!handler.isDown()){
			
			velY = 0;
			
		}
		
		if(handler.isDown()){
			
			velY = 5;
			
		}
		
		else if(!handler.isUp()){
			
			velY = 0;
			
		}
		
		if(handler.isRight()){
			
			velX = 5;
			
		}
		
		else if(!handler.isLeft()){
			
			velX = 0;
			
		}
		
		if(handler.isLeft()){
			
			velX = -5;
			
		}
		
		else if(!handler.isRight()){
			
			velX = 0;
			
		}
	}
	
	private void collision(){
		
		for(int i = 0; i < handler.avatar.size(); i++){
			
			Avatar tempAvatar = handler.avatar.get(i);
			
			if(tempAvatar.getId() == ID.Block){
				
				if(getBounds().intersects(tempAvatar.getBounds())){
					
					x += velX * -1;
					y += velY * -1;
					
				}
				
			}
			
			if(tempAvatar.getId() == ID.Crate){
				
				if(getBounds().intersects(tempAvatar.getBounds())){
					
					game.ammo += 5;
					handler.removePlayer(tempAvatar);
					
				}
				
			}
			
		}
		
	}

	@Override
	public void render(Graphics g) {
		
		g.setColor(Color.blue);
		g.fillRect(x, y, 32, 48);
		
	}

	@Override
	public Rectangle getBounds() {
		
		return new Rectangle(x, y, 32, 48);
	}

}
