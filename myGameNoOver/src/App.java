import java.util.ArrayList;

import Unit.Unit;

public class App {
    /**
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Unit> units = UnitManager.createUnitList();
        for (Unit unit : units) {
            System.out.println(unit);
        }

    }
}