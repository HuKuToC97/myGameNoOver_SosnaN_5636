package сreatures;

import сreatures.Auxiliary.Location2D;

public class Animal extends Unit{
    /**
     * Полный конструктор класса животное
     * @param name
     * @param typeСharacter
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
    public Animal(String name, String typeСharacter, int level, int experiencePoints, int initiative,
            Location2D location, int hitPoints, int maxHitPoints, int power, int dexterity, int sustainability) {
        super(name, typeСharacter, level, experiencePoints, initiative, location, hitPoints, maxHitPoints, power, dexterity,
                sustainability);
    }

    @Override
    public String toString() {
        return "Animal []";
    }

    
}
