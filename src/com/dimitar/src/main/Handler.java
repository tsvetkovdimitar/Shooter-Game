package com.dimitar.src.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	
	LinkedList<Avatar> avatar = new LinkedList<Avatar>();
	
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

}
