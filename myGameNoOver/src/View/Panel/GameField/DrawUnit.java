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
    private static final Map<String, Image> unitIconCache = new HashMap<>();

    static {
        loadUnitIcons();
    }

    private static void loadUnitIcons() {
        Map<String, String> unitIcons = new HashMap<>();
        unitIcons.put("Hunter", "hunter.png");
        unitIcons.put("Robber", "robber.png");
        unitIcons.put("Peasant", "peasant.png");
        unitIcons.put("Squire", "squire.png");
        unitIcons.put("Monk", "monk.png");
        unitIcons.put("Witch", "witch.png");
        unitIcons.put("Archer", "archer.png");
        unitIcons.put("Crossbowman", "crossbowman.png");
        unitIcons.put("Sniper", "sniper.png");

        for (Map.Entry<String, String> entry : unitIcons.entrySet()) {
            String unitType = entry.getKey();
            String iconPath = entry.getValue();

            try {
                Image img = ImageIO.read(new File(ICON_FOLDER_PATH + iconPath));
                unitIconCache.put(unitType, img);
            } catch (IOException e) {
                System.out.println("Ошибка при загрузке изображения юнита " + unitType + ": " + e.getMessage());
            }
        }
    }

    public static void drawUnit(Unit unit, JPanel sector) {
        String unitType = unit.getTypeUnit();
        Image img = unitIconCache.get(unitType);

        if (img == null) {
            System.out.println("Иконка для типа юнита " + unitType + " не найдена");
            return;
        }

        Image scaledImg = img.getScaledInstance(sector.getWidth(), sector.getHeight(), Image.SCALE_SMOOTH);
        JLabel label = new JLabel(new ImageIcon(scaledImg));
        sector.add(label);
    }
}