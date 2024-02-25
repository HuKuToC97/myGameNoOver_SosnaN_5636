package Unit.Human.RangedCharacter.Confessor;

import Unit.Auxiliary.Location2D;
import Unit.Human.RangedCharacter.RangedCharacter;

public abstract class Confessor extends RangedCharacter {
    private int faith;

    private int maxFaith;

    public Confessor(String name, String typeUnit,
            int level, int experiencePoints,
            int initiative,
            Location2D location,
            int hitPoints, int maxHitPoints,
            int power, int dexterity, int sustainability,
            int accuracy, int rangeAttack,
            int faith, int maxFaith) {
        super(name, typeUnit,
                level, experiencePoints,
                initiative,
                location,
                hitPoints, maxHitPoints,
                power, dexterity, sustainability,
                accuracy, rangeAttack);
        this.faith = faith;
        this.maxFaith = maxFaith;
    }

    //
    // Getters and setters
    //

    public int getFaith() {
        return faith;
    }

    public void setFaith(int faith) {
        this.faith = faith;
    }

    public int getMaxFaith() {
        return maxFaith;
    }

    public void setMaxFaith(int maxFaith) {
        this.maxFaith = maxFaith;
    }
}
