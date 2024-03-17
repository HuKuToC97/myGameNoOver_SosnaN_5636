import Meneger.GameManager.GameManager;

import View.GameView;

public class App {
    public static void main(String[] args) {
        GameView gameView = new GameView(); // Создаем экземпляр GameView
        GameManager gameManager = new GameManager(gameView); 
        gameManager.startGame(); 
    }
}