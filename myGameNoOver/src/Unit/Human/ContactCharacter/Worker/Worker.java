package Unit.Human.ContactCharacter.Worker;

import Unit.Auxiliary.Location2D;
import Unit.Human.ContactCharacter.ContactCharacter;

public abstract class Worker extends ContactCharacter{
    protected int calm;
    protected int maxCalm;
    


    /** Полный конструктор
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
    public Worker(String name, String typeUnit, int level, int experiencePoints, int initiative,
            Location2D location, int hitPoints, int maxHitPoints, int power, int dexterity, int sustainability, int calm, int maxCalm) {
        super(name, typeUnit, level, experiencePoints, initiative, location, hitPoints, maxHitPoints, power, dexterity,
        sustainability);
        this.calm = calm;
        this.maxCalm = maxCalm;

    }
}