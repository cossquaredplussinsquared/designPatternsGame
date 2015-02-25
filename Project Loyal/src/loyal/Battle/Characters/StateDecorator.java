package loyal.Battle.Characters;

public interface StateDecorator extends State {
	
	public State undecorate();
	void unSetModified();
	void setModified();

}
