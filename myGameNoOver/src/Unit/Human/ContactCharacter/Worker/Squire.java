package Unit.Human.ContactCharacter.Worker;

import java.util.ArrayList;

import Unit.Unit;
import Unit.Auxiliary.Location2D;

public class Squire extends Worker {
    private int fatigue;
    private boolean flagOpportunityGiveAmmo;

    private Squire(String name, String typeUnit,
            int level, int experiencePoints,
            int initiative,
            Location2D location,
            int hitPoints, int maxHitPoints,
            int power, int dexterity, int sustainability,
            int calm, int maxCalm,
            int fatigue,
            boolean flagGiveAmmo) {
        super(name, typeUnit,
                level, experiencePoints,
                initiative,
                location,
                hitPoints, maxHitPoints,
                power, dexterity, sustainability,
                calm, maxCalm);
        this.fatigue = fatigue;
        this.flagOpportunityGiveAmmo = flagGiveAmmo;
    }

    private Squire(String name, String typeUnit,
            int level, int experiencePoints,
            int initiative,
            Location2D location,
            int maxHitPoints,
            int power, int dexterity, int sustainability,
            int maxCalm,
            int fatigue,
            boolean flagGiveAmmo) {
        this(name, typeUnit,
                level, experiencePoints,
                initiative,
                location,
                maxHitPoints, maxHitPoints,
                power, dexterity, sustainability,
                maxCalm, maxCalm, fatigue, flagGiveAmmo);
    }

    public Squire(String name, int x, int y) {
        this(name, "Squire",
                DEFAULT_LEVEL, DEFAULT_EXPERIENCE_POINTS,
                0,
                new Location2D(x, y),
                100,
                10, 10, 10,
                1000,
                0,
                false);
    }

    public Squire(String name) {
        this(name,
                0, 0);
    }

    @Override
    public void step(ArrayList<Unit> enemyUnits, ArrayList<Unit> alliedUnits) {
        if (!getIsDead()) {
            setFlagOpportunityGiveAmmo(true);
            setStatusAction(getTypeUnit() + " " + getName() + "- опять носил кому-то стрелы");
        }
    }

    //
    // Getters and setters
    //
    public int getFatigue() {
        return fatigue;
    }

    public void setFatigue(int fatigue) {
        this.fatigue = fatigue;
    }

    public boolean isFlagOpportunityGiveAmmo() {
        return flagOpportunityGiveAmmo;
    }

    public void setFlagOpportunityGiveAmmo(boolean flagGiveAmmo) {
        this.flagOpportunityGiveAmmo = flagGiveAmmo;
    }
}
