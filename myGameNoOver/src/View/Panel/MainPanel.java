// Файл MainPanel.java
package View.Panel;

import javax.swing.*;

import View.GameView;

import java.awt.*;

public class MainPanel {
    private GameView gameView; // Добавляем поле для хранения ссылки на GameView

    public MainPanel(GameView gameView) {
        this.gameView = gameView;
    }

    public JPanel createMainPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.BLACK);

        JPanel topPanel = new PartPanel(gameView).createSidePanel(50, BorderLayout.NORTH); // Передаем ссылку на GameView в конструктор SidePanel
        JPanel leftPanel = new PartPanel(gameView).createSidePanel(200, BorderLayout.WEST); // Передаем ссылку на GameView в конструктор SidePanel
        JPanel rightPanel = new PartPanel(gameView).createSidePanel(200, BorderLayout.EAST); // Передаем ссылку на GameView в конструктор SidePanel
        JPanel centerPanel = new GameField();

        centerPanel.setBackground(Color.BLACK);

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(rightPanel, BorderLayout.EAST);

        return mainPanel;
    }
}
