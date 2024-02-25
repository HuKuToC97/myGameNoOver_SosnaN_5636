import java.util.ArrayList;
import java.util.Scanner;

import Unit.Unit;
import UnitManager.UnitManager;

public class App {
    /**
     * @param args
     */
    public static void main(String[] args) {
        printHelloUser();
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Нажмите Enter для следующего хода или введите stop для завершения битвы:");
    
        while (true) {
            if (System.console() == null) {
                // Если консоль не поддерживает ввод, используем Scanner
                if (scanner.hasNextLine()) {
                    String input = scanner.nextLine();
                    if (input.equalsIgnoreCase("stop")) {
                        return false; // Завершаем битву
                    } else if (input.trim().isEmpty()) {
                        return true; // Продолжаем битву
                    }
                }
            } else {
                // Иначе используем консольный ввод
                String input = System.console().readLine();
                if (input != null) {
                    input = input.trim(); // Убираем лишние пробелы
                    if (input.equalsIgnoreCase("stop")) {
                        return false; // Завершаем битву
                    } else if (input.isEmpty()) {
                        return true; // Продолжаем битву
                    }
                }
            }
        }
    }

    public static void printTeam(ArrayList<Unit> team) {
        for (Unit unit : team) {
            unit.infoForSeminarSecond();
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
                    unit.step(team2);
                } else {
                    unit.step(team1);
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