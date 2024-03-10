package View.Panel;

import javax.swing.*;

import Meneger.GameManager.GameManager;
import View.GameView;
import View.Panel.GameField.GameField;

import java.awt.*;

public class MainPanel extends JPanel {
    private GameView gameView;
    private GameField centerPanel;
    private TopPanel topPanel;
    private LeftPanel leftPanel;
    private RightPanel rightPanel;

    public MainPanel(GameView gameView) {
        this.gameView = gameView;
        createMainPanel();
    }

    private void createMainPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        topPanel = new TopPanel();
        leftPanel = new LeftPanel();
        rightPanel = new RightPanel();
        centerPanel = new GameField();

        centerPanel.setBackground(Color.BLACK);

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.EAST);
    }

    public void updateTextAreas(){
        leftPanel.updateTeamInformation(GameManager.getTeam1());
        rightPanel.updateTeamInformation(GameManager.getTeam2());
    };

    public LeftPanel getLeftPanel() {
        return leftPanel;
    }

    public RightPanel getRightPanel() {
        return rightPanel;
    }

    public GameField getCenterPanel() {
        return centerPanel;
    }
}
