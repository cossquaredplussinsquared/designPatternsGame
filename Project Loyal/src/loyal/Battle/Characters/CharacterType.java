package loyal.Battle.Characters;

public enum CharacterType
{
	WARRIOR("Warrior"), WIZARD("Wizard"), CLERIC("Cleric"), HUNTER("Hunter");
	
	private String charType;
	
	private CharacterType(String type)
	{
		this.charType = type;
	}
	
	public String toString()
	{
		return this.charType;
	}
	
	public String getCharType()
	{
		return this.charType;
	}
}
