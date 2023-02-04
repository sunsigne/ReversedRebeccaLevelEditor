package com.sunsigne.reversedrebeccaleveleditor.system;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.ConcurrentModificationException;

import com.sunsigne.reversedrebecca.system.mainloop.SuperHandler;
import com.sunsigne.reversedrebeccaleveleditor.Infos;

public class Editor extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	////////// MAIN ////////////

	public static void main(String args[]) {
		instance = new Editor();
		new Conductor().startApp();
	}

	////////// SIGNELTON ////////////

	private Editor() {

	}

	private static Editor instance;

	public static Editor getInstance() {
		return instance;
	}

	////////// THREAD ////////////

	private Thread thread;
	private boolean running;

	public synchronized void start() {
		if (running)
			return;

		running = true;
		thread = new Thread(this, Infos.NAME + "_main");
		thread.start();
	}

	public synchronized void stop() {
		running = false;

		try {
			thread.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	////////// MAIN LOOP ////////////

	public static final int SEC = 60;

	@Override
	public void run() {

		long lastTime = System.nanoTime();
		double amountOfTicks = SEC;
		double ns = 1000000000 / amountOfTicks;

//		int ticks = 0;
//		int frames = 0;

		double delta = 0;
		long timer = System.currentTimeMillis();

		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			boolean shouldRender = false;

			while (delta >= 1) {
//				ticks++;
				try {
					tick();
				} catch (ConcurrentModificationException | NullPointerException e) {
					// some ticks may be compromised. As the next tick repair the problem,
					// no need to proccess this exception.
				} catch (Exception e) {
					e.printStackTrace();
				}
				delta--;
				shouldRender = true;
			}

			if (shouldRender) {
//				frames++;
				try {
					render();
				} catch (ConcurrentModificationException | NullPointerException e) {
					// same problem as above
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (System.currentTimeMillis() - timer >= 1000) {
				timer += 1000;
//				System.out.println("Ticks : " + ticks + ", FPS : " + frames);
//				frames = 0;
//				ticks = 0;
			}
		}
		stop();
	}

	public void forceLoop() {
		try {
			tick();
			render();
		} catch (Exception e) {
			// same problem as above but can be more annoying.
			// Clearly, It's just better to ignore this catch
			// as this method is called rarelly.
		}
	}

	////////// TICK ////////////

	private void tick() {

		SuperHandler.tick();
	}

	////////// RENDER ////////////

	private void render() {

		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		g.setColor(new Color(0, 0, 0));
		g.fillRect(0, 0, Window.WIDHT, Window.HEIGHT);

		Graphics2D g2d = (Graphics2D) g;
		g2d.scale(Window.SCALE_X, Window.SCALE_Y);

		SuperHandler.render(g);

		g.dispose();
		bs.show();
	}
}
