package loyal.entities;

import java.util.ArrayList;

import loyal.InputHandler;
import loyal.Graphics.Colors;
import loyal.Graphics.Font;
import loyal.Graphics.Screen;
import loyal.level.Level;

public class MenuItems extends Entity {

	private ArrayList<String> words;
	private int startY;
	private int startX;
	private int jump;
	
	public MenuItems(Level level, ArrayList<String> words, int startX, int startY, int jump) {
		super(level);
		this.words = words;
		this.startX = startX;
		this.startY = startY;
		this.jump = jump;
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Screen screen) {
		for(int i=0; i<this.words.size(); i++)
		{
			Font.render(this.words.get(i),screen,startX,startY+jump*i,Colors.get(-1,-1,-1,555),1);
		}
	}

	@Override
	public String inputRun(InputHandler input) {
		// TODO Auto-generated method stub
		return "";
	}
	
	public int getStart()
	{
		return startY;
	}

}
