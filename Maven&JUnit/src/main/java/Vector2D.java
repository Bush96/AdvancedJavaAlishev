public class Vector2D {
    private double y;
    private double x;


    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }


    public double lenght() {
        return Math.sqrt(x * x + y * y);
    }
}
