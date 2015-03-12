package loyal.level.tiles;

public class AnimatedTile extends BasicTile
{
	private int[][] animationTileCoards;
	private int currentAnimationIndex;
	private long lastIterationTime;
	private int animationSwitchDelay;

	public AnimatedTile(int id, int[][] animationCoards, int tileColor, int levelColor, int animationSwitchDelay, int width, int height)
	{
		super(id, animationCoards[0][0], animationCoards[0][1], tileColor, levelColor, width, height);
		this.animationTileCoards = animationCoards;
		this.currentAnimationIndex = 0;
		this.lastIterationTime = System.currentTimeMillis();
		this.animationSwitchDelay = animationSwitchDelay;
	}
	
	public void tick()
	{
		if((System.currentTimeMillis()-lastIterationTime)>=(animationSwitchDelay))
		{
			lastIterationTime = System.currentTimeMillis();
			currentAnimationIndex = (currentAnimationIndex+1)%animationTileCoards.length;
			this.tileId = (animationTileCoards[currentAnimationIndex][0]+(animationTileCoards[currentAnimationIndex][1]*32));
		}
	}
}
