package Meneger.GameManager;

import java.io.Console;
import java.util.ArrayList;

import javax.swing.JPanel;

import Meneger.UnitManager.UnitManager;
import Unit.Unit;
import Unit.Auxiliary.Location2D;
import View.GameView;
import View.Panel.GameField;
import View.Panel.MainPanel;

public class GameManager {
    private GameView gameView;
    private GameField gameField;

    public GameManager(GameView gameView) {
        this.gameView = gameView;
    }

    public void startGame() {
        printHelloUser();
        ArrayList<Unit> team1 = UnitManager.createUnitList(10, 0);
        ArrayList<Unit> team2 = UnitManager.createUnitList(10, 9);

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

        printTeam(allUnits);

        boolean checkEnd = true;

        while (checkEnd) {
            stepApp(allUnits, team1, team2);
            checkEnd = checkEnd();
        }
    }

    private boolean checkEnd() {
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


    // public void updateGameView(ArrayList<Unit> units) {
    //     MainPanel mainPanel = this.gameView.getMainPanel();
    //     if (mainPanel instanceof MainPanel) {
    //         MainPanel mainPanelObject = (MainPanel) mainPanel;
    //         GameField gameField = (GameField) mainPanelObject.getCenterPanel();
    //         gameField.clear(); // Очищаем игровое поле перед обновлением
    //         for (Unit unit : units) {
    //             Location2D location = unit.getLocation();
    //             int x = location.getX();
    //             int y = location.getY();
    //             gameField.drawUnit(unit, x, y); // Отрисовываем персонажа в указанной клетке
    //         }
    //         gameField.repaint(); // Перерисовываем игровое поле
    //     } else {
    //         System.err.println("Ошибка: mainPanel не является экземпляром MainPanel");
    //     }
    // }

    public void updateGameView(ArrayList<Unit> units) {
        MainPanel mainPanel = this.gameView.getMainPanel();
        if (mainPanel != null) { // Проверка на null
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
    
}
