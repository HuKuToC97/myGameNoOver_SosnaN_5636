package Unit.Human.ContactCharacter;

import Unit.Auxiliary.Location2D;
import Unit.Human.Human;

public abstract class ContactCharacter extends Human{


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
     */
    public ContactCharacter(String name, String typeUnit, int level, int experiencePoints, int initiative,
            Location2D location, int hitPoints, int maxHitPoints, int power, int dexterity, int sustainability) {
        super(name, typeUnit, level, experiencePoints, initiative, location, hitPoints, maxHitPoints, power, dexterity,
        sustainability);
    }
}
