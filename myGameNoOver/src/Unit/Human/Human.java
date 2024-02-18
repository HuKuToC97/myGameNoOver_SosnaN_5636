package Unit.Human;

import Unit.Unit;
import Unit.Auxiliary.Location2D;

public abstract class Human extends Unit{

    public Human(String name, String typeUnit, int level, int experiencePoints, int initiative,
            Location2D location, int hitPoints, int maxHitPoints, int power, int dexterity, int sustainability) {
        super(name, typeUnit, level, experiencePoints, initiative, location, hitPoints, maxHitPoints, power, dexterity,
                sustainability);
    }
    
}
