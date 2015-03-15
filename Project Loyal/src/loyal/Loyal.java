package loyal;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import loyal.Graphics.Screen;
import loyal.Graphics.SpriteSheet;
import loyal.level.DecisionFactory;
import loyal.level.Level;

/**
 * @author Stephen Paul Curtis Jones, Alex Dupree  
 *
 *
 */
public class Loyal extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 504;
	public static final int HEIGHT = 304;
	public static final int SCALE = 2;
	public static final String NAME = "Loyal";

	public int tickCount = 0;
	public boolean running = false;

	private JFrame frame;
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
			BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer())
			.getData();
	private int[] colors = new int[6 * 6 * 6];
	private Screen screen;

	public InputHandler input;
	public Level level;

//keep ^ 

	public Loyal() {
		setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

		frame = new JFrame(NAME);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(this, BorderLayout.CENTER);
		frame.pack();
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public void init() {
		screen = new Screen(WIDTH, HEIGHT, new SpriteSheet("/sprite_sheet.png"));
		input = new InputHandler(this);
		LevelInitializer levelFlyweight = new LevelInitializer(this);
		levelFlyweight.initLeveValues();

		DecisionFactory decisonFactory = new DecisionFactory(this);
		decisonFactory.init();
		colorBasicFill();
	}


	private void colorBasicFill() {
		int index = 0;
		for (int r = 0; r < 6; r++) {
			for (int g = 0; g < 6; g++) {
				for (int b = 0; b < 6; b++) {
					int rr = (r * 255 / 5);
					int gg = (g * 255 / 5);
					int bb = (b * 255 / 5);
					colors[index++] = rr << 16 | gg << 8 | bb;
				}
			}
		}
	}

	public synchronized void start() {
		running = true;
		new Thread(this).start();
	}

	public synchronized void stop() {
		running = false;
	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000D / 60D;

		long lastTimer = System.currentTimeMillis();
		double delta = 0;

		init();

		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / nsPerTick;
			lastTime = now;
			boolean shouldRender = true;

			while (delta >= 1) {

				tick();
				delta -= 1;
				shouldRender = true;
			}

			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (shouldRender) {

				render();
			}
			

			if (System.currentTimeMillis() - lastTimer >= 1000) {
				lastTimer += 1000;
			}
		}
	}

	private String inputRun() {
		return level.inputRun(input);
	}

	public void tick() {
		tickCount++;
		level.tick();
		inputRun();
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		int xOffset = level.getEntity(0).getX() - (screen.width / 2);
		int yOffset = level.getEntity(0).getY() - (screen.height / 2);

		level.renderTiles(screen, xOffset, yOffset);
		level.renderEntities(screen);

		for (int y = 0; y < screen.height; y++) {
			for (int x = 0; x < screen.width; x++) {
				int colorCode = screen.pixels[x + y * screen.width];
				if (colorCode < 255) {
					pixels[x + y * WIDTH] = colors[colorCode];
				}
			}
		}

		Graphics g = bs.getDrawGraphics();

		g.drawRect(0, 0, getWidth(), getHeight());
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);

		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		new Loyal().start();
	}
}
