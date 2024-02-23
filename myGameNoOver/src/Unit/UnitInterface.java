package Unit;

import java.util.ArrayList;

public interface UnitInterface {
    // default public void dead() {
    //     isDead = true;
    //     System.out.println(this + "- умер");
    // }
    public void step(ArrayList<Unit> target);
}
