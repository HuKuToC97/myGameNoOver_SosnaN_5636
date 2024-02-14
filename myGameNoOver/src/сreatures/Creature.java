package сreatures;

import сreatures.Auxiliary.Location;

public abstract class Creature {
    private String name;
    private int level;
    private int initiative;
 
    private Location location;

    private int hitPoints;
    private int maxHitPoints;
 
    private int power;
    private int dexterity;
    private int sustainability;

    /**
     * Full constructor for abstract class Creature
     * Полный конструктор для класса существо
     * @param name Имя
     * @param level Уровень
     * @param initiative Инициатива (для регулирования скорости перемещения)
     * @param location Местоположение
     * @param hitPoints Очки здоровья
     * @param maxHitPoints Максимальное значение очков здоровья
     * @param power Сила
     * @param dexterity Ловкость
     * @param sustainability Устойчивость
     */

    public Creature(String name, int level, int initiative, Location location, int hitPoints, int maxHitPoints,
            int power, int dexterity, int sustainability) {
        this.name = name;
        this.level = level;
        this.initiative = initiative;
        this.location = location;
        this.hitPoints = hitPoints;
        this.maxHitPoints = maxHitPoints;
        this.power = power;
        this.dexterity = dexterity;
        this.sustainability = sustainability;
    }
    
    public Creature(String name, int initiative, Location location, int hitPoints, int maxHitPoints,
            int power, int dexterity, int sustainability) {
        this(name, 1, initiative, location, hitPoints, maxHitPoints, power, dexterity, sustainability);
    }

    
    
}
