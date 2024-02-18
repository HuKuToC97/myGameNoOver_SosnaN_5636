
import java.util.ArrayList;

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

        Peasant peasant = new Peasant("Иван");
        units.add(peasant);
        Squire squire = new Squire("Армэн");
        units.add(squire);

        Robber robber = new Robber("Володя");
        units.add(robber);

        Hunter hunter = new Hunter("Олег");
        units.add(hunter);

        Monk monk = new Monk("Марвел");
        units.add(monk);

        Witch witch = new Witch("Коля");
        units.add(witch);

        Crossbowman crossbowman = new Crossbowman("Крю");
        units.add(crossbowman);

        Sniper sniper = new Sniper("Сергей");
        units.add(sniper);

        return units;
    }

}
