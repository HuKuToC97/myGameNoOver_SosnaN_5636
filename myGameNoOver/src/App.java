import java.util.ArrayList;

import Unit.Unit;
import UnitManager.UnitManager;

public class App {
    /**
     * @param args
     */
    public static void main(String[] args) {
        hello();
        ArrayList<Unit> team1 = UnitManager.createUnitList(10, 0);
        ArrayList<Unit> team2 = UnitManager.createUnitList(10, 9);
        for (Unit unit : team1) {
            unit.infoForSeminarSecond();
        }
        System.out.println("---------");
        for (Unit unit : team2) {
            unit.infoForSeminarSecond();
        }
        System.out.println("---------");
        System.out.println(team1.get(0).findNearestEnemy(team2));
    }




    
    public static void hello(){
        System.out.println("////////////////////////////////////////////////////////////////////\nНовая генерация\n");
    }
}