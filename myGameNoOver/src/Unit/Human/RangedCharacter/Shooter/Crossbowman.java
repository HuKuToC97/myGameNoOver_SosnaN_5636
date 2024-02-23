package Unit.Human.RangedCharacter.Shooter;

import java.util.ArrayList;

import Unit.Unit;
import Unit.Auxiliary.Location2D;

public class Crossbowman extends Shooter {
    public Crossbowman(String name, String typeUnit,
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

    public Crossbowman(String name, String typeUnit,
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

    public Crossbowman(String name, int x, int y) {
        this(name, "Crossbowman (Арбалетчик)",
                1, 0,
                10,
                new Location2D(x, y),
                100,
                10, 10, 10,
                100, 100,
                100,
                0, 100,
                1);
    }

    public Crossbowman(String name) {
        this(name,
                0, 0);
    }

    public void poisonArrow() {

    }

    @Override
    public void step(ArrayList<Unit> list) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'step'");
    }
}
