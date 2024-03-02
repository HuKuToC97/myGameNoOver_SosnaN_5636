// Файл FrameUtil.java
package View;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class FrameUtil {
    public void centerFrameOnScreen(JFrame frame, GameView gameView) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int) ((screenSize.getWidth() - frame.getWidth()) / 2);
        int centerY = (int) ((screenSize.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(centerX, centerY);

        // Обращение к приватному полю mainPanel через геттер
        JPanel mainPanel = gameView.getMainPanel();
        if (mainPanel != null) {
            mainPanel.revalidate();
            mainPanel.repaint();
        }
    }

    public void setIcon(JFrame frame, String pathToIcon) {
        URL iconURL = getClass().getResource(pathToIcon);
        if (iconURL != null) {
            ImageIcon icon = new ImageIcon(iconURL);
            frame.setIconImage(icon.getImage());
        } else {
            System.out.println("Файл иконки не найден!");
        }
    }
}
