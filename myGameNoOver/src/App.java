import сreatures.Animal.Animal;
import сreatures.Human.ContactCharacter.Worker.Peasant;

public class App {
    /**
     * @param args
     */
    public static void main(String[] args) {

        Animal kapibara = new Animal("Константин", 
        "Капибара", 
        1000000, 
        1000000,       
        1000000, 
        10000000, 
        100, 50, 150, 100);
        kapibara.showInfoLabel();
        System.out.println(kapibara);

        Peasant peasant = new Peasant("Иван");
        

    }
}