package com.dimitar.src.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Sorcerer extends Avatar{
	
	Handler handler;
	Game game;

	private BufferedImage[] sorcerer_image = new BufferedImage[3];
	
	Animation anim;
	
	public Sorcerer(int x, int y, ID id, Handler handler, Game game, SpriteSheet ss) {
		super(x, y, id, ss);
		this.handler = handler;	
		this.game = game;
		
		sorcerer_image[0] = ss.grabImage(1, 1, 32, 48);
		sorcerer_image[1] = ss.grabImage(2, 1, 32, 48);
		sorcerer_image[2] = ss.grabImage(3, 1, 32, 48);
		
		anim = new Animation(3, sorcerer_image[0], sorcerer_image[1], sorcerer_image[2]);
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
		
		anim.runAnimation();
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
		
		if(velX == 0 && velY == 0){
			
			g.drawImage(sorcerer_image[0], x, y, null);
		
		}
		else{
			
			anim.drawAnimation(g, x, y, 0);
			
		}
		
	}

	@Override
	public Rectangle getBounds() {
		
		return new Rectangle(x, y, 32, 48);
	}

}
