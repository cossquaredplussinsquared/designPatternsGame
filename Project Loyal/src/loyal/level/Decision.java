package loyal.level;

import loyal.Loyal;

public interface Decision {

	void update();
	void sync();
	void setGame(Loyal game);
	void gameValue(int value);
}
