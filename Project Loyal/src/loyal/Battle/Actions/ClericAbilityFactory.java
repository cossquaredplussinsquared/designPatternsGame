
package loyal.Battle.Actions;

import loyal.Battle.Characters.CharacterType;
import loyal.Battle.Characters.PlayingCharacter;
import loyal.entities.Cleric;

public class ClericAbilityFactory implements AbilityFactory
{

	protected LightningSpearOffensiveSingleTarget lightningSpear;
	protected MagicBarrierDefensiveSingleTargetAbility magicBarrier;
	protected SacredOathMultiTargetDefensiveAbility sacredOath;
	protected SootingSunlightDefensiveSingleTargetAbility sootingSunlight;
	protected PlayingCharacter playingCharacter;
	
	public ClericAbilityFactory()
	{
		this.playingCharacter = new Cleric("", CharacterType.CLERIC);
		lightningSpear = new LightningSpearOffensiveSingleTarget(playingCharacter);
		magicBarrier = new MagicBarrierDefensiveSingleTargetAbility(playingCharacter);
		sacredOath = new SacredOathMultiTargetDefensiveAbility(playingCharacter);
		sootingSunlight = new SootingSunlightDefensiveSingleTargetAbility(playingCharacter);
	}
	

	@Override
	public Ability createCharacterAction(String name, PlayingCharacter playingCharacter)
	{
		 
		Ability ability;
		
		switch(name.toLowerCase())
		{
			case "lightning spear":
				ability = new LightningSpearOffensiveSingleTarget(playingCharacter);
				ability.setValues(100, 14, 3);
				break;
				
			case "magic barrier":
				ability = new MagicBarrierDefensiveSingleTargetAbility(playingCharacter);
				ability.setValues(120, 9, 5);
				break;
			
			case "sooting sunlight":
				ability = new SootingSunlightDefensiveSingleTargetAbility(playingCharacter);
				ability.setValues(120, 8, 4);
				break;
				
			case "sacred oath":
				ability = new SacredOathMultiTargetDefensiveAbility(playingCharacter);
				ability.setValues(150, 16, 6);
				break;
				
			default:
				ability = null;
		}
		
		return ability;
		
	}

	@Override
	public String[] displayAbilitiesBasedOnType()
	{
		String listOfAbilities [] = {lightningSpear.getName(), magicBarrier.getName(), sootingSunlight.getName(), sacredOath.getName()};
		return listOfAbilities;
	}
	
	public void printListOfAbilities()
	{
		String [] listOfAbilities = displayAbilitiesBasedOnType();
		for(int i = 0; i < listOfAbilities.length; i++)
		{
			System.out.println(listOfAbilities[i]);
		}
	}
	
}
