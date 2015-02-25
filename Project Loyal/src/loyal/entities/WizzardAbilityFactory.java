package loyal.entities;

public class WizzardAbilityFactory implements AbilityFactory
{

	protected DarkOrbOffensiveSingleTargetAbility darkOrb;
	protected SoulArrowOffensiveSingleTarget soulArrow;
	protected SoulShowerMultiTargetOffensiveAbility soulShower;
	protected MagicShieldDefensiveSingleTargetAbility magicShield;
	protected PlayingCharacter playingCharacter;
	
	public WizzardAbilityFactory()
	{
		
	}
	
	@Override
	public Ability createCharacterAction(String name, PlayingCharacter playingCharacter)
	{
		 
		Ability ability;
		
		switch(name.toLowerCase())
		{
			case "darkOrb":
				ability = new DarkOrbOffensiveSingleTargetAbility(playingCharacter);
				ability.setValues(100, 10, 2);
				break;
				
			case "soulArrow":
				ability = new SoulArrowOffensiveSingleTarget(playingCharacter);
				ability.setValues(75, 9, 3);
				break;
			
			case "soulShower":
				ability = new SoulShowerMultiTargetOffensiveAbility(playingCharacter);
				ability.setValues(80, 8, 3);
				break;
				
			case "magicShield":
				ability = new MagicShieldDefensiveSingleTargetAbility(playingCharacter);
				ability.setValues(100, 10, 2);
				break;
				
			default:
				ability = null;
		}
		
		return ability;
		
	}

	@Override
	public String[] displayAbilitiesBasedOnType()
	{
		String listOfAbilities [] = {darkOrb.getName(), soulArrow.getName(), soulShower.getName(), magicShield.getName()};
		return listOfAbilities;
	}
	
}
