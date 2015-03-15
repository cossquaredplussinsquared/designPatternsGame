package loyal.entities;

import java.util.ArrayList;
import java.util.Random;

import loyal.InputHandler;
import loyal.Loyal;
import loyal.Graphics.Colors;
import loyal.Graphics.Screen;
import loyal.level.Level;
import loyal.level.LevelGenerator;
import loyal.level.edgeCollisionDecision;
import loyal.level.tiles.Tile;

public class MapPlayer extends Mob {
	
	private final int StaminaSize = 2000;
	private InputHandler input;
	private int color = Colors.get(-1, 200, 020, 321);
	private int color2 = Colors.get(-1, 200, 020, 543);
	private int scale = 1;
	private int tickCount;
	private Loyal game;
	private int walkingSpeed = 4;
	private int stamina = StaminaSize;
	private boolean runCheck = false;
	private boolean canRun = true;

	public MapPlayer(Level level, int x, int y, InputHandler input, Loyal game) {
		super(level, "Player", x, y, 1);
		this.input = input;
		this.game = game;
	}

	public boolean hasCollided(int xa, int ya) {
		int xMin = 1;
		int xMax = 6;
		int yMin = 3;
		int yMax = 7;

		for (int x = xMin; x < xMax; x++) {
			if (isSolidTile(xa, ya, x, yMin)) {
				return true;
			}
		}

		for (int x = xMin; x < xMax; x++) {
			if (isSolidTile(xa, ya, x, yMax)) {
				return true;
			}
		}

		for (int y = yMin; y < yMax; y++) {
			if (isSolidTile(xa, ya, xMin, y)) {
				return true;
			}
		}

		for (int y = yMin; y < yMax; y++) {
			if (isSolidTile(xa, ya, xMax, y)) {
				return true;
			}
		}
		return false;
	}

	public void tick()
	{
		tileCheck();
		tickCount++;
	}
	
	public void render(Screen screen) {
		int xTile = 0;
		int yTile = 27;

		int flipTop = (numSteps >> walkingSpeed & 1);
		int flipBottom = (numSteps >> walkingSpeed & 1);

		if (movingDir == 0) {

			xTile += 8;
		} else if (movingDir == 1) {
			xTile += 10;
		} else if (movingDir > 1) {
			xTile += 4 + ((numSteps >> walkingSpeed) & 1) * 2;
			flipTop = (movingDir - 1) % 2;
			flipBottom = (movingDir - 1) % 2;
		}


		int modifier = 8 * scale;
		int xOffset = x - modifier / 2;
		int yOffset = y - modifier / 2 - 4;

		if (isSwimming) {

			int waterColor = 0;
			yOffset += 4;
			if (tickCount % 60 < 15) {
				waterColor = Colors.get(-1, -1, 225, -1);
			} else if (15 <= tickCount % 60 && tickCount % 60 < 30) {
				yOffset -= 1;
				waterColor = Colors.get(-1, 225, 115, -1);
			} else if (30 <= tickCount % 60 && tickCount % 60 < 45) {
				waterColor = Colors.get(-1, 115, -1, -225);
			} else {
				yOffset -= 1;
				waterColor = Colors.get(-1, 225, 115, -1);
			}
			screen.render(xOffset, yOffset + 3, 0 + 26 * 32, waterColor, 0x00,
					scale);
			screen.render(xOffset + 8, yOffset + 3, 0 + 26 * 32, waterColor,
					0x01, scale);
		}

		screen.render(xOffset + (modifier * flipTop), yOffset, xTile + yTile
				* 32, color2, flipTop, scale);
		screen.render(xOffset + modifier - (modifier * flipTop), yOffset, xTile
				+ 1 + yTile * 32, color2, flipTop, scale);

		if (!isSwimming && !tallGrass) {
			screen.render(xOffset + (modifier * flipBottom),
					yOffset + modifier, xTile + (yTile + 1) * 32, color,
					flipBottom, scale);
			screen.render(xOffset + modifier - (modifier * flipBottom), yOffset
					+ modifier, xTile + 1 + (yTile + 1) * 32, color,
					flipBottom, scale);
		}
	}

	@Override
	public String inputRun(InputHandler input) {
		int xa = 0;
		int ya = 0;
		this.walkingSpeed = 4;

		if (input.up.isPressed()) {
			ya--;
		}
		if (input.down.isPressed()) {
			ya++;
		}
		if (input.left.isPressed()) {
			xa--;
		}
		if (input.right.isPressed()) {
			xa++;
		}
		if (input.escape.isPressed()) {

		}
		if(input.shift.isPressed() && canRun == true)
		{
			this.speed = 2;
			this.walkingSpeed = 3;
			runCheck = true;
			stamina--;
		}
		if(runCheck == false && stamina < StaminaSize)
		{
			stamina++;
		}
		if(stamina == 0)
		{
			canRun = false;
		}
		if(stamina == StaminaSize/2)
		{
			canRun = true;
		}

		if (xa != 0 || ya != 0) {
			move(xa, ya);
			isMoving = true;
			///TESTING REMOVE
			level.currentDecision = new edgeCollisionDecision();
			level.currentDecision.setGame(game);
			///TESTING REMOVE
			level.checkNewLevel(this.x, this.y);

		} 
		else 
		{
			isMoving = false;
		}
		
		this.speed = 1;
		runCheck = false;
		
		return "";
	}
}