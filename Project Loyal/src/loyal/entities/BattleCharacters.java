package loyal.entities;

import java.awt.Color;

import loyal.InputHandler;
import loyal.Loyal;
import loyal.Graphics.Colors;
import loyal.Graphics.Screen;
import loyal.level.Level;

public class BattleCharacters extends Entity
{
	
	private int tickCount = 0;
	private int scale = 1;
	int[] colors;
	
	public BattleCharacters(Level level, int x, int y, int[] colors)
	{
		super(level);
		this.x = x;
		this.y = y;
		this.colors = colors;
	}

	@Override
	public void tick()
	{
		tickCount++;
	}

	@Override
	public void render(Screen screen)
	{
		int xTile = 0;
		int yTile = 27;

		int modifier = 8 * scale;
		int xOffset = x - modifier / 2;
		int yOffset = y - modifier / 2 - 4;


		screen.render(xOffset + modifier, yOffset, xTile + yTile* 32, colors[0],0x00, scale);	
		screen.render(xOffset + 2*modifier, yOffset, xTile + 1 + yTile * 32, colors[0],0x00,scale);
		screen.render(xOffset + 3*modifier, yOffset + modifier, xTile + 2 + yTile * 32, colors[0],0x00, scale);
		screen.render(xOffset + 4*modifier, yOffset + modifier, xTile + 3 + yTile * 32, colors[0],0x00, scale);
		
		screen.render(xOffset + modifier, yOffset+modifier, xTile + (yTile + 1)* 32, colors[0],0x00, scale);
		screen.render(xOffset + 2*modifier, yOffset+modifier, xTile + 1 + (yTile + 1)* 32, colors[0],0x00,scale);
		screen.render(xOffset + 3*modifier, yOffset + modifier, xTile + 2 + (yTile + 1) * 32, colors[0],0x00, scale);
		screen.render(xOffset + 4*modifier, yOffset + modifier, xTile + 3 + (yTile + 1) * 32, colors[0],0x00, scale);
		
		screen.render(xOffset + modifier, yOffset + 2*modifier, xTile + (yTile + 2)* 32, colors[0],0x00, scale);
		screen.render(xOffset + 2*modifier, yOffset + 2*modifier, xTile + 1 + (yTile + 2) * 32, colors[0],0x00,scale);
		screen.render(xOffset + 3*modifier, yOffset + 2*modifier, xTile + 2 + (yTile + 2) * 32, colors[0],0x00, scale);
		screen.render(xOffset + 4*modifier, yOffset + 2*modifier, xTile + 3 + (yTile + 2) * 32, colors[0],0x00, scale);
		
		screen.render(xOffset + modifier, yOffset + 3*modifier, xTile + (yTile + 3)* 32, colors[0],0x00, scale);
		screen.render(xOffset + 2*modifier, yOffset + 3*modifier, xTile + 1 + (yTile + 3) * 32, colors[0],0x00,scale);
		screen.render(xOffset + 3*modifier, yOffset + 3*modifier, xTile + 2 + (yTile + 3) * 32, colors[0],0x00, scale);
		screen.render(xOffset + 4*modifier, yOffset + 3*modifier, xTile + 3 + (yTile + 3) * 32, colors[0],0x00, scale);
	}

	@Override
	public String inputRun(InputHandler input)
	{
		return null;
	}

}
