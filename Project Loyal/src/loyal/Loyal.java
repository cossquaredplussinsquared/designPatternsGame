
package loyal;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.ArrayList;

import javax.swing.JFrame;

import loyal.Graphics.Screen;
import loyal.Graphics.SpriteSheet;
import loyal.entities.Entity;
import loyal.entities.MenuItem;
import loyal.entities.pointer;
import loyal.level.Level;
import loyal.level.LevelGenerator;

/**
 * @author Stephen Paul Curtis Jones
 *
 */
public class Loyal extends Canvas implements Runnable
{
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 256;
	public static final int HEIGHT = 192;
	public static final int SCALE = 3;
	public static final String NAME = "Loyal";
	
	public int tickCount = 0;
	public boolean running = false;
	
	private JFrame frame;
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	private int[] colors = new int[6*6*6];
	private Screen screen;
	
	public ArrayList<Entity> entities = new ArrayList<Entity>();
	public InputHandler input;
	public Level level;
	public pointer player;
	public LevelGenerator generator;

	private ArrayList<String> menuItems;

	private Entity menu;

//	private ArrayList<String> testMenu;
	
//	MenuItem menu2;
	
	public Loyal()
	{
		setMinimumSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		setMaximumSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		
		frame = new JFrame(NAME);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(this, BorderLayout.CENTER);
		frame.pack();
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	
	public void init()
	{
		colorBasicFill();
		screen = new Screen(WIDTH, HEIGHT, new SpriteSheet("/sprite_sheet.png"));
		input = new InputHandler(this);
		
		menuItems = new ArrayList<String>();
		menuItems.add("Start");
		menuItems.add("Load");
		menuItems.add("Option");
		menuItems.add("Quit");
//	////TESTING
//		testMenu = new ArrayList<String>();
//		testMenu.add("TESTING");
//		testMenu.add("TESTING1");
//		testMenu.add("TESTING2");
//		testMenu.add("TESTING3");
//		menu2 = new MenuItem(level, testMenu, 100);
//		
//	////TESTING
		generator = LevelGenerator.getLevelGenerator("/Levels/test_menu.png", entities);
		level = generator.getLevel();
		player = new pointer(level,"pointer",20,100,input,16,100,148, this);
		menu = new MenuItem(level, menuItems, 100);
		level.addEntity(player);
		level.addEntity(menu);
	}
	
	private void colorBasicFill()
	{
		int index = 0;
		for(int r=0; r<6; r++)
		{
			for(int g=0; g<6; g++)
			{
				for(int b=0; b<6; b++)
				{
					int rr = (r*255/5);
					int gg = (g*255/5);
					int bb = (b*255/5);
					colors[index++] = rr<<16 | gg<<8 | bb;
				}
			}
		}
	}
	
	public synchronized void start()
	{
		running = true;
		new Thread(this).start();
	}
	
	
	public synchronized void stop()
	{
		running = false;
	}
	
	
	@Override
	public void run()
	{
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000D/60D;
		
		int ticks = 0;
		int frames = 0;
		
		long lastTimer = System.currentTimeMillis();
		double delta = 0;
		
		init();
//		//////TESTING 
//		long change = System.nanoTime() + 2000000000;
//		boolean swap = true;
//		//////TESTING
		while(running)
		{
			long now = System.nanoTime();
			delta +=(now - lastTime)/nsPerTick;
			lastTime = now;
			boolean shouldRender = true;
//			/////TESTING
//			if(now > change)
//			{	
//
//				if(swap){
//				change += 500000000;
//				level.removeEntity(menu);
//
//				level.addEntity(menu2);
//				swap = false;
//				}else{
//					level.removeEntity(menu2);
//					level.addEntity(menu);
//					swap = true;
//					change += 500000000;
//				}
//			}
//			/////TESTING
			
			while(delta>=1)
			{
				ticks++;
				tick();
				delta -= 1;
				shouldRender = true;
			}
			
			try
			{
				Thread.sleep(2);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			
			if(shouldRender)
			{
				frames++;
				render();
			}
			
			if(System.currentTimeMillis()-lastTimer>=1000)
			{
				lastTimer += 1000;
				System.out.println(ticks+"ticks, " + frames + "frames");
				frames = 0;
				ticks = 0;
			}
		}
	}
	
	private String inputRun(){
		return level.inputRun(input);
	}


	public void tick()
	{
		tickCount++;
		level.tick();
		stateChange(inputRun());
	}
	
	
	private void stateChange(String state) {
		//switch state:
			
		
	}


	public void render()
	{
		BufferStrategy bs = getBufferStrategy();
		if(bs == null)
		{
			createBufferStrategy(3);
			return;
		}
		
		int xOffset = level.getEntity(0).x - (screen.width/2);
		int yOffset = level.getEntity(0).y - (screen.height/2);
		
		level.renderTiles(screen, xOffset, yOffset);
		level.renderEntities(screen);
		
		
		for(int y=0; y<screen.height; y++)
		{
			for(int x=0; x<screen.width; x++)
			{
				int colorCode = screen.pixels[x+y*screen.width];
				if(colorCode<255)
				{
					pixels[x+y*WIDTH]=colors[colorCode];
				}
			}
		}
		
		Graphics g = bs.getDrawGraphics();

		g.drawRect(0, 0, getWidth(), getHeight());
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		
		g.dispose();
		bs.show();
	}
	
	
	public static void main(String[] args)
	{
		new Loyal().start();
	}

}
