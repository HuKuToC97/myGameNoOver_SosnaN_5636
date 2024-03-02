// Файл SidePanel.java
package View.Panel;

import javax.swing.*;

import View.GameView;

import java.awt.*;

public class PartPanel {
    private GameView gameView; // Добавляем поле для хранения ссылки на GameView

    public PartPanel(GameView gameView) {
        this.gameView = gameView;
    }

    public JPanel createSidePanel(int size, String position) {
        JPanel sidePanel = new JPanel();
        sidePanel.setPreferredSize(position.equals(BorderLayout.NORTH) || position.equals(BorderLayout.SOUTH)
                ? new Dimension(gameView.getFrame().getWidth(), size) // Получаем ширину через метод getFrame()
                : new Dimension(size, gameView.getFrame().getHeight())); // Получаем высоту через метод getFrame()

        sidePanel.setBackground(Color.GRAY);
        sidePanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        return sidePanel;
    }
}
