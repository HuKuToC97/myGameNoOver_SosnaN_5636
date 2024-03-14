package Unit.Human.RangedCharacter.Mage;

import Unit.Auxiliary.Location2D;

public class Witch extends Mage {
    public Witch(String name, String typeUnit,
            int level, int experiencePoints,
            int initiative,
            Location2D location,
            int hitPoints, int maxHitPoints,
            int power, int dexterity, int sustainability,
            int accuracy, int rangeAttack,
            int mana, int maxMana) {
        super(name, typeUnit,
                level, experiencePoints,
                initiative,
                location,
                hitPoints, maxHitPoints,
                power, dexterity, sustainability,
                accuracy, rangeAttack,
                mana, maxMana);
    }

    public Witch(String name, String typeUnit,
            int level, int experiencePoints,
            int initiative,
            Location2D location,
            int maxHitPoints,
            int power, int dexterity, int sustainability,
            int accuracy, int rangeAttack,
            int maxMana) {
        this(name, typeUnit,
                level, experiencePoints,
                initiative,
                location,
                maxHitPoints, maxHitPoints,
                power, dexterity, sustainability,
                accuracy, rangeAttack,
                maxMana, maxMana);
    }

    public Witch(String name, int x, int y) {
        this(name, "Witch",
                DEFAULT_LEVEL, DEFAULT_EXPERIENCE_POINTS,
                1,
                new Location2D(x, y),
                100,
                10, 10, 10,
                100, 100,
                10);
    }

    public Witch(String name) {
        this(name,
                0, 0);
    }

    public void conjure() {

    }

}
