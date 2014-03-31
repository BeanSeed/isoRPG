package abilityPackage;

import physicalObject.Player;

public abstract class AbilityParent {
	//Resource types, each bit in the byte represents a type
	public static final byte NONE = 0; //No resource required to used ability, cool down based.
	public static final byte MANA = 1; //Large resource pool, regenerates based on stats.
	public static final byte FURY = 2; //Small resource pool, regenerates from dealing or receiving damage.
	public static final byte STAM = 4; //Small resource pool, regenerates at a constant rate.
	
	//Damage types, each bit in the byte represents a type
	public static final byte PHYSICAL = 1; //This is the first bit in the byte
	public static final byte MAGICAL = 2;
	
	public Player owner; //Who owns this ability?
	String name = "Empty";
	String description = new String ("If you see this, you did something wrong.");
	
	byte resource_type; //Pick one of the four resource types listed above
	int resource_amount; 
	String resource_name = new String("None");
	
	int cd_amout;  //Please put in seconds, we will figure out this crap later.
	int cd_timer = 0; //Cooldown timer, so you can't spam the abilities
	int gcd_timer = 0; //Global cooldown timer, so you cant execute all abilities at once
	
	byte damageType;
	int lowDamage; //The least amount of damage this ability can do
	int topDamage; //The most amount of damage this ability can do
	
	boolean complete = false; //This is a flag to check if the ability executed properly
	
	public abstract int execute();
	public abstract boolean update();
	
	public void cooldown() {
		
		if (cd_timer > 0) {
			cd_timer -= 1;
		} 
		else if (gcd_timer > 0) {
			gcd_timer -= 1;
		}
	}
	
	public void drawToolTip() {
		//This will draw the tool tip for the ability. Only needs to be implemented in this class.
	}

}
