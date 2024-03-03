package View.Panel;

import javax.imageio.ImageIO;
import javax.swing.*;

import Unit.Unit;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GameField extends JPanel {
    private static final int GRID_SIZE = 10; // Размер сетки игрового поля
    private static final Color GRID_COLOR = Color.DARK_GRAY; // Цвет рамки секторов

    private JPanel[][] sectors; // Массив секторов игрового поля

    public GameField() {
        setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));
        setBorder(BorderFactory.createLineBorder(GRID_COLOR));

        // Инициализируем массив секторов
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
        // Отрисовываем персонажа в указанной клетке игрового поля
        if (x >= 0 && x < GRID_SIZE && y >= 0 && y < GRID_SIZE) {
            JPanel sector = sectors[x][y];
            if (sector.getComponentCount() == 0) { // Проверяем, что клетка не занята
                try {
                    // Загружаем изображение персонажа из файла
                    Image img = ImageIO.read(new File("myGameNoOver\\src\\View\\icon\\unit.png"));
                    // Создаем JLabel с изображением персонажа
                    JLabel label = new JLabel(new ImageIcon(img));
                    // Добавляем JLabel на панель сектора
                    sector.add(label);
                } catch (IOException e) {
                    // e.printStackTrace();
                    System.out.println("ОШиБКА!");
                }
            }
            sector.setBackground(Color.RED); // Меняем цвет клетки на красный
        }
    }

    public void clear() {
        // Очищаем игровое поле
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                sectors[i][j].removeAll(); // Удаляем все компоненты из клетки
                sectors[i][j].setBackground(Color.BLACK); // Возвращаем цвет фона по умолчанию
            }
        }
    }
}
