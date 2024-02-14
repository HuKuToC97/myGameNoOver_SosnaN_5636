package сreatures;

import сreatures.Auxiliary.Location2D;

public abstract class Human extends Unit{

    public Human(String name, String typeСharacter, int level, int experiencePoints, int initiative,
            Location2D location, int hitPoints, int maxHitPoints, int power, int dexterity, int sustainability) {
        super(name, typeСharacter, level, experiencePoints, initiative, location, hitPoints, maxHitPoints, power, dexterity,
                sustainability);
    }
    
}
