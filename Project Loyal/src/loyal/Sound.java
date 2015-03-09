package loyal;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound
{
	private Clip clip;
	
	public static Sound MenuMusic = new Sound("/music/TheLegend.wav");
	public static Sound VillageMusic = new Sound("/music/LittleDropofPeace.wav");
	public static Sound OverWorldMusic = new Sound("/music/Loyalty.wav");
	public static Sound VictoryMusic = new Sound("/music/VictoryFanfare.wav");

	public Sound(String fileName)
	{
		try
		{
			AudioInputStream ais = AudioSystem.getAudioInputStream(Sound.class.getResource(fileName));
			clip = AudioSystem.getClip();
			clip.open(ais);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void play()
	{
		try
		{
			if(clip != null)
			{
				new Thread()
				{
					public void run()
					{
						synchronized(clip)
						{
							clip.stop();
							clip.setFramePosition(0);
							clip.start();
						}
					}
				}.start();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void stop()
	{
		if(clip == null)
		{
			return;
		}
		clip.stop();
	}

	public void loop()
	{
		try
		{
			if(clip != null)
			{
				new Thread()
				{
					public void run()
					{
						synchronized(clip)
						{
							clip.stop();
							clip.setFramePosition(0);
							clip.loop(Clip.LOOP_CONTINUOUSLY);
						}
					}
				}.start();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public boolean isActive()
	{
		return clip.isActive();
	}
}
