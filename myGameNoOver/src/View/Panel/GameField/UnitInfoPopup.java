package View.Panel.GameField;

import javax.swing.*;

import Unit.Unit;

import java.awt.*;

public class UnitInfoPopup extends JToolTip {
    private Unit unit; // Персонаж, информацию о котором мы будем отображать

    public UnitInfoPopup(Unit unit) {
        this.unit = unit;
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(200, 100)); // Задаем размер всплывающего окна

        // Создаем компоненты для отображения информации о персонаже
        JLabel nameLabel = new JLabel("Name: " + unit.getName());
        JLabel typeLabel = new JLabel("Type: " + unit.getTypeUnit());
        JLabel hpLabel = new JLabel("HP: " + unit.getHitPoints() + "/" + unit.getMaxHitPoints());
        
        // Добавляем компоненты на панель
        JPanel panel = new JPanel(new GridLayout(3, 1));
        panel.add(nameLabel);
        panel.add(typeLabel);
        panel.add(hpLabel);
        
        add(panel, BorderLayout.CENTER);
    }
}
