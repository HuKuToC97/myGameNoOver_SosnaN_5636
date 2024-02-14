import сreatures.Animal;
import сreatures.Auxiliary.Location2D;

public class App {
    /**
     * @param args
     */
    public static void main(String[] args) {

        Animal kapibara = new Animal("Константин", 
        "Капибара", 
        100, 
        1000000,       
        1000000, 
        new Location2D(), 
        100, 
        100, 50, 150, 100);
                System.out.println(kapibara.toString());
                System.out.println("123");
    }
}