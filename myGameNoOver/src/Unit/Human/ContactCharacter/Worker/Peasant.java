package Unit.Human.ContactCharacter.Worker;

import java.util.ArrayList;

import Unit.Unit;
import Unit.Auxiliary.Location2D;

public class Peasant extends Worker {

    public Peasant(String name, String typeUnit,
            int level, int experiencePoints,
            int initiative,
            Location2D location,
            int hitPoints, int maxHitPoints,
            int power, int dexterity, int sustainability,
            int calm, int maxCalm) {
        super(name, typeUnit,
                level, experiencePoints,
                initiative,
                location,
                hitPoints, maxHitPoints,
                power, dexterity, sustainability,
                calm, maxCalm);
    }

    public Peasant(String name, String typeUnit,
            int level, int experiencePoints,
            int initiative,
            Location2D location,
            int maxHitPoints,
            int power, int dexterity, int sustainability,
            int maxCalm) {
        this(name, typeUnit,
                level, experiencePoints,
                initiative,
                location,
                maxHitPoints, maxHitPoints,
                power, dexterity, sustainability,
                maxCalm, maxCalm);
    }

    public Peasant(String name, int x, int y) {
        this(name, "Peasant",
                DEFAULT_LEVEL, DEFAULT_EXPERIENCE_POINTS,
                0,
                new Location2D(x, y),
                100,
                10, 10, 10,
                1000);
    }

    public Peasant(String name) {
        this(name,
                0, 0);
    }

    @Override
    public void step(ArrayList<Unit> enemyUnits, ArrayList<Unit> alliedUnits) {
        if (!getIsDead()) {
            setStatusAction(getTypeUnit() + " " + getName() + " - просто существует, он же крестьянин");

        }
    }
}
