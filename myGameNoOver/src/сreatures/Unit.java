package сreatures;

import сreatures.Auxiliary.Location2D;

public abstract class Unit {
    protected String name;
    protected String typeUnit;

    protected int level;
    protected int experiencePoints;
    protected int initiative;

    protected Location2D location;

    protected int hitPoints;
    protected int maxHitPoints;

    protected int power;
    protected int dexterity;
    protected int sustainability;

    /**
     * Full constructor for abstract class Creature
     * Полный конструктор для класса существо
     * 
     * @param name             Имя
     * @param typeUnit         Тип юнита
     * @param level            Уровень
     * @param experiencePoints Очки здоровья
     * @param initiative       Инициатива (для регулирования скорости перемещения)
     * @param location         Местоположение
     * @param hitPoints        Очки здоровья
     * @param maxHitPoints     Максимальное значение очков здоровья
     * @param power            Сила
     * @param dexterity        Ловкость
     * @param sustainability   Устойчивость
     */

    public Unit(String name, String typeUnit, int level, int experiencePoints, int initiative,
            Location2D location, int hitPoints, int maxHitPoints,
            int power, int dexterity, int sustainability) {
        this.name = name;
        this.typeUnit = typeUnit;
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

    public Unit(String name, String typeUnit, int initiative, Location2D location, int maxHitPoints,
            int power, int dexterity, int sustainability) {
        this(name, typeUnit, 1, 0, initiative, location, maxHitPoints, maxHitPoints, power, dexterity,
                sustainability);
    }

    public Unit(String name, String typeUnit, int initiative, int maxHitPoints,
            int power, int dexterity, int sustainability) {
        this(name, typeUnit, 1, 0, initiative, new Location2D(), maxHitPoints, maxHitPoints, power, dexterity,
                sustainability);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Unit [name=" + name + ", typeСharacter=" + typeUnit + "]";
    }
    
    // @Override
    // public String toString() {
    // return "Unit [name=" + name + ", typeСharacter=" + typeUnit + ", level=" +
    // level
    // + ", experiencePoints=" + experiencePoints + ", initiative=" + initiative +
    // ", location=" + location
    // + ", hitPoints=" + hitPoints + ", maxHitPoints=" + maxHitPoints + ", power="
    // + power + ", dexterity="
    // + dexterity + ", sustainability=" + sustainability + "]";
    // }

    public void showInfoLabel() {
        System.out.println(String.format("%s %s %d lvl: %d HP.", typeUnit, name, level, hitPoints));
    }

}
