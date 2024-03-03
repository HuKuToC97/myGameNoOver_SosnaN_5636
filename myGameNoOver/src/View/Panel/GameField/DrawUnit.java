package View.Panel.GameField;

import javax.imageio.ImageIO;
import javax.swing.*;

import Unit.Unit;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DrawUnit {
    private static final String ICON_FOLDER_PATH = "myGameNoOver\\src\\View\\icon\\";

    private static final Map<String, String> unitIcons = new HashMap<>();

    static {
        // Здесь добавляем соответствие между типом юнита и путем к иконке
        unitIcons.put("Warrior", "warrior.png");
        unitIcons.put("Archer", "archer.png");
        unitIcons.put("Mage", "mage.png");
        // Добавьте другие типы юнитов и их иконки по мере необходимости
    }

    public static void drawUnit(Unit unit, JPanel sector) {
        String unitType = unit.getTypeUnit();
        String iconPath = unitIcons.get(unitType);
        if (iconPath == null) {
            System.out.println("Иконка для типа юнита " + unitType + " не найдена");
            return;
        }

        try {
            Image img = ImageIO.read(new File(ICON_FOLDER_PATH + iconPath));
            Image scaledImg = img.getScaledInstance(sector.getWidth(), sector.getHeight(), Image.SCALE_SMOOTH);
            JLabel label = new JLabel(new ImageIcon(scaledImg));
            sector.add(label);
        } catch (IOException e) {
            System.out.println("Ошибка при загрузке изображения юнита: " + e.getMessage());
        }
    }
}
