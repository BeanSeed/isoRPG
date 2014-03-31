package physicalObject;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public abstract class Character extends Entity {

	//Resource types, each bit in the byte represents a type
	public static final byte NONE = 0; //No resource required to used ability, cool down based.
	public static final byte MANA = 1; //Large resource pool, regenerates based on stats.
	public static final byte FURY = 2; //Small resource pool, regenerates from dealing or receiving damage.
	public static final byte STAM = 4; //Small resource pool, regenerates at a constant rate.
	
	//Damage types, each bit in the byte represents a type
	public static final byte PHYSICAL = 1; //This is the first bit in the byte
	public static final byte MAGICAL = 2;
		
	//Entity has the coordinates for all position and appearance data
	
	public String name; 
	
	//These base variable are required for when things get buffed and stuff
	public int baseHealth;
	public int currentHealth;
	public int totalHealth;
	
	public float baseMovement;
	public float totalMovement;
	
	//Constructors for creating a character instance
	Character () {
		name = new String("Box");
		totalHealth = currentHealth = baseHealth = 1;
		totalMovement = baseMovement = 0;
		
	}
	
	Character(int x, int y, Model newModel, String newName, int newHealth) {
		super(x,y,newModel);
		name = new String(newName);
		totalHealth = currentHealth = baseHealth = newHealth;
		totalMovement = baseMovement = 0;
	}
	
	private void setMovement(float newSpeed) {
		totalMovement = baseMovement = newSpeed;
	}

	
	/*
	public int attack(Entity enemy){
		if((enemy.health -= this.attack) <= 0) {
			enemy.alive = false;
			enemy.health = 0;
		}
		stats();
		enemy.stats();
		return attack;
	}
	
	public void stats(){
		if(alive){
			System.out.println(name + ": Health " + health);
		}
		else {
			System.out.println(name + " is dead");
		}
	}
	
	public void move(Vector2 direction) {
		// the magnitude of the vector is it's speed
		// enemies move at random. some track and move towards the player.
	}
	*/
}
