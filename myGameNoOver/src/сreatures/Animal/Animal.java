package сreatures.Animal;

import сreatures.Unit;
import сreatures.Auxiliary.Location2D;

public class Animal extends Unit {
    /**
     * Полный конструктор класса животное
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
     */
    public Animal(String name, String typeUnit, int level, int experiencePoints, int initiative,
            Location2D location, int hitPoints, int maxHitPoints, int power, int dexterity, int sustainability) {
        super(name, typeUnit, level, experiencePoints, initiative, location, hitPoints, maxHitPoints, power,
                dexterity,
                sustainability);
    }

    public Animal(String name, String typeUnit, int level, int experiencePoints, int initiative,
    int hitPoints, int maxHitPoints, int power, int dexterity, int sustainability){
        this(name, typeUnit, level, experiencePoints, initiative, new Location2D(), hitPoints, maxHitPoints, power,
        dexterity,
        sustainability);
    }

    @Override
    public String toString() {
        return "Animal [name=" + name + ", typeUnit=" + typeUnit + "]";
    }
    public void showInfoLabel(){
        System.out.println(String.format("%s %s %d lvl: %d HP.", typeUnit, name, level, hitPoints));
    }
}
