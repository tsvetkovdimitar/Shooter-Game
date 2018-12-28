package com.dimitar.src.main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {

	private Handler handler;
	private Camera camera;
	
	public MouseInput(Handler handler, Camera camera){
		
		this.handler = handler;
		this.camera = camera;
		
	}
	
	public void mousePressed(MouseEvent e){
		
		int mx = (int) (e.getX() + camera.getX());
		int my = (int) (e.getY() + camera.getY());
		
		for(int i = 0; i < handler.avatar.size(); i++){
			
			Avatar tempAvatar = handler.avatar.get(i);
			
			if(tempAvatar.getId() == ID.Player){
				
				handler.addPlayer(new Bullet(tempAvatar.getX() + 16, tempAvatar.getY() + 24, ID.Bullet, handler, mx, my));
				
			}
		}
	}
}
