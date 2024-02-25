package Unit.Auxiliary;

public class Location2DDifference {
    private int dX;
    private int dY;


    public Location2DDifference(int dX, int dY) {
        this.dX = dX;
        this.dY = dY;
    }

    public int getdX() {
        return dX;
    }

    public int getdY() {
        return dY;
    }

    public int getAbsdX() {
        return Math.abs(dX);
    }

    public int getAbsdY() {
        return Math.abs(dY);
    }

    public int getSignumdX() {
        return (int) Math.signum(dX);
    }

    public int getSignumdY() {
        return (int) Math.signum(dY);
    }

}
