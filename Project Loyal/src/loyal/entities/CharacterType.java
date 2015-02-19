package loyal.entities;

public enum CharacterType
{
	WARRIOR("Warrior"), WIZZARD("Wizzard"), CLERIC("Cleric"), HUNTER("Hunter");
	
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
