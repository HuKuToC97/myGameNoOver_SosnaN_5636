package Unit;

import Unit.Auxiliary.Location2D;

public abstract class Unit {
    protected Status status;

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
    public Unit(Status status, String name, String typeUnit, int level, int experiencePoints, int initiative,
            Location2D location, int hitPoints, int maxHitPoints, int power, int dexterity, int sustainability) {
        this.status = status;
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

    public Unit(String name, String typeUnit,
            int level, int experiencePoints,
            int initiative,
            Location2D location,
            int hitPoints, int maxHitPoints,
            int power, int dexterity, int sustainability) {
                this(Status.ALIVE, name, typeUnit,
                1, 0,
                initiative,
                location,
                maxHitPoints, maxHitPoints,
                power, dexterity, sustainability);
    }

    public Unit(String name, String typeUnit,
            int initiative,
            Location2D location,
            int maxHitPoints,
            int power, int dexterity, int sustainability) {
        this(Status.ALIVE, name, typeUnit,
                1, 0,
                initiative,
                location,
                maxHitPoints, maxHitPoints,
                power, dexterity, sustainability);
    }

    public Unit(String name, String typeUnit, int initiative, int maxHitPoints,
            int power, int dexterity, int sustainability) {
        this(Status.ALIVE, name, typeUnit, 1, 0, initiative, new Location2D(), maxHitPoints, maxHitPoints, power, dexterity,
                sustainability);
    }

    @Override
    public String toString() {
        return typeUnit + " " + name;
    }

    public void showInfoLabel() {
        System.out.println(String.format("'%s %s' lvl %d, %d HP", typeUnit, name, level, hitPoints));
    }

    public void getDamage(Unit unit) {
        int amountDamage = power;
        unit.takeDamage(amountDamage);
    }

    public void takeDamage(int amountDamage) {
        hitPoints = hitPoints - (amountDamage * (sustainability / 100));
        sustainability = sustainability - 10;
        if (hitPoints > maxHitPoints)
            hitPoints = maxHitPoints;

        if (sustainability < 0)
            sustainability = 0;

        if (hitPoints < 0)
            dead();
    }

    public void dead() {
        status = Status.DEAD;
        System.out.println(this + "- умер");
    }

    // Getters and setters
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeUnit() {
        return typeUnit;
    }

    public void setTypeUnit(String typeUnit) {
        this.typeUnit = typeUnit;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public Location2D getLocation() {
        return location;
    }

    public void setLocation(Location2D location) {
        this.location = location;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getMaxHitPoints() {
        return maxHitPoints;
    }

    public void setMaxHitPoints(int maxHitPoints) {
        this.maxHitPoints = maxHitPoints;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getSustainability() {
        return sustainability;
    }

    public void setSustainability(int sustainability) {
        this.sustainability = sustainability;
    }
}
