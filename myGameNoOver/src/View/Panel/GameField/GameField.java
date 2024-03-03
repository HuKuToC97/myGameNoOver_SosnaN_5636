package View.Panel.GameField;

// import javax.imageio.ImageIO;
// import javax.swing.*;

// import Meneger.GameManager.GameManager;
// import Unit.Unit;

// import java.awt.*;
// import java.io.File;
// import java.io.IOException;

// public class GameField extends JPanel {
//     private static final int GRID_SIZE = 10; // Размер сетки игрового поля
//     private static final Color GRID_COLOR = Color.DARK_GRAY; // Цвет рамки секторов

//     private JPanel[][] sectors; // Массив секторов игрового поля

//     public GameField() {
//         setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));
//         setBorder(BorderFactory.createLineBorder(GRID_COLOR));

//         // Инициализируем массив секторов
//         sectors = new JPanel[GRID_SIZE][GRID_SIZE];
//         for (int i = 0; i < GRID_SIZE; i++) {
//             for (int j = 0; j < GRID_SIZE; j++) {
//                 JPanel sector = new JPanel();
//                 sector.setBackground(Color.BLACK);
//                 sector.setBorder(BorderFactory.createLineBorder(GRID_COLOR));
//                 sectors[i][j] = sector;
//                 add(sector);
//             }
//         }
//     }

//     public void drawUnit(Unit unit, int x, int y) {
//         // Отрисовываем персонажа в указанной клетке игрового поля
//         if (x >= 0 && x < GRID_SIZE && y >= 0 && y < GRID_SIZE) {
//             JPanel sector = sectors[x][y];
//             // Удаляем предыдущее изображение, если оно есть
//             sector.removeAll();
//             if (sector.getComponentCount() == 0) { // Проверяем, что клетка не занята
//                 try {
//                     // Загружаем изображение персонажа из файла
//                     Image img = ImageIO.read(new File("myGameNoOver\\src\\View\\icon\\unit.png"));
//                     // Устанавливаем размеры изображения
//                     Image scaledImg = img.getScaledInstance(sector.getWidth(), sector.getHeight(), Image.SCALE_SMOOTH);
//                     JLabel label = new JLabel(new ImageIcon(scaledImg));
//                     // Добавляем JLabel на панель сектора
//                     sector.add(label);

//                     // Определяем цвет в зависимости от команды юнита и его состояния
//                     if (GameManager.getTeam1().contains(unit)) {
//                         sector.setBackground(Color.BLUE); // синий цвет для команды 1
//                     } else if (GameManager.getTeam2().contains(unit)) {
//                         sector.setBackground(Color.GREEN); // зеленый цвет для команды 2
//                     }
//                     if (unit.getIsDead()) {
//                         sector.setBackground(Color.RED); // красный цвет для мертвого юнита
//                     }
//                 } catch (IOException e) {
//                     // e.printStackTrace();
//                     System.out.println("ОШиБКА!");
//                 }
//             } else {
//                 sector.setBackground(Color.WHITE); // Устанавливаем белый цвет фона для занятого сектора
//             }
//         }
//     }

//     public void clear() {
//         // Очищаем игровое поле
//         for (int i = 0; i < GRID_SIZE; i++) {
//             for (int j = 0; j < GRID_SIZE; j++) {
//                 sectors[i][j].removeAll(); // Удаляем все компоненты из клетки
//                 sectors[i][j].setBackground(Color.BLACK); // Возвращаем цвет фона по умолчанию
//             }
//         }
//     }
// }

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
                sectors[i][j] = sector;
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
