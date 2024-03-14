package Unit.Human.RangedCharacter.Mage;

import java.util.ArrayList;
import java.util.Random;

import Unit.Unit;
import Unit.Auxiliary.Location2D;
import Unit.Human.RangedCharacter.RangedCharacter;

public abstract class Mage extends RangedCharacter {
    private int mana;
    private int maxMana;
    private boolean flagAccumulateMana;

    public Mage(String name, String typeUnit, int level, int experiencePoints, int initiative,
            Location2D location, int hitPoints, int maxHitPoints, int power, int dexterity, int sustainability,
            int accuracy, int rangeAttack,
            int mana, int maxMana) {
        super(name, typeUnit, level, experiencePoints, initiative, location, hitPoints, maxHitPoints, power, dexterity,
                sustainability, accuracy, rangeAttack);
        this.mana = mana;
        this.maxMana = maxMana;

    }

    @Override
    public void step(ArrayList<Unit> enemyUnits, ArrayList<Unit> alliedUnits) {
        if (!getIsDead()) {
            if (getMana() < 2) {
                setMana(getMana() + 1);
            } else {
                attack(alliedUnits);
            }
        }
    }

    public void attack(ArrayList<Unit> alliedUnits) {
        if (isFlagAccumulateMana() || countAlliedUnitsDied(alliedUnits) >= 3) {
            tryResurrect(alliedUnits);
        } else {
            ArrayList<Unit> listFindForHealing = new ArrayList<>(alliedUnits);
            listFindForHealing.sort((u1, u2) -> u1.getHitPoints() - u2.getHitPoints());
            getDamage(listFindForHealing.get(0));
            System.out
                    .println("Юнит " + listFindForHealing.get(0).getName() + " был ПОДЛЕЧЕН юнитом " + this.getName());

        }
    }

    public void tryResurrect(ArrayList<Unit> alliedUnits) {
        setFlagAccumulateMana(true);
        if (getMana() >= getMaxMana()) {
            resurrectUnit(alliedUnits);
            setFlagAccumulateMana(false);
        } else {
            setMana(getMana() + 1);
        }

    }

    public void resurrectUnit(ArrayList<Unit> alliedUnits) {
        setMana(0);
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

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public boolean isFlagAccumulateMana() {
        return flagAccumulateMana;
    }

    public void setFlagAccumulateMana(boolean flagAccumulateMana) {
        this.flagAccumulateMana = flagAccumulateMana;
    }
}
