import java.io.Console;
import java.util.ArrayList;

import Unit.Unit;
import UnitManager.UnitManager;
import View.View;

public class App {
    /**
     * @param args
     */
    public static void main(String[] args) {
        printHelloUser();
        ArrayList<Unit> team1 = UnitManager.createUnitList(10, 0);
        ArrayList<Unit> team2 = UnitManager.createUnitList(10, 9);

        // startBattle(team1, team2);

        View.view();
    }

    public static void startBattle(ArrayList<Unit> team1, ArrayList<Unit> team2) {

        ArrayList<Unit> allUnits = new ArrayList<>();
        allUnits.addAll(team1);
        allUnits.addAll(team2);

        System.out.println(team1);
        System.out.println(team2);
        System.out.println("-".repeat(16));

        printTeam(allUnits);

        allUnits.sort((o1, o2) -> o2.getInitiative() - o1.getInitiative());

        printTeam(allUnits);

        boolean checkEnd = true;

        while (checkEnd) {
            stepApp(allUnits, team1, team2);
            checkEnd = checkEnd();
        }

    }

    public static boolean checkEnd() {
        Console console = System.console();
        if (console == null) {
            System.err.println("Консольный ввод не поддерживается.");
            return false;
        }
        
        System.out.println("Нажмите Enter для следующего хода или введите stop для завершения битвы:");
        String input = console.readLine();
        input = input.trim(); // Убираем лишние пробелы

        return input.isEmpty() || !input.equalsIgnoreCase("stop");
    }

    public static void printTeam(ArrayList<Unit> team) {
        for (Unit unit : team) {
            unit.printHpAndIsDead();
        }
        System.out.println("-".repeat(16));
    }

    public static void stepApp(ArrayList<Unit> allUnits, ArrayList<Unit> team1, ArrayList<Unit> team2) {
        try {
            int delayInMillis = 0;
            int countSteps = 1;
            for (Unit unit : allUnits) {
                System.out.println(String.format("Подшаг %d:", countSteps));
                if (team1.contains(unit)) {
                    unit.step(team2, team1);
                } else {
                    unit.step(team1, team2);
                }
                // System.out.println("-".repeat(16));
                countSteps++;
                Thread.sleep(delayInMillis);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void printHelloUser() {
        System.out.println("/".repeat(16));
        System.out.println("Новая генерация\n");
    }
}