package Unit.Human.RangedCharacter.Confessor;

import Unit.Auxiliary.Location2D;

public class Monk extends Confessor {
    public Monk(String name, String typeUnit,
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
                accuracy, rangeAttack,
                faith, maxFaith);
    }

    public Monk(String name, String typeUnit,
            int level, int experiencePoints,
            int initiative,
            Location2D location,
            int maxHitPoints,
            int power, int dexterity, int sustainability,
            int accuracy, int rangeAttack,
            int maxFaith) {
        this(name, typeUnit,
                level, experiencePoints,
                initiative,
                location,
                maxHitPoints, maxHitPoints,
                power, dexterity, sustainability,
                accuracy, rangeAttack,
                maxFaith, maxFaith);
    }

    public Monk(String name, int x, int y) {
        this(name, "Monk (Монах)",
                DEFAULT_LEVEL, DEFAULT_EXPERIENCE_POINTS,
                10,
                new Location2D(x, y),
                100,
                10, 10, 10,
                100, 100,
                1000);
    }

    public Monk(String name) {
        this(name,
                0, 0);
    }

    public void prayer() {

    }

    @Override
    public void step() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'step'");
    }
}
