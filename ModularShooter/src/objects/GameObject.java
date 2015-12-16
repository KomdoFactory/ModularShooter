package objects;

import util.Coordinates;
import util.Velocity;
import world.World;

public abstract class GameObject {

	public Coordinates coordinates;
	protected Velocity velocity;
	protected int size;

	protected Velocity randomVelocity() {
		return new Velocity((Math.random() - 0.5) * 2, (Math.random() - 0.5) * 2);
	}

	public boolean hitTest(GameObject other) {

		if (other != this) {
			if (other.coordinates.xCoordinate >= this.coordinates.xCoordinate
					&& other.coordinates.xCoordinate <= this.coordinates.xCoordinate + size
					&& other.coordinates.yCoordinate >= this.coordinates.yCoordinate
					&& other.coordinates.yCoordinate <= this.coordinates.yCoordinate + size) {
				return true;
			}
		}
		return false;
	}
	
	public void hit(){
		World.removeObject(this);
	}

}
