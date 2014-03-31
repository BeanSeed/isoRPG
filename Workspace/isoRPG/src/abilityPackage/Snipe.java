package abilityPackage;

import physicalObject.Enemy;
import physicalObject.Player;
import physicalObject.PlayerPet;
import physicalObject.Character;


public class Snipe extends AbilityParent {
	
	public Snipe(Player newOwner)
	{
		owner = newOwner;
		update(); 
	}
	
	public int execute() {
		
		if (owner.target instanceof Enemy) {
			//The target is an enemy, so put enemy code here
		} else {
			//The target is a friendly, so put friend code here
		}
		return 12;
	}
	
	public boolean update() {
		
		resource_type = NONE;
		resource_amount = NONE;
		resource_name = new String("None");
		cd_amout = 5;
		
		lowDamage = (int)((float)owner.getDamage() * 2.5);
		topDamage = (int)((float)lowDamage * 1.5);
		damageType = PHYSICAL;
		
		name = new String("Snipe");
		description = new String ("Fire a single high velocity shot which will hit your target for " + lowDamage + '-' + topDamage + " physical damage.");
		
		return true;
	}
}
