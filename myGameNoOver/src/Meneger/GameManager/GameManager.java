package Meneger.GameManager;

import java.util.ArrayList;

import javax.swing.JOptionPane;

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
            updateGameView(allUnits);
            gameView.getMainPanel().getTopPanel().waitForStep(); // Ждем нажатия кнопки "Сделать шаг"
            stepApp(allUnits, team1, team2);
        }

        if (!continuationFlag) {
            System.out.println("Игра завершена.");
        }
    }

    private boolean checkAliveUnit(ArrayList<Unit> allUnits) {
        team1DeadFlag = true;
        team2DeadFlag = true;
        for (Unit unit : allUnits) {
            if (team1.contains(unit)) {
                team1DeadFlag = team1DeadFlag && unit.getIsDead();
            }
            if (team2.contains(unit)) {
                team2DeadFlag = team2DeadFlag && unit.getIsDead();
            }
        }
        if (team1DeadFlag) {
            System.out.println("Team2 win");
        }
        if (team2DeadFlag) {
            System.out.println("Team1 win");
        }

        if (team1DeadFlag || team2DeadFlag) {
            checkWinningTeam();
        }
        
        return !(team1DeadFlag || team2DeadFlag);
    }

    private void checkWinningTeam() {
        if (team1DeadFlag && team2DeadFlag) {
            JOptionPane.showMessageDialog(gameView.getFrame(), "Both teams are dead. It's a draw!");
        } else if (team1DeadFlag) {
            JOptionPane.showMessageDialog(gameView.getFrame(), "Team 2 wins!");
        } else if (team2DeadFlag) {
            JOptionPane.showMessageDialog(gameView.getFrame(), "Team 1 wins!");
        }
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
            for (Unit unit : allUnits) {
                if (team1.contains(unit)) {
                    unit.step(team2, team1);
                } else {
                    unit.step(team1, team2);
                }
                updateGameView(allUnits);
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
        if (mainPanel != null) {
            mainPanel.updateTextAreas();
            GameField gameField = mainPanel.getCenterPanel();
            gameField.clear();

            ArrayList<Unit> deadUnits = new ArrayList<>();
            ArrayList<Unit> aliveUnits = new ArrayList<>();

            // Разделяем юнитов на мертвых и живых
            for (Unit unit : units) {
                if (unit.getIsDead()) {
                    deadUnits.add(unit);
                } else {
                    aliveUnits.add(unit);
                }
            }

            // Отрисовываем сначала мертвых юнитов, затем живых
            drawUnits(gameField, deadUnits);
            drawUnits(gameField, aliveUnits);

            gameField.repaint();
        } else {
            System.err.println("Ошибка: mainPanel не инициализирован");
        }
    }

    private void drawUnits(GameField gameField, ArrayList<Unit> units) {
        for (Unit unit : units) {
            Location2D location = unit.getLocation();
            int x = location.getX();
            int y = location.getY();
            gameField.drawUnit(unit, x, y);
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
