// Файл GameField.java
package View.Panel;

import javax.swing.*;
import java.awt.*;

public class GameField extends JPanel {
    private static final int GRID_SIZE = 10; // Размер сетки игрового поля
    private static final Color GRID_COLOR = Color.DARK_GRAY; // Цвет рамки секторов

    public GameField() {
        setLayout(new GridLayout(GRID_SIZE, GRID_SIZE)); // Устанавливаем GridLayout для игрового поля
        setBorder(BorderFactory.createLineBorder(GRID_COLOR)); // Устанавливаем рамку

        // Создаем секторы игрового поля
        for (int i = 0; i < GRID_SIZE * GRID_SIZE; i++) {
            JPanel sector = new JPanel();
            sector.setBackground(Color.BLACK); // Устанавливаем цвет фона сектора
            sector.setBorder(BorderFactory.createLineBorder(GRID_COLOR)); // Устанавливаем рамку сектора
            add(sector); // Добавляем сектор на игровое поле
        }
    }
}
