package Unit.Human.ContactCharacter.Warrior;

import Unit.Auxiliary.Location2D;
import Unit.Human.ContactCharacter.ContactCharacter;

public abstract class Warrior extends ContactCharacter{
    protected int endurance;
    protected int maxEndurance;


    public Warrior(String name, String typeUnit, int level, int experiencePoints, int initiative,
            Location2D location, int hitPoints, int maxHitPoints, int power, int dexterity, int sustainability, int endurance, int maxEndurance) {
        super(name, typeUnit, level, experiencePoints, initiative, location, hitPoints, maxHitPoints, power, dexterity,
        sustainability);
        this.endurance = endurance;
        this.maxEndurance = maxEndurance;
    }
    
}
