package Unit.Human.ContactCharacter.Warrior;

import Unit.Auxiliary.Location2D;
import Unit.Human.ContactCharacter.ContactCharacter;

public abstract class Warrior extends ContactCharacter{
    private int endurance;

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    private int maxEndurance;

    public int getMaxEndurance() {
        return maxEndurance;
    }

    public void setMaxEndurance(int maxEndurance) {
        this.maxEndurance = maxEndurance;
    }


    public Warrior(String name, String typeUnit, int level, int experiencePoints, int initiative,
            Location2D location, int hitPoints, int maxHitPoints, int power, int dexterity, int sustainability, int endurance, int maxEndurance) {
        super(name, typeUnit, level, experiencePoints, initiative, location, hitPoints, maxHitPoints, power, dexterity,
        sustainability);
        this.endurance = endurance;
        this.maxEndurance = maxEndurance;
    }
    
}
