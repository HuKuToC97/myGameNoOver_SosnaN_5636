package View.Panel;

// import javax.swing.*;

// import View.GameView;
// import View.Panel.GameField.GameField;

// import java.awt.*;

// public class MainPanel extends JPanel {
//     private GameView gameView;
//     private GameField centerPanel;

//     public MainPanel(GameView gameView) {
//         this.gameView = gameView;
//         createMainPanel();
//     }

//     private void createMainPanel() {
//         setLayout(new BorderLayout());
//         setBackground(Color.BLACK);

//         JPanel topPanel = new PartPanel(gameView).createSidePanel(50, BorderLayout.NORTH);
//         JPanel leftPanel = new PartPanel(gameView).createSidePanel(200, BorderLayout.WEST);
//         JPanel rightPanel = new PartPanel(gameView).createSidePanel(200, BorderLayout.EAST);
//         centerPanel = new GameField();

//         centerPanel.setBackground(Color.BLACK);

//         add(topPanel, BorderLayout.NORTH);
//         add(centerPanel, BorderLayout.CENTER);
//         add(leftPanel, BorderLayout.WEST);
//         add(rightPanel, BorderLayout.EAST);
//     }

//     public GameField getCenterPanel() { // Изменяем тип возвращаемого значения
//         return centerPanel;
//     }
// }

import javax.swing.*;

import Meneger.GameManager.GameManager;
import Unit.Unit;
import View.GameView;
import View.Panel.GameField.GameField;

import java.awt.*;
import java.util.ArrayList;

public class MainPanel extends JPanel {
    private GameView gameView;
    private GameField centerPanel;
    private JTextArea leftTextArea; // Добавляем текстовые области для каждой команды
    private JTextArea rightTextArea;

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

        // Создаем текстовые области для каждой команды
        leftTextArea = new JTextArea();
        leftTextArea.setEditable(false); // Запрещаем редактирование
        leftPanel.add(leftTextArea); // Добавляем текстовую область в левую панель

        rightTextArea = new JTextArea();
        rightTextArea.setEditable(false); // Запрещаем редактирование
        rightPanel.add(rightTextArea); // Добавляем текстовую область в правую панель

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.EAST);
    }

    // Метод для обновления текстовых областей с информацией о юнитах
    // public void updateTextAreas() {
    //     // Очищаем текстовые области перед обновлением
    //     leftTextArea.setText("");
    //     rightTextArea.setText("");

    //     // Получаем список юнитов каждой команды
    //     ArrayList<Unit> team1 = GameManager.getTeam1();
    //     ArrayList<Unit> team2 = GameManager.getTeam2();

    //     // Обновляем информацию о юнитах в текстовых областях
    //     leftTextArea.append("Команда 1:\n");
    //     for (Unit unit : team1) {
    //         leftTextArea.append(unit.toString() + "\n");
    //     }

    //     rightTextArea.append("Команда 2:\n");
    //     for (Unit unit : team2) {
    //         rightTextArea.append(unit.toString() + "\n");
    //     }
    // }
    public void updateTextAreas() {
        clearTextAreas();
        updateTeamInformation();
    }
    
    private void clearTextAreas() {
        leftTextArea.setText("");
        rightTextArea.setText("");
    }
    
    private void updateTeamInformation() {
        updateTeam(leftTextArea, "Команда 1", GameManager.getTeam1());
        updateTeam(rightTextArea, "Команда 2", GameManager.getTeam2());
    }
    
    private void updateTeam(JTextArea textArea, String teamName, ArrayList<Unit> team) {
        textArea.append(teamName + ":\n");
        for (Unit unit : team) {
            textArea.append(unit.toStringForPartPanel() + "\n");
        }
    }
    

    public GameField getCenterPanel() {
        return centerPanel;
    }
}
