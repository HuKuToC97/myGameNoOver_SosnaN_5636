package Unit.Human.RangedCharacter.Shooter;

import java.util.ArrayList;

import Unit.Unit;
import Unit.Auxiliary.Location2D;

public class Sniper extends Shooter {
    public Sniper(String name, String typeUnit,
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

    public Sniper(String name, String typeUnit,
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

    public Sniper(String name, int x, int y) {
        this(name, "Sniper (Снайпер)",
                1, 0,
                3,
                new Location2D(x, y),
                100,
                10, 10, 10,
                100, 100,
                100,
                10, 100,
                3);
    }

    public Sniper(String name) {
        this(name,
                0, 0);
    }

    public void shotToFly() {

    }

    @Override
    public void step(ArrayList<Unit> list) {
        attack(list);
    }
}
