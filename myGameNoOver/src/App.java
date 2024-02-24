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

        startBattle(team1, team2);
    }

    public static void startBattle(ArrayList<Unit> team1, ArrayList<Unit> team2) {

        ArrayList<Unit> allUnits = new ArrayList<>();
        allUnits.addAll(team1);
        allUnits.addAll(team2);

        System.out.println(team1);
        System.out.println(team2);



        showTeam(allUnits);

        allUnits.sort((o1, o2) -> o2.getInitiative() - o1.getInitiative());

        showTeam(allUnits);

        stepApp(allUnits, team1, team2);

    }

    public static void showTeam(ArrayList<Unit> team) {
        for (Unit unit : team) {
            unit.infoForSeminarSecond();
        }
        System.out.println("-".repeat(16));
    }

    public static void stepApp(ArrayList<Unit> allUnits, ArrayList<Unit> team1, ArrayList<Unit> team2) {
        try {
            int delayInMillis = 500;
            int countSteps = 1;
            for (Unit unit : allUnits) {
                System.out.println(String.format("Шаг %d:", countSteps));
                if (team1.contains(unit)) {
                    unit.step(team2);
                } else {
                    unit.step(team1);
                }
                System.out.println("-".repeat(16));
                countSteps++;
                Thread.sleep(delayInMillis);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void hello() {
        System.out.println("/".repeat(16));
        System.out.println("Новая генерация\n");
    }
}