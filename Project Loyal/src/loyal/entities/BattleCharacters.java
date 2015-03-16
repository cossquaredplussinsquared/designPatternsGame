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
	private boolean attack = true;
	private int xTile = 0;
	private int yTile = 20;
	private int counter = 0;
	private int direction = 0;
	private int jumpOffset = 0;
	
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
		if(attack == true)
		{
			if(direction == 0)
			{
				xTile+=4;
				direction=1;
				counter+=4;
				this.x+=4;
				this.y--;
			}
			else if(direction == 1 && counter < 220)
			{
				counter+=4;
				this.x+=4;
				if(counter%40 == 0)
				{
					this.y = this.y - 2;
				}	
			}
			
			else if(direction == 1 && counter >= 220 && counter < 440)
			{
				counter+=4;
				this.x+=4;
				if(counter%40 == 0)
				{
					this.y = this.y + 2;
				}	
			}
			
			
			else if(direction == 1 && counter == 440)
			{
				direction = 2;
				counter-=4;
				this.x-=4;
				if(counter%40 == 0)
				{
					this.y = this.y - 2;
				}	
				xTile-=4;
			}
			
			else if(direction == 2 && counter >=220 && counter < 440)
			{
				counter-=4;
				this.x-=4;
				if(counter%40 == 0)
				{
					this.y = this.y - 2;
				}	
			}
			
			else if(direction == 2 && counter < 220 && counter > 0)
			{
				counter-=4;
				this.x-=4;
				if(counter%40 == 0)
				{
					this.y = this.y + 2;
				}	
			}
			
			else if(direction == 2 && counter == 0)
			{
				direction = 0;
				attack = false;
				xTile-=4;
			}
			
			if(direction == 1 && counter == 344)
			{
				xTile+=4;
			}
		}
		tickCount++;
	}

	@Override
	public void render(Screen screen)
	{
		

		int modifier = 8 * scale;
		int xOffset = x - modifier / 2;
		int yOffset = y - modifier / 2 - 4;


		screen.render(xOffset + modifier, yOffset, xTile + yTile* 32, colors[0],0x00, scale);	
		screen.render(xOffset + 2*modifier, yOffset, xTile + 1 + yTile * 32, colors[0],0x00,scale);
		screen.render(xOffset + 3*modifier, yOffset, xTile + 2 + yTile * 32, colors[0],0x00, scale);
		screen.render(xOffset + 4*modifier, yOffset, xTile + 3 + yTile * 32, colors[0],0x00, scale);
		
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
