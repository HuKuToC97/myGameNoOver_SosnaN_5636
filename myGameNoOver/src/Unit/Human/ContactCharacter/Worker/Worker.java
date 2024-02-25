package Unit.Human.ContactCharacter.Worker;

import java.util.ArrayList;

import Unit.Unit;
import Unit.Auxiliary.Location2D;
import Unit.Human.ContactCharacter.ContactCharacter;

public abstract class Worker extends ContactCharacter {
    private int calm;

    private int maxCalm;

    /**
     * Полный конструктор
     * 
     * @param name
     * @param typeUnit
     * @param level
     * @param experiencePoints
     * @param initiative
     * @param location
     * @param hitPoints
     * @param maxHitPoints
     * @param power
     * @param dexterity
     * @param sustainability
     * @param calm
     * @param maxCalm
     */
    public Worker(String name, String typeUnit,
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
                power, dexterity, sustainability);
        this.calm = calm;
        this.maxCalm = maxCalm;

    }

    //
    // Getters and setters
    //

    public int getCalm() {
        return calm;
    }

    public void setCalm(int calm) {
        this.calm = calm;
    }

    public int getMaxCalm() {
        return maxCalm;
    }

    public void setMaxCalm(int maxCalm) {
        this.maxCalm = maxCalm;
    }

}
