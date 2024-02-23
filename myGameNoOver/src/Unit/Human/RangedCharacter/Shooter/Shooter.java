package Unit.Human.RangedCharacter.Shooter;

import Unit.Auxiliary.Location2D;
import Unit.Human.RangedCharacter.RangedCharacter;

public abstract class Shooter extends RangedCharacter {
    private int concentration;
    private int maxConcentration;
    private int ammunition;
    private int maxAmmunition;
    private int amountShotsInStep;

    public int getConcentration() {
        return concentration;
    }

    public void setConcentration(int concentration) {
        this.concentration = concentration;
    }

    public int getMaxConcentration() {
        return maxConcentration;
    }

    public void setMaxConcentration(int maxConcentration) {
        this.maxConcentration = maxConcentration;
    }

    public int getAmmunition() {
        return ammunition;
    }

    public void setAmmunition(int ammunition) {
        this.ammunition = ammunition;
    }

    public int getMaxAmmunition() {
        return maxAmmunition;
    }

    public void setMaxAmmunition(int maxAmmunition) {
        this.maxAmmunition = maxAmmunition;
    }

    public int getAmountShotsInStep() {
        return amountShotsInStep;
    }

    public void setAmountShotsInStep(int amountShotsInStep) {
        this.amountShotsInStep = amountShotsInStep;
    }

    public Shooter(String name, String typeUnit,
            int level, int experiencePoints,
            int initiative,
            Location2D location,
            int hitPoints, int maxHitPoints,
            int power, int dexterity, int sustainability,
            int accuracy, int rangeAttack,
            int concentration, int maxConcentration,
            int ammunition, int maxAmmunition,
            int amountShotsInStep) {
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
        this.amountShotsInStep = amountShotsInStep;
    }
}
