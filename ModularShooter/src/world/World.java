package world;

import java.util.ArrayList;
import java.util.List;

import modules.BasicWeapon;
import objects.Enemy;
import objects.GameObject;
import objects.Protagonist;
import util.Coordinates;

public class World {
	public static final int WIDTH = 800;
	public static final int HEIGHT = 800;
	public static final Protagonist PROTAGONIST = new Protagonist();
	public static final double SPAWN_PERCENTAGE = 5;
	public static final List<GameObject> OBJECTS = new ArrayList<>();

	private World() {
		// You shall not instantiate!
	}

	static {
		PROTAGONIST.addModule(new BasicWeapon(new Coordinates(1, 0)));
	}

	public static void trySpawning() {

		if (Math.random() <= SPAWN_PERCENTAGE / 100) {
			OBJECTS.add(Enemy.createRandomEnemy());
		}

	}

}
