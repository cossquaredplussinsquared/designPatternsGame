package loyal.level;

import java.util.ArrayList;

import loyal.InputHandler;
import loyal.Sound;
import loyal.entities.BattleCharacters;
import loyal.entities.Entity;
import loyal.entities.MenuItems;
import loyal.entities.Pointer;

public class BattleLevel extends Level {
	final int PLAYERNAMESY = 8;
	final int ENEMYNAMESY = 8;
	final int MENUSTARTY = 232;
	
	final int PLAYERNAMESX = 16;
	final int ENEMYNAMESX = 340;
	final int MENUSTARTX = 32;
	
	final int POINTERJUMP = 16;
	final int PLAYERJUMP = 50;
	final int ENEMYJUMP = 50;
	

	public BattleLevel(int id, String imagePath, Sound music) {
		super(id, imagePath, music);
		super.setPlayerDefaultX(16);
		super.setPlayerDefaultY(240);
	}

	public void setPlayerName(ArrayList<String> playerNames) {
		Entity Names = new MenuItems(this, playerNames, PLAYERNAMESX, PLAYERNAMESY, PLAYERJUMP);

		entities.remove(1);
		entities.add(1, Names);
	}

	public void setEnemyName(ArrayList<String> monsterNames) {
		Entity Names = new MenuItems(this, monsterNames, ENEMYNAMESX, ENEMYNAMESY, ENEMYJUMP);

		entities.remove(2);
		entities.add(2, Names);
	}

	public void setMenu(ArrayList<String> menuOptions) {
		Entity options = new MenuItems(this, menuOptions, MENUSTARTX, MENUSTARTY, POINTERJUMP);

		entities.remove(3);
		entities.add(3, options);
	}

	public int getIndex() {

		return ((Pointer)entities.get(0)).getPosition();
	}

//	// TESTING
//	@Override
//	public String inputRun(InputHandler input){
//		super.inputRun(input);
//		System.out.println(((Pointer)entities.get(0)).getPosition());
//		if(input.enter.isPressed()){
//			((BattleCharacters)entities.get(((Pointer)entities.get(0)).getPosition())).attack = true;
//		}
//		
//		return "";
//	}
}
