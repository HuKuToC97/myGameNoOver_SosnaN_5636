package Unit.Human.RangedCharacter.Shooter;

import java.util.ArrayList;

import Unit.Unit;
import Unit.Auxiliary.Location2D;
import Unit.Human.ContactCharacter.Worker.Squire;
import Unit.Human.RangedCharacter.RangedCharacter;

public abstract class Shooter extends RangedCharacter {
    private int concentration;
    private int maxConcentration;
    private int ammunition;
    private int maxAmmunition;
    private int amountShotsInStep;

    public Shooter(String name, String typeUnit,
            int level, int experiencePoints,
            int initiative,
            Location2D location,
            int hitPoints, int maxHitPoints,
            int power, int dexterity, int sustainability,
            int accuracy, int rangeAttack,
            int concentration, int maxConcentration,
            int ammunition, int maxAmmunition,
            int amountShotsInStep) {
        super(name, typeUnit,
                level, experiencePoints,
                initiative,
                location,
                hitPoints, maxHitPoints,
                power, dexterity, sustainability,
                accuracy, rangeAttack);
        this.concentration = concentration;
        this.maxConcentration = maxConcentration;
        this.ammunition = ammunition;
        this.maxAmmunition = maxAmmunition;
        this.amountShotsInStep = amountShotsInStep;
    }

    @Override
    protected void getDamage(Unit unit) {
        ammunition--;
        int amountDamage = calculateGetDamage();
        System.out.println(String.format("%s атакует %s", this, unit));
        unit.takeDamage(amountDamage);
    }

    @Override
    protected int calculateGetDamage() {
        return getPower() * (1 + getDexterity() / 100);
    }

    protected void attack(ArrayList<Unit> enemyUnits, ArrayList<Unit> alliedUnits) {
        if ((!getIsDead())) {
            if (getAmmunition() <= 0) {
                callSquire(alliedUnits);
            } else {
                int countShots = amountShotsInStep;
                while (checkGotAmmunation(alliedUnits) && countShots > 0) {
                    Unit nearestEnemy = findNearestEnemy(enemyUnits);
                    if (nearestEnemy == null) {
                        break; // Выходим из цикла, если врагов больше нет
                    }
                    getDamage(nearestEnemy);
                    countShots--;
                }
            }
        }
    }

    protected void callSquire(ArrayList<Unit> alliedUnits) {
        System.out.println(String.format("У %s нечем атаковать, нужен оруженосец", this));
        for (Unit unit : alliedUnits) {
            if (unit.getTypeUnit().equals("Squire")) {
                ((Squire)unit).setFlagOpportunityGiveAmmo(false);
                setAmmunition(getMaxAmmunition()/3);
                System.out.println(getName() + "(у) - теперь есть чем стрелять, стасибо юниту "+ unit.getTypeUnit() +" " + unit.getName());
                break;
            }
        }

    };

    private boolean checkGotAmmunation(ArrayList<Unit> list) {
        if (getAmmunition() > 0) {
            return true;
        }
        callSquire(list);
        return false;
    }

    @Override
    public void step(ArrayList<Unit> enemyUnits, ArrayList<Unit> alliedUnits) {
        if (!getIsDead()) {
            attack(enemyUnits, alliedUnits);
        }
    }

    @Override
    public String toStringForPartPanel() {
        return super.toStringForPartPanel() + "🏹" + ammunition;
    }
    //
    // Getters and setters
    //

    public int getConcentration() {
        return concentration;
    }

    public void setConcentration(int concentration) {
        this.concentration = concentration;
    }

    public int getMaxConcentration() {
        return maxConcentration;
    }

    public void setMaxConcentration(int maxConcentration) {
        this.maxConcentration = maxConcentration;
    }

    public int getAmmunition() {
        return ammunition;
    }

    public void setAmmunition(int ammunition) {
        this.ammunition = ammunition;
    }

    public int getMaxAmmunition() {
        return maxAmmunition;
    }

    public void setMaxAmmunition(int maxAmmunition) {
        this.maxAmmunition = maxAmmunition;
    }

    public int getAmountShotsInStep() {
        return amountShotsInStep;
    }

    public void setAmountShotsInStep(int amountShotsInStep) {
        this.amountShotsInStep = amountShotsInStep;
    }

}
