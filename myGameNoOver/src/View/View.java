package View;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class View {
    static {
        int widthWindow;
        int heightWindow;

    }
    public static void view() {
        JFrame jFrame = init();

    }

    public static JFrame init() {
        JFrame jFrame = new JFrame("GameNoOver");
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(300, 300);
        jFrame.setLocation(300, 300);
        // jFrame.setTitle(null);
        ImageIcon icon = new ImageIcon("icon/iconGame.jpg"); // Путь к файлу с изображением
        jFrame.setIconImage(icon.getImage());
        
        return jFrame;
    }
}
