package сreatures.Human.RangedCharacter;

import сreatures.Auxiliary.Location2D;
import сreatures.Human.Human;

public abstract class RangedCharacter extends Human{
    int accuracy;
    int rangeAttack;


    /** Полный конструктор класса животное
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
     * @param accuracy
     * @param rangeAttack
     */
    public RangedCharacter(String name, String typeUnit, int level, int experiencePoints, int initiative,
            Location2D location, int hitPoints, int maxHitPoints, int power, int dexterity, int sustainability,
            int accuracy, int rangeAttack){
        super(name, typeUnit, level, experiencePoints, initiative, location, hitPoints, maxHitPoints, power, dexterity, sustainability);
        this.accuracy = accuracy;
        this.rangeAttack = rangeAttack;
    }


}
