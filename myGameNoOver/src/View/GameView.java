// package View; 

// import javax.swing.*;
// import java.awt.*;
// import java.net.URL;

// public class GameView {
//     private JFrame frame;
//     private JPanel mainPanel; // Поля класса

//     public GameView(int widthFrame, int heightFrame) { // Конструктор класса с параметрами
//         initialize(widthFrame, heightFrame); // Вынесение логики инициализации в отдельный метод
//     }

//     public GameView() { // Перегруженный конструктор с использованием значений по умолчанию
//         this(900, 550);
//     }

//     private void initialize(int widthFrame, int heightFrame) { // Метод инициализации окна
//         frame = new JFrame("GameNoOver");
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         frame.setSize(widthFrame, heightFrame);

//         mainPanel = createMainPanel(); // Инициализация главной панели
//         frame.setContentPane(mainPanel);

//         centerFrameOnScreen(); // Вызов метода центрирования окна на экране
//         setIcon("icon/iconGame.png"); // Установка иконки окна
//         frame.setVisible(true);
//     }

//     private JPanel createMainPanel() { // Метод создания главной панели
//         mainPanel = new JPanel(new BorderLayout());
//         mainPanel.setBackground(Color.BLACK);

//         JPanel topPanel = createSidePanel(50, BorderLayout.NORTH); // Создание верхней панели
//         JPanel leftPanel = createSidePanel(200, BorderLayout.WEST); // Создание левой панели
//         JPanel rightPanel = createSidePanel(200, BorderLayout.EAST); // Создание правой панели
//         JPanel centerPanel = new JPanel(); // Создание центральной панели

//         centerPanel.setBackground(Color.BLACK);

//         mainPanel.add(topPanel, BorderLayout.NORTH);
//         mainPanel.add(centerPanel, BorderLayout.CENTER);
//         mainPanel.add(leftPanel, BorderLayout.WEST);
//         mainPanel.add(rightPanel, BorderLayout.EAST);

//         return mainPanel;
//     }

//     private JPanel createSidePanel(int size, String position) { // Метод для создания боковых панелей
//         JPanel sidePanel = new JPanel(); // Создание панели
//         sidePanel.setPreferredSize(position.equals(BorderLayout.NORTH) || position.equals(BorderLayout.SOUTH)
//                 ? new Dimension(mainPanel.getWidth(), size)
//                 : new Dimension(size, mainPanel.getHeight())); // Установка размера в зависимости от положения

//         sidePanel.setBackground(Color.GRAY);
//         sidePanel.setBorder(BorderFactory.createLineBorder(Color.WHITE)); // Добавление белой границы

//         return sidePanel;
//     }

//     private void centerFrameOnScreen() { // Метод для центрирования окна на экране
//         Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//         int centerX = (int) ((screenSize.getWidth() - frame.getWidth()) / 2);
//         int centerY = (int) ((screenSize.getHeight() - frame.getHeight()) / 2);
//         frame.setLocation(centerX, centerY);
//     }

//     private void setIcon(String pathToIcon) { // Метод для установки иконки окна
//         URL iconURL = getClass().getResource(pathToIcon);
//         if (iconURL != null) {
//             ImageIcon icon = new ImageIcon(iconURL);
//             frame.setIconImage(icon.getImage());
//         } else {
//             System.out.println("Файл иконки не найден!");
//         }
//     }

//     public JFrame getFrame() { // Геттер для получения окна
//         return frame;
//     }
// }

// Файл GameView.java
// Файл GameView.java
package View;

import javax.swing.*;

import java.awt.*;

public class GameView {
    private JFrame frame;
    private JPanel mainPanel;

    public GameView(int widthFrame, int heightFrame) {
        initialize(widthFrame, heightFrame);
    }

    public GameView() {
        this(900, 550);
    }

    private void initialize(int widthFrame, int heightFrame) {
        frame = new JFrame("GameNoOver");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(widthFrame, heightFrame);

        mainPanel = new MainPanel(this).createMainPanel(); // Передаем ссылку на GameView в конструктор MainPanel
        frame.setContentPane(mainPanel);

        FrameUtil frameUtil = new FrameUtil();
        frameUtil.centerFrameOnScreen(frame, this); // Передаем ссылку на GameView в метод centerFrameOnScreen
        frameUtil.setIcon(frame, "icon/iconGame.png"); // Оставляем вызов метода setIcon без изменений
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

}
