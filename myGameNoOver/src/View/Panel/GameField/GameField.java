package View.Panel.GameField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import Meneger.GameManager.GameManager;
import Unit.Unit;

public class GameField extends JPanel {
    private static final int GRID_SIZE = 10;
    private static final Color GRID_COLOR = Color.DARK_GRAY;
    private static final Color TEAM1_COLOR = Color.BLUE;
    private static final Color TEAM2_COLOR = Color.GREEN;
    private static final Color DEAD_UNIT_COLOR = Color.RED;

    private JPanel[][] sectors;
    private Popup unitInfoPopup;

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

    private void showUnitInfoPopup(int x, int y, JPanel sector) {
        Unit unit = getUnitFromSector(sector); // Получаем персонажа из сектора
        if (unit != null) { // Если персонаж найден
            if (unitInfoPopup != null) { // если уже существует всплывающее окно, скрываем его
                unitInfoPopup.hide();
            }
            UnitInfoPopup popup = new UnitInfoPopup(unit); // Создаем всплывающее окно с информацией о персонаже
            PopupFactory factory = PopupFactory.getSharedInstance();
            
            // Получаем абсолютные координаты сектора на экране
            Point locationOnScreen = sector.getLocationOnScreen();
            int absoluteX = (int) locationOnScreen.getX() + x;
            int absoluteY = (int) locationOnScreen.getY() + y;
    
            unitInfoPopup = factory.getPopup(sector, popup, absoluteX, absoluteY); // Создаем экземпляр всплывающего окна
            unitInfoPopup.show(); // Отображаем всплывающее окно
        }
    }

    private Unit getUnitFromSector(JPanel sector) {
        // Предполагаем, что каждая панель sector содержит в себе объект Unit
        Object obj = sector.getClientProperty("unit");
        if (obj instanceof Unit) {
            return (Unit) obj;
        } else {
            return null;
        }
    }

    public void drawUnit(Unit unit, int x, int y) {
        if (x >= 0 && x < GRID_SIZE && y >= 0 && y < GRID_SIZE) {
            JPanel sector = sectors[x][y];
            sector.removeAll(); // Очищаем сектор от предыдущих элементов
            DrawUnit.drawUnit(unit, sector);
            setSectorColor(unit, sector);

            sector.putClientProperty("unit", unit);
            sector.addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    showUnitInfoPopup(e.getX(), e.getY(), sector);
                }
            });
            sector.addMouseListener(new java.awt.event.MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {}
            
                @Override
                public void mousePressed(MouseEvent e) {}
            
                @Override
                public void mouseReleased(MouseEvent e) {}
            
                @Override
                public void mouseEntered(MouseEvent e) {}
            
                @Override
                public void mouseExited(MouseEvent e) {
                    if (unitInfoPopup != null) {
                        unitInfoPopup.hide(); // Скрываем всплывающее окно, когда мышь покидает сектор
                    }
                }
            });

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
            sector.setBackground(Color.BLACK); // Если юнит не принадлежит ни одной команде, устанавливаем цвет по
                                               // умолчанию
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