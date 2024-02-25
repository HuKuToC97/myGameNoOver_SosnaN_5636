package Unit.Auxiliary;

public class Location2D {
    private int x;
    private int y;

    public Location2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Location2D() {
        this(0, 0);
    }

    @Override
    public String toString() {

        return "x: " + x + ", y: " + y;
    }

    public double calculateDistance(Location2D other) {
        int deltaX = this.x - other.x;
        int deltaY = this.y - other.y;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    //
    // Getters and setters
    //
    
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
