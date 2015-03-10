package loyal.Battle.Characters;

public interface StateDecorator extends State {
	
	public State undecorate(String name);
	void unSetModified();
	void setModified();
}
