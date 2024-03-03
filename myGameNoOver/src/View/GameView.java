package View;

import javax.swing.*;

import View.Panel.MainPanel;

public class GameView {
    private JFrame frame;
    private MainPanel mainPanel;

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

        this.mainPanel = new MainPanel(this); // Передаем ссылку на GameView в конструктор MainPanel
        frame.setContentPane(mainPanel);

        FrameUtil frameUtil = new FrameUtil();
        frameUtil.centerFrameOnScreen(frame, this); // Передаем ссылку на GameView в метод centerFrameOnScreen
        frameUtil.setIcon(frame, "icon/iconGame.png"); 
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public JPanel getMainJPanel() {
        return mainPanel;
    }
    
    public MainPanel getMainPanel() {
        return mainPanel;
    }

}
