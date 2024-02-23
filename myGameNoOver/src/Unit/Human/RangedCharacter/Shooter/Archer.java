package Unit.Human.RangedCharacter.Shooter;

import Unit.Auxiliary.Location2D;

public class Archer extends Shooter {
    public Archer(String name, String typeUnit,
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
                accuracy, rangeAttack,
                concentration, maxConcentration,
                ammunition, maxAmmunition,
                amountShotsInStep);
    }

    public Archer(String name, String typeUnit,
            int level, int experiencePoints,
            int initiative,
            Location2D location,
            int maxHitPoints,
            int power, int dexterity, int sustainability,
            int accuracy, int rangeAttack,
            int maxConcentration,
            int ammunition, int maxAmmunition,
            int amountShotsInStep) {
        this(name, typeUnit,
                level, experiencePoints,
                initiative,
                location,
                maxHitPoints, maxHitPoints,
                power, dexterity, sustainability,
                accuracy, rangeAttack,
                maxConcentration, maxConcentration,
                ammunition, maxAmmunition,
                amountShotsInStep);
    }

    public Archer(String name, int x, int y) {
        this(name, "Archer (Лучник)",
                1, 0,
                10,
                new Location2D(x, y),
                100,
                10, 10, 10,
                100, 100,
                100,
                0, 100,
                5);
    }

    public Archer(String name) {
        this(name,
                0, 0);
    }


    @Override
    public void step() {
        if (!isDead) {
            if (getAmmunition() > 0) {
                callSquire();
            }
        }
    }
    public void callSquire(){};

}
