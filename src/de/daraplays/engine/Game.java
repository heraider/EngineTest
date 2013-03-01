package de.daraplays.engine;

import java.awt.Canvas;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	public boolean running = false;

	public Game() {

	}

	public void init() {

	}

	public synchronized void start() {
		this.running = true;
		new Thread(this).start();
	}

	public synchronized void stop() {
		this.running = false;
	}

	@Override
	public void run() {
		long lastTimer = System.currentTimeMillis();
		int frames = 0;

		while (running) {
			tick();
			frames++;
			render();

			if (System.currentTimeMillis() - lastTimer >= 1000) {
				lastTimer += 1000;
				System.out.println(frames);
				frames = 0;
			}
		}

	}

	public void tick() {

	}

	public void render() {

	}

	public static void main(String[] args) {
		Game game = new Game();
		game.start();
	}
}
