package physicalObject;


import abilityPackage.AbilityParent;
import com.badlogic.gdx.Input.Keys;

public class Player extends Character{
	
	private AbilityParent[] ability = new AbilityParent[4];
	public PlayerPet pet = null;
	//name is from Character class
	//baseHealth, currentHealth and totalHealth is from character class
	//baseMovement, totalMovement is from character class
	private int level = 1;
	private int currentExp = 0;
	private int levelExp = 100;
	private int totalExp = 0;
	
	private byte resourceType = NONE;
	private int baseResource;
	private int currentResource;
	private int totalResource;
	private float baseRegen;
	
	private int baseHeal = 1;
	
	private float baseCritRate = 5.0f;
	private float baseCritMult = 1.1f;

	private int baseStr = 3;
	private int baseInt = 3;
	private int baseAgi = 3;
	
	private int baseDamage = 20;
	private float range = 300f;
	
	public Character target; //This is what your target is. Can be enemy or ally.
	
    public Player() {
    	name = new String("Unknown");
    	baseMovement = 2;
    }
    
    public float getDamage() {
    	
    	return (float)(baseDamage + baseStr + baseInt + baseAgi);
    }
	
	
	
	/*
	public Player() {
		health = 10;
		attack = 10;
		mana = 10;
		name = "Player";
	}
	public void input(int keycode, Enemy enemy) {
		if(keycode == Keys.SPACE) {
			attack(enemy);
		}
	}
	*/
}
