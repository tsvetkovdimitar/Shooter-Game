package com.dimitar.src.main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {

	private Handler handler;
	private Camera camera;
	private Game game;
	
	public MouseInput(Handler handler, Camera camera, Game game){
		
		this.handler = handler;
		this.camera = camera;
		this.game = game;
		
	}
	
	public void mousePressed(MouseEvent e){
		
		int mx = (int) (e.getX() + camera.getX());
		int my = (int) (e.getY() + camera.getY());
		
		for(int i = 0; i < handler.avatar.size(); i++){
			
			Avatar tempAvatar = handler.avatar.get(i);
			
			if(tempAvatar.getId() == ID.Player && game.ammo >= 1){
				
				handler.addPlayer(new Bullet(tempAvatar.getX() + 16, tempAvatar.getY() + 24, ID.Bullet, handler, mx, my));
				game.ammo--;
			}
		}
	}
}
