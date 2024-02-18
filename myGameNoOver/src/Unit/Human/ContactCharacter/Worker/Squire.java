package Unit.Human.ContactCharacter.Worker;

import Unit.Auxiliary.Location2D;

public class Squire extends Worker {
    private int fatigue;

    public int getFatigue() {
        return fatigue;
    }

    public void setFatigue(int fatigue) {
        this.fatigue = fatigue;
    }

    public Squire(String name, String typeUnit,
            int level, int experiencePoints,
            int initiative,
            Location2D location,
            int hitPoints, int maxHitPoints,
            int power, int dexterity, int sustainability,
            int calm, int maxCalm,
            int fatigue) {
        super(name, typeUnit,
                level, experiencePoints,
                initiative,
                location,
                hitPoints, maxHitPoints,
                power, dexterity, sustainability,
                calm, maxCalm);
        this.fatigue = fatigue;
    }

    public Squire(String name, String typeUnit,
            int level, int experiencePoints,
            int initiative,
            Location2D location,
            int maxHitPoints,
            int power, int dexterity, int sustainability,
            int maxCalm,
            int fatigue) {
        this(name, typeUnit,
                level, experiencePoints,
                initiative,
                location,
                maxHitPoints, maxHitPoints,
                power, dexterity, sustainability,
                maxCalm, maxCalm, fatigue);
    }

    public Squire(String name) {
        this(name, "Оруженосец",
                1, 0,
                10,
                new Location2D(),
                100,
                10, 10, 10,
                1000,
                0);
    }

    public void bringAmmunation() {
        initiative = initiative * (1 - (fatigue / 100));
        fatigue = fatigue--;
    };
}
