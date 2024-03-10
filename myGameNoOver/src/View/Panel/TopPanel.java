package View.Panel;

import javax.swing.*;

import Meneger.GameManager.GameManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopPanel extends JPanel {
    private JButton stepButton;
    private JButton exitButton;

    public TopPanel() {
        setPreferredSize(new Dimension(0, 50));
        setBackground(Color.GRAY);
        setBorder(BorderFactory.createLineBorder(Color.WHITE));

        // Создание кнопки "Сделать шаг"
        stepButton = new JButton("Сделать шаг");
        stepButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameManager.continuationFlag = true; // Устанавливаем флаг продолжения игры в true
            }
        });

        // Создание кнопки "Выход из игры"
        exitButton = new JButton("Выход из игры");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameManager.continuationFlag = false; // Устанавливаем флаг продолжения игры в false
            }
        });

        // Добавление кнопок на панель
        add(stepButton);
        add(exitButton);
    }
}
