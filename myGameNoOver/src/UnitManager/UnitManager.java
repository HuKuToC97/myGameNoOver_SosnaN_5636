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
        PEASANT, SQUIRE, ROBBER, HUNTER, MONK, WITCH, CROSSBOWMAN, SNIPER
        // Добавьте сюда другие классы-наследники, если они есть
    }

    public static ArrayList<Unit> createUnitList(int sizeTeam) {

        ArrayList<Unit> units = new ArrayList<>();
        Random random = new Random();

        // Создаем объекты-наследники Unit случайным образом и добавляем их в список
        // указанное количество раз
        for (int i = 0; i < sizeTeam; i++) {
            UnitType randomType = UnitType.values()[random.nextInt(UnitType.values().length)];
            switch (randomType) {
                case PEASANT:
                    units.add(new Peasant(getName()));
                    break;
                case SQUIRE:
                    units.add(new Squire(getName()));
                    break;
                case ROBBER:
                    units.add(new Robber(getName()));
                    break;
                case HUNTER:
                    units.add(new Hunter(getName()));
                    break;
                case MONK:
                    units.add(new Monk(getName()));
                    break;
                case WITCH:
                    units.add(new Witch(getName()));
                    break;
                case CROSSBOWMAN:
                    units.add(new Crossbowman(getName()));
                    break;
                case SNIPER:
                    units.add(new Sniper(getName()));
                    break;
                // Добавьте случаи для других наследников, если они есть
            }
        }
        return units;
    }

    private static String getName() {
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length - 1)]);
    }
}
