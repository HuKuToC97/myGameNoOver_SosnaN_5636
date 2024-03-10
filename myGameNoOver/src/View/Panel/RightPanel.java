package View.Panel;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import Unit.Unit;

import java.awt.*;
import java.util.ArrayList;

public class RightPanel extends JPanel {
    private JTextPane rightTextPane;

    public RightPanel() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(200, 0));
        setBackground(Color.GRAY);
        setBorder(BorderFactory.createLineBorder(Color.WHITE));

        rightTextPane = new JTextPane();
        rightTextPane.setEditable(false);
        rightTextPane.setBackground(Color.BLACK);
        rightTextPane.setForeground(Color.WHITE);
        StyledDocument doc = rightTextPane.getStyledDocument();
        addStyles(doc);

        add(rightTextPane, BorderLayout.CENTER);
    }

    private void addStyles(StyledDocument doc) {
        Style defaultStyle = doc.addStyle("default", null);
        StyleConstants.setFontFamily(defaultStyle, "Arial");
        StyleConstants.setFontSize(defaultStyle, 12);
    }

    public void updateTeamInformation(ArrayList<Unit> team) {
        StyledDocument doc = rightTextPane.getStyledDocument();
        try {
            doc.remove(0, doc.getLength()); 

            for (Unit unit : team) {
                String unitInfo = unit.toStringForPartPanel() + "\n";
                doc.insertString(doc.getLength(), unitInfo, getUnitStyle(unit));
            }
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    private Style getUnitStyle(Unit unit) {
        Style style = rightTextPane.getStyledDocument().getStyle("other");
        return style;
    }

    public JTextPane getRightTextPane() {
        return rightTextPane;
    }
}
