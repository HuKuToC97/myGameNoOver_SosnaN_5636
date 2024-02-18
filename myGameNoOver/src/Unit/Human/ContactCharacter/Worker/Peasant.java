package Unit.Human.ContactCharacter.Worker;

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
        this(name, "Крестьянин",
                1, 0,
                10,
                new Location2D(x, y),
                100,
                10, 10, 10,
                1000);
    }

    public Peasant(String name) {
        this(name, "Крестьянин",
                1, 0,
                10,
                new Location2D(),
                100,
                10, 10, 10,
                1000);
    }

    public void work() {
        if (calm < maxCalm) {
            calm++;
        } else {
            calm = maxCalm;
        }
    }

}
