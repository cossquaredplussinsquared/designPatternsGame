package loyal.entities;

import loyal.InputHandler;
import loyal.Loyal;
import loyal.Graphics.Screen;
import loyal.level.Level;

public abstract class Entity {
	protected int x, y;
	protected Level level;

	public Entity(Level level) {
		init(level);
	}

	public final void init(Level level) {
		this.level = level;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public abstract void tick();

	public abstract void render(Screen screen);

	public abstract String inputRun(InputHandler input);

	public void setX(int defaultX) {
		this.x = defaultX;
	}

	public void setY(int defaultY) {
		this.y = defaultY;
	}

}
