package сreatures;

import сreatures.Auxiliary.Location2D;

public abstract class Unit {
    private String name;
    private String typeСharacter;

    private int level;
    private int experiencePoints;
    private int initiative;

    private Location2D location;

    private int hitPoints;
    private int maxHitPoints;

    private int power;
    private int dexterity;
    private int sustainability;

    /**
     * Full constructor for abstract class Creature
     * Полный конструктор для класса существо
     * 
     * @param name           Имя
     * @param level          Уровень
     * @param initiative     Инициатива (для регулирования скорости перемещения)
     * @param location       Местоположение
     * @param hitPoints      Очки здоровья
     * @param maxHitPoints   Максимальное значение очков здоровья
     * @param power          Сила
     * @param dexterity      Ловкость
     * @param sustainability Устойчивость
     */

    public Unit(String name, String typeСharacter, int level, int experiencePoints, int initiative,
            Location2D location, int hitPoints, int maxHitPoints,
            int power, int dexterity, int sustainability) {
        this.name = name;
        this.typeСharacter = typeСharacter;
        this.level = level;
        this.experiencePoints = experiencePoints;
        this.initiative = initiative;
        this.location = location;
        this.hitPoints = hitPoints;
        this.maxHitPoints = maxHitPoints;
        this.power = power;
        this.dexterity = dexterity;
        this.sustainability = sustainability;
    }

    public Unit(String name, String typeСharacter, int initiative, Location2D location, int maxHitPoints,
            int power, int dexterity, int sustainability) {
        this(name, typeСharacter, 1, 0, initiative, location, maxHitPoints, maxHitPoints, power, dexterity,
                sustainability);
    }

    @Override
    public String toString() {
        return "Creature [name=" + name + ", typeСharacter=" + typeСharacter + ", level=" + level
                + ", experiencePoints=" + experiencePoints + ", initiative=" + initiative + ", location=" + location
                + ", hitPoints=" + hitPoints + ", maxHitPoints=" + maxHitPoints + ", power=" + power + ", dexterity="
                + dexterity + ", sustainability=" + sustainability + "]";
    }

    
}
