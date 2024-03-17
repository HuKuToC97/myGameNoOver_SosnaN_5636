package View.Panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopPanel extends JPanel {
    private JButton stepButton;
    private JButton exitButton;
    private JTextField textField;

    public TopPanel() {
        setPreferredSize(new Dimension(0, 50));
        setBackground(Color.GRAY);
        setBorder(BorderFactory.createLineBorder(Color.WHITE));

        // Создаем панель для кнопок и устанавливаем для нее FlowLayout
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setBackground(Color.GRAY);

        // Создание кнопки "Сделать шаг"
        stepButton = new JButton("Сделать шаг");
        stepButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyStep(); // Оповещаем TopPanel о событии
            }
        });

        // Создание кнопки "Выход из игры"
        exitButton = new JButton("Выход из игры");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Добавляем кнопки на панель
        buttonPanel.add(stepButton);
        buttonPanel.add(exitButton);

        // Создаем текстовое поле
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(200, 40)); // Устанавливаем размер текстового поля
        textField.setHorizontalAlignment(JTextField.CENTER); // Выравниваем текст по центру

        // Добавляем панель с кнопками и текстовое поле на TopPanel
        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.WEST);
        add(textField, BorderLayout.CENTER);
    }

    // Метод для оповещения о событии "Сделать шаг"
    public void notifyStep() {
        synchronized (this) {
            notify(); // Оповещаем объект TopPanel
        }
    }

    public void waitForStep() {
        synchronized (this) {
            try {
                wait(); // Ожидаем уведомления о нажатии кнопки
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 
    // Getters and setters
    // 
    
    public JTextField getTextField() {
        return textField;
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }
}
