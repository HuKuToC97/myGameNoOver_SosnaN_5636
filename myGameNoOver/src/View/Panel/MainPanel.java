package View.Panel;

import javax.swing.*;

import View.GameView;

import java.awt.*;

public class MainPanel extends JPanel {
    private GameView gameView;
    private GameField centerPanel;

    public MainPanel(GameView gameView) {
        this.gameView = gameView;
        createMainPanel();
    }

    private void createMainPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        JPanel topPanel = new PartPanel(gameView).createSidePanel(50, BorderLayout.NORTH);
        JPanel leftPanel = new PartPanel(gameView).createSidePanel(200, BorderLayout.WEST);
        JPanel rightPanel = new PartPanel(gameView).createSidePanel(200, BorderLayout.EAST);
        centerPanel = new GameField();

        centerPanel.setBackground(Color.BLACK);

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.EAST);
    }

    public GameField getCenterPanel() { // Изменяем тип возвращаемого значения
        return centerPanel;
    }
}
