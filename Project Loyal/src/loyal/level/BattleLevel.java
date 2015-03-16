package loyal.level;

import java.util.ArrayList;

import loyal.InputHandler;
import loyal.Sound;
import loyal.entities.BattleCharacters;
import loyal.entities.Entity;
import loyal.entities.MenuItems;
import loyal.entities.Pointer;

public class BattleLevel extends Level {
	final int PLAYERNAMESY = 40;
	final int ENEMYNAMESY = 50;
	final int MENUSTARTY = 240;
	
	final int PLAYERNAMESX = 40;
	final int ENEMYNAMESX = 50;
	final int MENUSTARTX = 240;

	public BattleLevel(int id, String imagePath, Sound music) {
		super(id, imagePath, music);
		super.setPlayerDefaultX(16);
		super.setPlayerDefaultY(240);
	}

	public void setPlayerName(ArrayList<String> playerNames) {
		Entity Names = new MenuItems(this, playerNames, PLAYERNAMESX, PLAYERNAMESY);

		entities.remove(0);
		entities.add(0, Names);
	}

	public void setEnemyName(ArrayList<String> monsterNames) {
		Entity Names = new MenuItems(this, monsterNames, ENEMYNAMESX, ENEMYNAMESY);

		entities.remove(1);
		entities.add(1, Names);
	}

	public void setMenu(ArrayList<String> menuOptions) {
		Entity options = new MenuItems(this, menuOptions, MENUSTARTX, MENUSTARTY);

		entities.remove(2);
		entities.add(2, options);
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
