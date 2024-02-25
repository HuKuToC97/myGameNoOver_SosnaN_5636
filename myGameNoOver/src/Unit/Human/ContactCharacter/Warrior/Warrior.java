package Unit.Human.ContactCharacter.Warrior;

import java.util.ArrayList;

import Unit.Unit;
import Unit.Auxiliary.Location2D;
import Unit.Auxiliary.Location2DDifference;
import Unit.Human.ContactCharacter.ContactCharacter;

public abstract class Warrior extends ContactCharacter {
    private int endurance;

    private int maxEndurance;

    public Warrior(String name, String typeUnit, int level, int experiencePoints, int initiative,
            Location2D location, int hitPoints, int maxHitPoints, int power, int dexterity, int sustainability,
            int endurance, int maxEndurance) {
        super(name, typeUnit, level, experiencePoints, initiative, location, hitPoints, maxHitPoints, power, dexterity,
                sustainability);
        this.endurance = endurance;
        this.maxEndurance = maxEndurance;
    }

    @Override
    public void step(ArrayList<Unit> enemyUnits, ArrayList<Unit> alliedUnits) {
        if (!getIsDead()) {
            Unit nearestEnemy = findNearestEnemy(enemyUnits);
            if (nearestEnemy == null) {
                System.out.println("Все противники мертвы");
            } else {
                Location2D enemyLocation = nearestEnemy.getLocation();
                Location2DDifference diffLoc = getLocation().getDiffLocation2D(enemyLocation);
                if (diffLoc.getAbsdX() < 2 && diffLoc.getAbsdY() < 2) {
                    attack(nearestEnemy);
                } else {
                    moveTowards(enemyUnits, alliedUnits, diffLoc);
                    printLocation();
                }
            }

        }
    }

    protected void moveTowards(ArrayList<Unit> enemyUnits, ArrayList<Unit> alliedUnits, Location2DDifference diffLoc) {
        if (diffLoc.getAbsdX() > diffLoc.getAbsdY()) {
            Location2D newLocation = new Location2D(getLocation().getX() - diffLoc.getSignumdX(), getLocation().getY());
            if (Location2D.isEmptyCell(newLocation.getX(), newLocation.getY(), alliedUnits)) {
                // moving along x
                setLocation(newLocation);
                System.out.println("moving along x");
            } else {
                // chek moving along y
                newLocation = new Location2D(getLocation().getX(), getLocation().getY() - diffLoc.getSignumdY());
                if (Location2D.isEmptyCell(newLocation.getX(), newLocation.getY(), alliedUnits)) {
                    // moving along y
                    setLocation(newLocation);
                    System.out.println("moving along y");
                } else {
                    // stand?
                    System.out.println("stand?");
                }
            }

        } else {
            Location2D newLocation = new Location2D(getLocation().getX(), getLocation().getY() - diffLoc.getSignumdY());
            if (Location2D.isEmptyCell(newLocation.getX(), newLocation.getY(), alliedUnits)) {
                // moving along y
                setLocation(newLocation);
                System.out.println("moving along y");
            } else {
                // chek moving along x
                newLocation = new Location2D(getLocation().getX() - diffLoc.getSignumdX(), getLocation().getY());
                if (Location2D.isEmptyCell(newLocation.getX(), newLocation.getY(), alliedUnits)) {
                    // moving along x
                    setLocation(newLocation);
                    System.out.println("moving along x");
                } else {
                    // stand?
                    System.out.println("stand?");
                }
            }

        }
    }

    protected void attack(Unit nearestEnemy) {
        getDamage(nearestEnemy);
    }
    //
    // Getters and setters
    //

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public int getMaxEndurance() {
        return maxEndurance;
    }

    public void setMaxEndurance(int maxEndurance) {
        this.maxEndurance = maxEndurance;
    }

}
