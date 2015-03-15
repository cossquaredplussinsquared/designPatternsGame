package loyal.entities;

import java.util.ArrayList;

import loyal.InputHandler;
import loyal.LevelInitializer;
import loyal.Loyal;
import loyal.Graphics.Colors;
import loyal.Graphics.Screen;
import loyal.level.Level;

public class Pointer extends Mob {
	private int color = Colors.get(-1, -1, -1, 555);
	private int scale = 1;
	private long time = 0;
	private long curTime;
	private long prevTime = System.currentTimeMillis();
	private int jump;
	private int start;
	private int end;
	private Loyal game;

	public Pointer(Level level, String name, int x, int y, int jump, int start,
			int end, Loyal game) {
		super(level, name, x, y, 1);
		this.jump = jump;
		this.start = start;
		this.end = end;
		this.game = game;
	}

	public boolean hasCollided(int xa, int ya) {
		if (y + ya < this.start || y + ya > this.end) {
			return true;
		}
		return false;
	}

	public void tick() {
		curTime = System.currentTimeMillis();
		time = curTime - prevTime;

	}

	public void decisionStateChange() {
		if (level == LevelInitializer.STARTMENU) {
			if (position == 1) {
				game.level.music.stop();
				game.level = LevelInitializer.VILLAGE;
				game.level.music.loop();
			}
		}else if(level == LevelInitializer.BATTLE){
			game.level.music.stop();
			game.level = LevelInitializer.OVERWORLD;
			game.level.music.loop();
		}
	}

	public void render(Screen screen) {
		int xTile = 1;
		int yTile = 26;

		int modifier = 8 * scale;
		int xOffset = x - modifier / 2;
		int yOffset = y - modifier / 2 - 4;

		screen.render(xOffset + modifier, yOffset, xTile + yTile * 32, color,
				0x00, scale);

	}

	@Override
	public String inputRun(InputHandler input) {
		if (time > 100) {
			int xa = 0;
			int ya = 0;

			if (input.up.isPressed()) {
				ya = ya - jump;
				direction++;
			}
			if (input.down.isPressed()) {
				ya = ya + jump;
				direction--;
			}
			if (input.enter.isPressed()) {
				decisionStateChange();
			}

			if (xa != 0 || ya != 0) {
				move(xa, ya);
				isMoving = true;
			} else {
				isMoving = false;
			}
			prevTime = System.currentTimeMillis();
		}
		direction = 0;
		return "";
	}

}