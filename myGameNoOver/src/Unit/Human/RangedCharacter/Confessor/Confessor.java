package Unit.Human.RangedCharacter.Confessor;

import java.util.ArrayList;
import java.util.Random;

import Unit.Unit;
import Unit.Auxiliary.Location2D;
import Unit.Human.RangedCharacter.RangedCharacter;

public abstract class Confessor extends RangedCharacter {
    private int faith;
    private int maxFaith;
    private boolean flagAccumulateFaith;

    public Confessor(String name, String typeUnit,
            int level, int experiencePoints,
            int initiative,
            Location2D location,
            int hitPoints, int maxHitPoints,
            int power, int dexterity, int sustainability,
            int accuracy, int rangeAttack,
            int faith, int maxFaith) {
        super(name, typeUnit,
                level, experiencePoints,
                initiative,
                location,
                hitPoints, maxHitPoints,
                power, dexterity, sustainability,
                accuracy, rangeAttack);
        this.faith = faith;
        this.maxFaith = maxFaith;
    }

    @Override
    public void step(ArrayList<Unit> enemyUnits, ArrayList<Unit> alliedUnits) {
        if (!getIsDead()) {
            if (getFaith() < 2) {
                setFaith(getFaith() + 1);
            } else {
                attack(alliedUnits);
            }
        }
    }

    public void attack(ArrayList<Unit> alliedUnits) {
        if (isFlagAccumulateFaith() || countAlliedUnitsDied(alliedUnits) >= 3) {
            tryResurrect(alliedUnits);
        } else {
            ArrayList<Unit> listFindForHealing = new ArrayList<>(alliedUnits);
            listFindForHealing.sort((u1, u2) -> u1.getHitPoints() - u2.getHitPoints());
            getDamage(listFindForHealing.get(0));
            System.out.println("Юнит " + listFindForHealing.get(0).getName() + " был ПОДЛЕЧЕН юнитом " + this.getName());

        }
    }

    public void tryResurrect(ArrayList<Unit> alliedUnits) {
        setFlagAccumulateFaith(true);
        if (getFaith() >= getMaxFaith()) {
            resurrectUnit(alliedUnits);
            setFlagAccumulateFaith(false);
        } else {
            setFaith(getFaith() + 1);
        }

    }

    public void resurrectUnit(ArrayList<Unit> alliedUnits) {
        setFaith(0);
        Random random = new Random();
        ArrayList<Unit> listDeadUnits = createListDeadUnits(alliedUnits);
        if (!listDeadUnits.isEmpty()) {
            Unit unitToResurrect = listDeadUnits.get(random.nextInt(listDeadUnits.size()));

            unitToResurrect.setIsDead(false);
            unitToResurrect.setHitPoints(unitToResurrect.getMaxHitPoints() / 2);
            System.out.println("Юнит " + unitToResurrect.getName() + " был воскрешен с половиной здоровья.");
        } else {
            System.out.println("Нет мертвых юнитов для воскрешения.");
        }
    }

    public ArrayList<Unit> createListDeadUnits(ArrayList<Unit> alliedUnits) {
        ArrayList<Unit> listDeadUnits = new ArrayList<>();
        for (Unit unit : alliedUnits) {
            if (unit.getIsDead()) {
                listDeadUnits.add(unit);
            }
        }
        return listDeadUnits;
    }

    public int countAlliedUnitsDied(ArrayList<Unit> alliedUnits) {
        int count = 0;
        for (Unit unit : alliedUnits) {
            if (unit.getIsDead())
                count++;
        }
        return count;
    }

    @Override
    protected int calculateGetDamage() {
        return -(getPower() * (1 + getDexterity() / 100));
    }
    //
    // Getters and setters
    //

    public int getFaith() {
        return faith;
    }

    public void setFaith(int faith) {
        this.faith = faith;
    }

    public int getMaxFaith() {
        return maxFaith;
    }

    public void setMaxFaith(int maxFaith) {
        this.maxFaith = maxFaith;
    }

    public boolean isFlagAccumulateFaith() {
        return flagAccumulateFaith;
    }

    public void setFlagAccumulateFaith(boolean flagAccumulateFaith) {
        this.flagAccumulateFaith = flagAccumulateFaith;
    }
}
