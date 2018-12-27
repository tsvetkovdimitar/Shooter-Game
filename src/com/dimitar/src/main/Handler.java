package com.dimitar.src.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	
	LinkedList<Avatar> avatar = new LinkedList<Avatar>();
	
	private boolean up = false, down = false, right = false, left = false;
	
	public void tick(){
		
		for(int i = 0; i < avatar.size(); i ++){
			
			Avatar tempPlayer = avatar.get(i);
			
			tempPlayer.tick();  
			
		}
		
	}
	
	public void render(Graphics g){
		
		for(int i = 0; i < avatar.size(); i ++){
					
			Avatar tempPlayer = avatar.get(i);
					
			tempPlayer.render(g);
					
		}
		
	}
	
	public void addPlayer(Avatar tempPlayer){
		avatar.add(tempPlayer);
	}
	
	public void removePlayer(Avatar tempPlayer){
		avatar.remove(tempPlayer);
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

}
