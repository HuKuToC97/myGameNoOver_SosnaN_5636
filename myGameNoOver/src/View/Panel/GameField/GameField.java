package View.Panel.GameField;

import javax.swing.*;

import Meneger.GameManager.GameManager;
import Unit.Unit;

import java.awt.*;

public class GameField extends JPanel {
    private static final int GRID_SIZE = 10;
    private static final Color GRID_COLOR = Color.DARK_GRAY;
    private static final Color TEAM1_COLOR = Color.BLUE;
    private static final Color TEAM2_COLOR = Color.GREEN;
    private static final Color DEAD_UNIT_COLOR = Color.RED;

    private JPanel[][] sectors;

    public GameField() {
        setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));
        setBorder(BorderFactory.createLineBorder(GRID_COLOR));
        initializeSectors();
    }

    private void initializeSectors() {
        sectors = new JPanel[GRID_SIZE][GRID_SIZE];
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                JPanel sector = new JPanel();
                sector.setBackground(Color.BLACK);
                sector.setBorder(BorderFactory.createLineBorder(GRID_COLOR));
                sectors[j][i] = sector;
                add(sector);
            }
        }
    }

    public void drawUnit(Unit unit, int x, int y) {
        if (x >= 0 && x < GRID_SIZE && y >= 0 && y < GRID_SIZE) {
            JPanel sector = sectors[x][y];
            sector.removeAll(); // Очищаем сектор от предыдущих элементов
            DrawUnit.drawUnit(unit, sector); // Используем DrawUnit для отрисовки юнита
            setSectorColor(unit, sector); // Устанавливаем цвет сектора в зависимости от состояния юнита
            sector.revalidate(); // Перерисовываем сектор
            sector.repaint();
        }
    }

    private void setSectorColor(Unit unit, JPanel sector) {
        if (unit.getIsDead()) {
            sector.setBackground(DEAD_UNIT_COLOR);
        } else if (GameManager.getTeam1().contains(unit)) {
            sector.setBackground(TEAM1_COLOR);
        } else if (GameManager.getTeam2().contains(unit)) {
            sector.setBackground(TEAM2_COLOR);
        } else {
            sector.setBackground(Color.BLACK); // Если юнит не принадлежит ни одной команде, устанавливаем цвет по умолчанию
        }
    }

    public void clear() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                JPanel sector = sectors[i][j];
                sector.removeAll(); // Очищаем сектор
                sector.setBackground(Color.BLACK); // Возвращаем цвет фона по умолчанию
                sector.revalidate(); // Перерисовываем сектор
                sector.repaint();
            }
        }
    }
}
