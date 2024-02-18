package Unit.Auxiliary;

public class Location2D {
    int x;
    int y;


    public Location2D(int x, int y){
    this.x = x;
    this.y = y;
    }

    public Location2D(){
        this(0, 0);
    }

    @Override
    public String toString() {
        
        return "Координаты игрока x: " + x + ", y: " + y;
    }
    
}
