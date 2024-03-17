package View.Panel.GameField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

import Meneger.GameManager.GameManager;
import Unit.Unit;

public class GameField extends JPanel {
    private static final int GRID_SIZE = 10;
    private static final Color GRID_COLOR = Color.DARK_GRAY;
    private static final Color TEAM1_COLOR = Color.BLUE;
    private static final Color TEAM2_COLOR = Color.GREEN;
    private static final Color DEAD_UNIT_COLOR = Color.RED;

    private JPanel[][] sectors;
    private Popup unitInfoPopup; // Объявляем переменную для всплывающего окна информации о юните

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
            DrawUnit.drawUnit(unit, sector);
            setSectorColor(unit, sector);
            addUnitMouseListeners(unit, sector);
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

    private void addUnitMouseListeners(Unit unit, JPanel sector) {
        if (unit != null) {
            sector.addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    showUnitInfoPopup(e.getX(), e.getY(), sector, unit);
                }
            });
            sector.addMouseListener(new java.awt.event.MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if (unitInfoPopup != null) {
                        unitInfoPopup.hide(); // Скрываем всплывающее окно, когда мышь покидает сектор
                    }
                }
            });
        }
    }

    private void showUnitInfoPopup(int x, int y, JPanel sector, Unit unit) {
        if (unit != null) { // Если персонаж найден
            if (unitInfoPopup != null) { // если уже существует всплывающее окно, скрываем его
                unitInfoPopup.hide();
            }
            UnitInfoPopup popup = new UnitInfoPopup(unit); // Создаем всплывающее окно с информацией о персонаже
            PopupFactory factory = PopupFactory.getSharedInstance();

            // Получаем размеры экрана
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int screenWidth = (int) screenSize.getWidth();
            int screenHeight = (int) screenSize.getHeight();

            // Размеры всплывающего окна
            int popupWidth = popup.getPreferredSize().width;
            int popupHeight = popup.getPreferredSize().height;

            // Координаты сектора на экране
            Point locationOnScreen = sector.getLocationOnScreen();
            int sectorX = (int) locationOnScreen.getX();
            int sectorY = (int) locationOnScreen.getY();

            // Вычисляем координаты для отображения всплывающего окна
            int popupX = sectorX + x;
            int popupY = sectorY + y + 20; // Смещаем всплывающее окно ниже сектора

            // Проверяем, чтобы окно не выходило за пределы экрана
            if (popupX + popupWidth > screenWidth) {
                popupX = screenWidth - popupWidth;
            }
            if (popupY + popupHeight > screenHeight) {
                popupY = screenHeight - popupHeight;
            }

            // Создаем экземпляр всплывающего окна
            unitInfoPopup = factory.getPopup(sector, popup, popupX, popupY);
            unitInfoPopup.show(); // Отображаем всплывающее окно
        }
    }

    public void clear() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                JPanel sector = sectors[i][j];
                removeUnitMouseListeners(sector);
                sector.removeAll(); // Очищаем сектор
                sector.setBackground(Color.BLACK); // Возвращаем цвет фона по умолчанию
                sector.revalidate(); // Перерисовываем сектор
                sector.repaint();
            }
        }
    }

    private void removeUnitMouseListeners(JPanel sector) {
        for (MouseListener listener : sector.getMouseListeners()) {
            sector.removeMouseListener(listener);
        }
        for (MouseMotionListener listener : sector.getMouseMotionListeners()) {
            sector.removeMouseMotionListener(listener);
        }
    }
}
