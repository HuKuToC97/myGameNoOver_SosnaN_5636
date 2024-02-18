package Unit.Human.ContactCharacter.Warrior;

import Unit.Auxiliary.Location2D;

public class Hunter extends Warrior{
    public Hunter(String name, String typeUnit,
            int level, int experiencePoints,
            int initiative,
            Location2D location,
            int hitPoints, int maxHitPoints,
            int power, int dexterity, int sustainability,
            int endurance, int maxEndurance) {
        super(name, typeUnit,
                level, experiencePoints,
                initiative,
                location,
                hitPoints, maxHitPoints,
                power, dexterity, sustainability,
                endurance, maxEndurance);
    }

    public Hunter(String name, String typeUnit,
            int level, int experiencePoints,
            int initiative,
            Location2D location,
            int maxHitPoints,
            int power, int dexterity, int sustainability,
            int maxEndurance) {
        this(name, typeUnit,
                level, experiencePoints,
                initiative,
                location,
                maxHitPoints, maxHitPoints,
                power, dexterity, sustainability,
                maxEndurance, maxEndurance);
    }

    public Hunter(String name) {
        this(name, "Охотник",
                1, 0,
                10,
                new Location2D(),
                100,
                10, 10, 10,
                1000);
    }

    public void catchInNet() {

    }
}
