package View.Panel;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import Unit.Unit;

import java.awt.*;
import java.util.ArrayList;

public class LeftPanel extends JPanel {
    private JTextPane leftTextPane;

    public LeftPanel() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(200, 0));
        setBackground(Color.GRAY);
        setBorder(BorderFactory.createLineBorder(Color.WHITE));

        leftTextPane = new JTextPane();
        leftTextPane.setEditable(false);
        leftTextPane.setBackground(Color.BLACK);
        leftTextPane.setForeground(Color.WHITE);
        StyledDocument doc = leftTextPane.getStyledDocument();
        addStyles(doc);

        add(leftTextPane, BorderLayout.CENTER);
    }

    private void addStyles(StyledDocument doc) {
        Style defaultStyle = doc.addStyle("default", null);
        StyleConstants.setFontFamily(defaultStyle, "Arial");
        StyleConstants.setFontSize(defaultStyle, 12);
    }

    public void updateTeamInformation(ArrayList<Unit> team) {
        StyledDocument doc = leftTextPane.getStyledDocument();
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
        Style style = leftTextPane.getStyledDocument().getStyle("other");
        return style;
    }

    public JTextPane getLeftTextPane() {
        return leftTextPane;
    }
}
