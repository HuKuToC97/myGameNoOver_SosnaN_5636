package Unit;

import java.util.ArrayList;

import Unit.Auxiliary.Location2D;

public abstract class Unit implements UnitInterface {
    private boolean isDead;

    private String name;
    private String typeUnit;

    private int level;
    private int experiencePoints;
    private int initiative;

    private Location2D location;

    private int hitPoints;
    private int maxHitPoints;

    private int power;
    private int dexterity;
    private int sustainability;

    // Определяем константы для удобства чтения кода
    protected static final int DEFAULT_LEVEL = 1;
    protected static final int DEFAULT_EXPERIENCE_POINTS = 0;

    /**
     * Полный конструктор для класса Unit
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
    public Unit(boolean isDead,
            String name, String typeUnit,
            int level, int experiencePoints,
            int initiative,
            Location2D location,
            int hitPoints, int maxHitPoints,
            int power, int dexterity, int sustainability) {
        this.isDead = isDead;
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
        this(false, name, typeUnit,
                DEFAULT_LEVEL, DEFAULT_EXPERIENCE_POINTS,
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
        this(false, name, typeUnit,
                DEFAULT_LEVEL, DEFAULT_EXPERIENCE_POINTS,
                initiative,
                location,
                maxHitPoints, maxHitPoints,
                power, dexterity, sustainability);
    }

    public Unit(String name, String typeUnit,
            int initiative,
            int maxHitPoints,
            int power, int dexterity, int sustainability) {
        this(false,
                name, typeUnit,
                DEFAULT_LEVEL, DEFAULT_EXPERIENCE_POINTS,
                initiative,
                new Location2D(),
                maxHitPoints, maxHitPoints,
                power, dexterity, sustainability);
    }

    @Override
    public String toString() {
        return typeUnit + " " + name;
    }

    public void showInfoLabel() {
        System.out.println(String.format("'%s %s' lvl %d, %d HP", typeUnit, name, level, hitPoints));
    }

    public void infoForSeminarSecond() {
        System.out.println(String.format("'%s %s' %d HP, isDead: %b", typeUnit, name, hitPoints, isDead));
    }

    protected void getDamage(Unit unit) {
        int amountDamage = calculateGetDamage();
        unit.takeDamage(amountDamage);
    }

    private int calculateGetDamage() {
        return power * (1 + dexterity / 100);
    }

    public void takeDamage(int amountGetDamage) {
        int tempCalculateTakeDamage = calculateTakeDamage(amountGetDamage);
        System.out.println(String.format("%s получает %d урона", this, tempCalculateTakeDamage));
        hitPoints = hitPoints - tempCalculateTakeDamage;
        sustainability = sustainability - 1;
        if (hitPoints > maxHitPoints)
            hitPoints = maxHitPoints;

        if (sustainability < 0)
            sustainability = 0;

        if (hitPoints < 0)
            dead();
    }

    private int calculateTakeDamage(int amountDamage) {
        return (amountDamage * (1 - (sustainability / 100)));
    }

    public void dead() {
        hitPoints = 0;
        isDead = true;
        System.out.println(this + "- пал в неравном бою");
    }

    public Unit findNearestEnemy(ArrayList<Unit> units) {
        Unit nearestEnemy = null;
        double minDistance = Double.MAX_VALUE;

        for (Unit unit : units) {
            if (unit != this && unit.getIsDead() == false) {
                double distance = this.location.calculateDistance(unit.getLocation());
                if (distance < minDistance) {
                    minDistance = distance;
                    nearestEnemy = unit;
                }
            }
        }

        return nearestEnemy;
    }

    //
    // Getters and setters
    //
    public boolean getIsDead() {
        return isDead;
    }

    public void setIsDead(boolean isDead) {
        this.isDead = isDead;
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
