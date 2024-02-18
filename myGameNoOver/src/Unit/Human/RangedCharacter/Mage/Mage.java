package Unit.Human.RangedCharacter.Mage;

import Unit.Auxiliary.Location2D;
import Unit.Human.RangedCharacter.RangedCharacter;

public abstract class Mage extends RangedCharacter {
    protected int mana;
    protected int maxMana;

    public Mage(String name, String typeUnit, int level, int experiencePoints, int initiative,
            Location2D location, int hitPoints, int maxHitPoints, int power, int dexterity, int sustainability,
            int accuracy, int rangeAttack,
            int mana, int maxMana) {
        super(name, typeUnit, level, experiencePoints, initiative, location, hitPoints, maxHitPoints, power, dexterity,
                sustainability, accuracy, rangeAttack);
        this.mana = mana;
        this.maxMana = maxMana;

    }
}
