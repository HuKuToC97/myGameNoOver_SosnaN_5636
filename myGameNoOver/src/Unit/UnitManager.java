package Unit;

import java.util.ArrayList;

import Unit.Animal.Animal;
import Unit.Human.ContactCharacter.Worker.Peasant;

public class UnitManager {
    public static ArrayList<Unit> createUnitList() {

        ArrayList<Unit> units = new ArrayList<>();

        Animal kapibara = new Animal("Константин",
                "Капибара",
                1000000,
                1000000,
                1000000,
                10000000,
                100, 50, 150, 100);
        
                units.add(kapibara);

        Peasant peasant = new Peasant("Иван");
        units.add(peasant);



        return units;
    }

}
