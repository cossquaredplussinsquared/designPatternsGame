
package loyal.level;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import loyal.InputHandler;
import loyal.Loyal;
import loyal.Sound;
import loyal.Graphics.Screen;
import loyal.entities.Entity;
import loyal.level.tiles.Tile;

public class Level {

	private static final int PIXEL_SCALER = 8;
	public byte[] tiles;
	public int width;
	public int height;
	public List<Entity> entities = new ArrayList<Entity>();
	public Sound music;
	private String imagePath;
	private BufferedImage image;
	private int id;
	private Map<String, Decision> decisionMap = new HashMap<String, Decision>();
	public Decision currentDecision;
	public boolean hasBeenPlayed = false;
	private int defaultY;
	private int defaultX;
	private ArrayList<int[]> exitValuesArray;

	public Level(int id, String imagePath, Sound music) {
		if (imagePath != null) {
			this.imagePath = imagePath;
			this.loadLevelFromFile();
			this.id = id;
			Loyal.levels[id] = this;
			this.music = music;
		} else {
			this.width = 64;
			this.height = 64;
			tiles = new byte[width * height];
			this.generateLevel();
		}
	}

	private void loadLevelFromFile() {
		try {
			this.image = ImageIO.read(Level.class.getResource(this.imagePath));
			this.width = image.getWidth();
			this.height = image.getHeight();
			tiles = new byte[width * height];
			this.loadTiles();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private enum ExitValueEnum {
		NEW_LEVEL_ID(0), X_MIN(1), X_MAX(2), Y_MIN(3), Y_MAX(4);

		public int index;

		private ExitValueEnum(int index) {
			this.index = index;
		}
	}

	private void loadTiles() {
		int[] tileColors = this.image.getRGB(0, 0, width, height, null, 0,
				width);
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tileCheck: for (Tile t : Tile.tiles) {
					if (t != null
							&& t.getLevelColor() == tileColors[x + y * width]
							&& this.tiles[x + y * width] == 0) {
						byte id = t.getId();
						for (int i = 0; i < t.getHeight(); i++) {
							for (int j = 0; j < t.getWidth(); j++) {
								if ((x + j) < this.width
										&& (y + i) < this.height) {
									this.tiles[(x + j) + (y + i) * width] = id;
									id++;
								}
							}
						}
						break tileCheck;
					}
				}
			}
		}
	}

	private void saveLevelToFile() {
		try {
			ImageIO.write(image, "png",
					new File(Level.class.getResource(this.imagePath).getFile()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void alterTile(int x, int y, Tile newTile) {
		this.tiles[x + y * width] = newTile.getId();
		image.setRGB(x, y, newTile.getLevelColor());
	}

	private void generateLevel() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if (x * y % 10 < 7) {
					tiles[x + y * width] = Tile.GRASS.getId();
				} else {
					tiles[x + y * width] = Tile.STONE.getId();
				}
			}
		}
	}

	public void tick() {
		hasBeenPlayed = true;
		for (Entity e : entities) {
			e.tick();
		}
		for (Tile t : Tile.tiles) {
			if (t == null) {
				break;
			}
			t.tick();
		}
	}

	public String inputRun(InputHandler input) {
		String inputReturn = entities.get(0).inputRun(input);
		currentDecision = decisionMap.get(inputReturn);
		if (currentDecision != null)
			currentDecision.update();

		return inputReturn;
	}

	public void renderTiles(Screen screen, int xOffset, int yOffset) {
		if (xOffset < 0) {
			xOffset = 0;
		}
		if (xOffset > ((width << 3) - screen.width)) {
			xOffset = ((width << 3) - screen.width);
		}
		if (yOffset < 0) {
			yOffset = 0;
		}
		if (yOffset > ((height << 3) - screen.height)) {
			yOffset = ((height << 3) - screen.height);
		}

		screen.setOffset(xOffset, yOffset);

		for (int y = (yOffset >> 3); y < (yOffset + screen.height >> 3) + 1; y++) {
			for (int x = (xOffset >> 3); x < (xOffset + screen.width >> 3) + 1; x++) {
				getTile(x, y).render(screen, this, x << 3, y << 3);
			}
		}
	}

	public void renderEntities(Screen screen) {
		for (Entity e : entities) {
			e.render(screen);
		}
	}

	public Tile getTile(int x, int y) {
		if (0 > x || x >= width || 0 > y || y >= height) {
			return Tile.VOID;
		}
		return Tile.tiles[tiles[x + y * width]];
	}

	public void addEntity(Entity entity) {
		this.entities.add(entity);
	}

	public void addEntity(int pos, Entity entity) {
		entity.setX(defaultX);
		entity.setY(defaultY);
		this.entities.add(pos, entity);
	}

	public void removeEntity(Entity entity) {
		this.entities.remove(entity);
	}

	public void removeEntity(int pos) {
		this.entities.remove(pos);
	}

	public Entity getEntity(int pos) {
		return entities.get(pos);
	}

	public int getEntitySize() {
		return entities.size();
	}

	public void newLevel() {

			currentDecision.update();

	}

	public int newLevelIdentifier(int x, int y) {
		int levelID = 0;
		for (int i = 0; i < exitValuesArray.size(); i++) {
			int[] exitCheckingArray = exitValuesArray.get(i);
			if ((x >= exitCheckingArray[ExitValueEnum.X_MIN.index]
					* PIXEL_SCALER && x <= exitCheckingArray[ExitValueEnum.X_MAX.index]
					* PIXEL_SCALER)
					&& (y >= exitCheckingArray[ExitValueEnum.Y_MIN.index]
							* PIXEL_SCALER && y <= exitCheckingArray[ExitValueEnum.Y_MAX.index]
							* PIXEL_SCALER)) {
				levelID = exitCheckingArray[ExitValueEnum.NEW_LEVEL_ID.index];
			}
		}
		return levelID;
	}

	public int getId() {
		return this.id;
	}

	public void setPlayerDefaultX(int X) {
		defaultX = X;
	}

	public void setPlayerDefaultY(int Y) {
		defaultY = Y;
	}

	public void setExitValues(ArrayList<int[]> exitValuesArray) {
		this.exitValuesArray = exitValuesArray;
	}

	public void addExitValueArray(int[] exitValueArray) {
		this.exitValuesArray.add(exitValueArray);
	}

}
