package com.dimitar.src.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Enemy extends Avatar{

	private Handler handler;
	Random r = new Random();
	int choose = 0;
	int hp = 100;
	
	private BufferedImage[] enemy_image = new BufferedImage[3];
	Animation anim;
	
	public Enemy(int x, int y, ID id, Handler handler, SpriteSheet ss) {
		super(x, y, id, ss);
		
		this.handler = handler;
		
		enemy_image[0] = ss.grabImage(4, 1, 32, 32);
		enemy_image[1] = ss.grabImage(5, 1, 32, 32);
		enemy_image[2] = ss.grabImage(6, 1, 32, 32);
		
		anim = new Animation(3, enemy_image[0], enemy_image[1], enemy_image[2]);
	}

	@Override
	public void tick() {
		
		x += velX;
		y += velY;
		
		choose = r.nextInt(10);
		
		for(int i = 0; i < handler.avatar.size(); i++){
			
			Avatar tempAvatar = handler.avatar.get(i);
			
			if(tempAvatar.getId() == ID.Block){
				
				if(getBoundsBig().intersects(tempAvatar.getBounds())){
					
					x += (velX*4) * -1;
					y += (velY*4) * -1;
					velX *= -1;
					velY *= -1;
						
				}
				else if(choose == 0){
					
					velX = (r.nextInt(4 - -4) + - 4);
					velY = (r.nextInt(4 - -4) + - 4);
					
				}
				
			}
			
			if(tempAvatar.getId() == ID.Bullet){
				
				if(getBounds().intersects(tempAvatar.getBounds())){
					
					hp -= 50;
					handler.removePlayer(tempAvatar);
				
				}
			}
			
		}
		
		anim.runAnimation();
		
		if(hp <= 0){
			
			handler.removePlayer(this);
			
		}
		
	}

	@Override
	public void render(Graphics g) {
		
		anim.drawAnimation(g, x, y, 0);
		
	}

	@Override
	public Rectangle getBounds() {
		
		return new Rectangle(x, y, 32, 32);
	}
	
	public Rectangle getBoundsBig() {
		
		return new Rectangle(x-16, y-16, 64, 64);
	}

}
