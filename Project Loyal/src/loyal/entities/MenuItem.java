package loyal.entities;

import java.util.ArrayList;

import loyal.InputHandler;
import loyal.Graphics.Colors;
import loyal.Graphics.Font;
import loyal.Graphics.Screen;
import loyal.level.Level;

public class MenuItem extends Entity {

	private ArrayList<String> words;
	private int start;
	public MenuItem(Level level, ArrayList<String> words, int start) {
		super(level);
		this.words = words;
		this.start = start;
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Screen screen) {
		for(int i=0; i<this.words.size(); i++)
		{
			Font.render(this.words.get(i),screen,x+16,start-8+16*i,Colors.get(-1,-1,-1,555),1);
		}
	}

}
