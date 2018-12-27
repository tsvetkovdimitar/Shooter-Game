package com.dimitar.src.main;
 
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 1L;


	private boolean isRunning = false;
	
	private Thread thread;
	
	private Handler handler;
	
	private Camera camera;
	
	private BufferedImage level = null;
	
	public Game(){
		
		new Window(1000, 563, "Wizard Game", this);
		start();
		
		handler = new Handler();
		
		camera = new Camera(0, 0);
		
		this.addKeyListener(new KeyInput(handler));
		
		BufferedImageLoader loader = new BufferedImageLoader();
		level = loader.loadImage("/game_level.png");
		
		LoadLevel(level);
		
	}
	
	private void start() {

		isRunning = true;
		thread = new Thread(this);
		thread.start();
		
	}
	
	private void stop() {
		
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void run(){
		
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		
		while(isRunning){
			
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			while(delta >= 1){
				
				tick();
				//updates++;
				delta--;
				
			}
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000){
				
				timer += 1000;
				frames = 0;
				
				//updates = 0;
				
			}
			
		}
		stop();
		
	}
	
	public void tick(){
		
		for(int i = 0; i < handler.avatar.size(); i++){
			
			if(handler.avatar.get(i).getId() == ID.Player){
				
				camera.tick(handler.avatar.get(i));
				
			}
			
		}
		
		handler.tick();
	}
	
	public void render(){
		
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null){
			
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
		
		g.setColor(Color.red);
		g.fillRect(0, 0, 1000, 563);
		
		g2d.translate(-camera.getX(), -camera.getY());
		
		handler.render(g);
		
		g2d.translate(camera.getX(), camera.getY());
		
		g.dispose();
		bs.show();
	}
	
	//loading the level
	
	private void LoadLevel(BufferedImage image){
		
		int w = image.getWidth();
		int h = image.getHeight();
		
		for(int i = 0; i < w; i++){
			
			for(int j = 0; j < h; j++){
				
				int pixel = image.getRGB(i, j);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				
				if(red == 255){
					
					handler.addPlayer(new Block(i*32, j*32, ID.Block));
					
				}
				
				if(blue == 255){
					
					handler.addPlayer(new Sorcerer(i*32, j*32, ID.Player, handler));
					
				}
				
			}
			
		}
		
	}
	
	public static void main(String[] args){
		
		Game game = new Game();
	}

}
