package Unit.Human.RangedCharacter.Shooter;

import Unit.Auxiliary.Location2D;
import Unit.Human.RangedCharacter.RangedCharacter;

public abstract class Shooter extends RangedCharacter {
    protected int concentration;
    protected int maxConcentration;
    protected int ammunition;
    protected int maxAmmunition;

    public Shooter(String name, String typeUnit,
            int level, int experiencePoints,
            int initiative,
            Location2D location,
            int hitPoints, int maxHitPoints,
            int power, int dexterity, int sustainability,
            int accuracy, int rangeAttack,
            int concentration, int maxConcentration,
            int ammunition, int maxAmmunition) {
        super(name, typeUnit,
                level, experiencePoints,
                initiative,
                location,
                hitPoints, maxHitPoints,
                power, dexterity, sustainability,
                accuracy, rangeAttack);
        this.concentration = concentration;
        this.maxConcentration = maxConcentration;
        this.ammunition = ammunition;
        this.maxAmmunition = maxAmmunition;
    }
}
