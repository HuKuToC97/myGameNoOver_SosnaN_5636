// package View.Panel;

// import javax.swing.*;

// import Meneger.GameManager.GameManager;
// import Unit.Unit;
// import View.GameView;
// import View.Panel.GameField.GameField;

// import java.awt.*;
// import java.util.ArrayList;

// public class MainPanel extends JPanel {
//     private GameView gameView;
//     private GameField centerPanel;
//     private JTextArea leftTextArea; // Добавляем текстовые области для каждой команды
//     private JTextArea rightTextArea;

//     public MainPanel(GameView gameView) {
//         this.gameView = gameView;
//         createMainPanel();
//     }

//     private void createMainPanel() {
//         setLayout(new BorderLayout());
//         setBackground(Color.BLACK);
    
//         JPanel topPanel = createTopPanel();
//         JPanel leftPanel = createLeftPanel();
//         JPanel rightPanel = createRightPanel();
//         centerPanel = new GameField();
    
//         centerPanel.setBackground(Color.BLACK);
    
//         add(topPanel, BorderLayout.NORTH);
//         add(centerPanel, BorderLayout.CENTER);
//         add(leftPanel, BorderLayout.WEST);
//         add(rightPanel, BorderLayout.EAST);
//     }
    
//     private JPanel createTopPanel() {
//         return new PartPanel(gameView).createSidePanel(50, BorderLayout.NORTH);
//     }
    
//     private JPanel createLeftPanel() {
//         JPanel leftPanel = new PartPanel(gameView).createSidePanel(200, BorderLayout.WEST);
//         leftTextArea = createTextArea();
//         leftPanel.add(leftTextArea);
//         return leftPanel;
//     }
    
//     private JPanel createRightPanel() {
//         JPanel rightPanel = new PartPanel(gameView).createSidePanel(200, BorderLayout.EAST);
//         rightTextArea = createTextArea();
//         rightPanel.add(rightTextArea);
//         return rightPanel;
//     }
    
//     private JTextArea createTextArea() {
//         JTextArea textArea = new JTextArea();
//         textArea.setEditable(false); // Запрещаем редактирование
//         return textArea;
//     }

//     public void updateTextAreas() {
//         clearTextAreas();
//         updateTeamInformation();
//     }
    
//     private void clearTextAreas() {
//         leftTextArea.setText("");
//         rightTextArea.setText("");
//     }
    
//     private void updateTeamInformation() {
//         updateTeam(leftTextArea, "Команда 1", GameManager.getTeam1());
//         updateTeam(rightTextArea, "Команда 2", GameManager.getTeam2());
//     }
    
//     private void updateTeam(JTextArea textArea, String teamName, ArrayList<Unit> team) {
//         textArea.append(teamName + ":\n");
//         for (Unit unit : team) {
//             textArea.append(unit.toStringForPartPanel() + "\n");
//         }
//     }
    

//     public GameField getCenterPanel() {
//         return centerPanel;
//     }
// }

package View.Panel;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.Style;


import Meneger.GameManager.GameManager;
import Unit.Unit;
import View.GameView;
import View.Panel.GameField.GameField;
import java.awt.*;
import java.util.ArrayList;

public class MainPanel extends JPanel {
    private GameView gameView;
    private GameField centerPanel;
    private JTextPane leftTextPane;
    private JTextPane rightTextPane;

    public MainPanel(GameView gameView) {
        this.gameView = gameView;
        createMainPanel();
    }

    private void createMainPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);
    
        JPanel topPanel = createTopPanel();
        JPanel leftPanel = createLeftPanel();
        JPanel rightPanel = createRightPanel();
        centerPanel = new GameField();
    
        centerPanel.setBackground(Color.BLACK);
    
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.EAST);
    }
    
    private JPanel createTopPanel() {
        return new PartPanel(gameView).createSidePanel(50, BorderLayout.NORTH);
    }
    
    private JPanel createLeftPanel() {
        JPanel leftPanel = new PartPanel(gameView).createSidePanel(200, BorderLayout.WEST);
        leftTextPane = createTextPane();
        leftPanel.add(leftTextPane);
        return leftPanel;
    }
    
    private JPanel createRightPanel() {
        JPanel rightPanel = new PartPanel(gameView).createSidePanel(200, BorderLayout.EAST);
        rightTextPane = createTextPane();
        rightPanel.add(rightTextPane);
        return rightPanel;
    }
    
    private JTextPane createTextPane() {
        JTextPane textPane = new JTextPane();
        textPane.setEditable(false);
        textPane.setBackground(Color.BLACK);
        textPane.setForeground(Color.WHITE);
        StyledDocument doc = textPane.getStyledDocument();
        addStyles(doc);
        return textPane;
    }

    private void addStyles(StyledDocument doc) {
        Style defaultStyle = doc.addStyle("default", null);
        StyleConstants.setFontFamily(defaultStyle, "Arial");
        StyleConstants.setFontSize(defaultStyle, 12);

        Style unitTypeStyle = doc.addStyle("unitType", defaultStyle);
        StyleConstants.setBold(unitTypeStyle, true);
        StyleConstants.setForeground(unitTypeStyle, Color.YELLOW);

        Style hpStyle = doc.addStyle("hp", defaultStyle);
        StyleConstants.setForeground(hpStyle, Color.RED);

        Style otherStyle = doc.addStyle("other", defaultStyle);
        StyleConstants.setForeground(otherStyle, Color.WHITE);
    }

    public void updateTextAreas() {
        clearTextAreas();
        updateTeamInformation();
    }
    
    private void clearTextAreas() {
        leftTextPane.setText("");
        rightTextPane.setText("");
    }
    
    private void updateTeamInformation() {
        updateTeam(leftTextPane, "Команда 1", GameManager.getTeam1());
        updateTeam(rightTextPane, "Команда 2", GameManager.getTeam2());
    }
    
    private void updateTeam(JTextPane textPane, String teamName, ArrayList<Unit> team) {
        StyledDocument doc = textPane.getStyledDocument();
        try {
            doc.insertString(doc.getLength(), teamName + ":\n", doc.getStyle("unitType"));
            for (Unit unit : team) {
                String unitInfo = unit.toStringForPartPanel() + "\n";
                doc.insertString(doc.getLength(), unitInfo, getUnitStyle(unit));
            }
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    private Style getUnitStyle(Unit unit) {
        Style style = leftTextPane.getStyledDocument().getStyle("other");
        switch (unit.getTypeUnit()) {
            case "Hunter":
                StyleConstants.setForeground(style, Color.GREEN);
                break;
            case "Robber":
                StyleConstants.setForeground(style, Color.ORANGE);
                break;
            case "Peasant":
                StyleConstants.setForeground(style, Color.YELLOW);
                break;
            case "Squire":
                StyleConstants.setForeground(style, Color.CYAN);
                break;
            case "Monk":
                StyleConstants.setForeground(style, Color.MAGENTA);
                break;
            case "Witch":
                StyleConstants.setForeground(style, Color.PINK);
                break;
            case "Archer":
                StyleConstants.setForeground(style, Color.BLUE);
                break;
            case "Crossbowman":
                StyleConstants.setForeground(style, Color.RED);
                break;
            case "Sniper":
                StyleConstants.setForeground(style, Color.WHITE);
                break;
            default:
                StyleConstants.setForeground(style, Color.WHITE);
        }
        return style;
    }

    public GameField getCenterPanel() {
        return centerPanel;
    }
}
