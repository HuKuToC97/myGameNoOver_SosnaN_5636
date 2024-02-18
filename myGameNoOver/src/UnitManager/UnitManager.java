package UnitManager;

import java.util.ArrayList;
import java.util.Random;

import Unit.Unit;
import Unit.Animal.Animal;
import Unit.Human.ContactCharacter.Warrior.Hunter;
import Unit.Human.ContactCharacter.Warrior.Robber;
import Unit.Human.ContactCharacter.Worker.Peasant;
import Unit.Human.ContactCharacter.Worker.Squire;
import Unit.Human.RangedCharacter.Confessor.Monk;
import Unit.Human.RangedCharacter.Mage.Witch;
import Unit.Human.RangedCharacter.Shooter.Archer;
import Unit.Human.RangedCharacter.Shooter.Crossbowman;
import Unit.Human.RangedCharacter.Shooter.Sniper;

public class UnitManager {
    public static ArrayList<Unit> createUnitList() {

        ArrayList<Unit> units = new ArrayList<>();

        Animal kapibara = new Animal("Константин",
                "Капибара",
                1000000,
                1000000,
                1000000,
                10000000,
                10000000, 50, 150, 100);

        units.add(kapibara);

        Peasant peasant = new Peasant(getName());
        units.add(peasant);
        Squire squire = new Squire(getName());
        units.add(squire);

        Robber robber = new Robber(getName());
        units.add(robber);

        Hunter hunter = new Hunter(getName());
        units.add(hunter);

        Monk monk = new Monk(getName());
        units.add(monk);

        Witch witch = new Witch(getName());
        units.add(witch);

        Crossbowman crossbowman = new Crossbowman(getName());
        units.add(crossbowman);

        Sniper sniper = new Sniper(getName());
        units.add(sniper);

        return units;
    }

    enum UnitType {
        PEASANT, SQUIRE, ROBBER, HUNTER, MONK, WITCH, CROSSBOWMAN, SNIPER, ARCHER
    }

    public static ArrayList<Unit> createUnitList(int sizeTeam, int x) {

        ArrayList<Unit> units = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < sizeTeam; i++) {
            UnitType randomType = UnitType.values()[random.nextInt(UnitType.values().length)];
            switch (randomType) {
                case PEASANT:
                    units.add(new Peasant(getName(), x, i));
                    break;
                case SQUIRE:
                    units.add(new Squire(getName(), x, i));
                    break;
                case ROBBER:
                    units.add(new Robber(getName(), x, i));
                    break;
                case HUNTER:
                    units.add(new Hunter(getName(), x, i));
                    break;
                case MONK:
                    units.add(new Monk(getName(), x, i));
                    break;
                case WITCH:
                    units.add(new Witch(getName(), x, i));
                    break;
                case CROSSBOWMAN:
                    units.add(new Crossbowman(getName(), x, i));
                    break;
                case SNIPER:
                    units.add(new Sniper(getName(), x, i));
                    break;
                case ARCHER:
                    units.add(new Archer(getName(), x, i));
                    break;
            }
        }
        return units;
    }

    private static String getName() {
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length - 1)]);
    }
}
