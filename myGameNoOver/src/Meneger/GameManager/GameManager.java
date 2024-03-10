package Meneger.GameManager;

import java.io.Console;
import java.util.ArrayList;

import Meneger.UnitManager.UnitManager;
import Unit.Unit;
import Unit.Auxiliary.Location2D;
import View.GameView;
import View.Panel.MainPanel;
import View.Panel.GameField.GameField;

public class GameManager {
    private GameView gameView;

    public static boolean continuationFlag = true;

    private static boolean team1DeadFlag;
    private static boolean team2DeadFlag;

    private static ArrayList<Unit> team1;
    private static ArrayList<Unit> team2;

    public GameManager(GameView gameView) {
        this.gameView = gameView;
    }

    public void startGame() {
        printHelloUser();
        team1 = UnitManager.createUnitList(10, 0);
        team2 = UnitManager.createUnitList(10, 9);

        startBattle(team1, team2);
    }

private void startBattle(ArrayList<Unit> team1, ArrayList<Unit> team2) {
    ArrayList<Unit> allUnits = new ArrayList<>();
    allUnits.addAll(team1);
    allUnits.addAll(team2);

    System.out.println(team1);
    System.out.println(team2);
    System.out.println("-".repeat(16));

    printTeam(allUnits);

    allUnits.sort((o1, o2) -> o2.getInitiative() - o1.getInitiative());
    updateGameView(allUnits);

    while (continuationFlag && checkAliveUnit(allUnits)) {
        stepApp(allUnits, team1, team2);
        updateGameView(allUnits);
    }

    if (!continuationFlag) {
        System.out.println("Игра завершена.");
    }
}

    private boolean checkAliveUnit(ArrayList<Unit> allUnits) {
        for (Unit unit : allUnits) {
            if (team1.contains(unit)) {
                team1DeadFlag = unit.getIsDead();
            }
            if (team2.contains(unit)) {
                team2DeadFlag = unit.getIsDead();
            }
        }
        if (team1DeadFlag) {
            System.out.println("Team2 win");
        }
        if (team2DeadFlag) {
            System.out.println("Team1 win");
        }
        return !(team1DeadFlag || team2DeadFlag);
    }

    private boolean requestToContinue() {
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

    private void printTeam(ArrayList<Unit> team) {
        for (Unit unit : team) {
            unit.printHpAndIsDead();
        }
        System.out.println("-".repeat(16));
    }

    private void stepApp(ArrayList<Unit> allUnits, ArrayList<Unit> team1, ArrayList<Unit> team2) {
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
                updateGameView(allUnits);
                countSteps++;
                Thread.sleep(delayInMillis);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void printHelloUser() {
        System.out.println("/".repeat(16));
        System.out.println("Новая генерация\n");
    }

    public void updateGameView(ArrayList<Unit> units) {
        MainPanel mainPanel = this.gameView.getMainPanel();
        if (mainPanel != null) { // Проверка на null
            mainPanel.updateTextAreas();
            GameField gameField = mainPanel.getCenterPanel();
            gameField.clear();
            for (Unit unit : units) {
                Location2D location = unit.getLocation();
                int x = location.getX();
                int y = location.getY();
                gameField.drawUnit(unit, x, y);
            }
            gameField.repaint();
        } else {
            System.err.println("Ошибка: mainPanel не инициализирован");
        }
    }

    //
    // Getters and setters
    //

    public static boolean isTeam1DeadFlag() {
        return team1DeadFlag;
    }

    public static void setTeam1DeadFlag(boolean team1DeadFlag) {
        GameManager.team1DeadFlag = team1DeadFlag;
    }

    public static boolean isTeam2DeadFlag() {
        return team2DeadFlag;
    }

    public static void setTeam2DeadFlag(boolean team2DeadFlag) {
        GameManager.team2DeadFlag = team2DeadFlag;
    }

    public static ArrayList<Unit> getTeam1() {
        return team1;
    }

    public static ArrayList<Unit> getTeam2() {
        return team2;
    }
}
