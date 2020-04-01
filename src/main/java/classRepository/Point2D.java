package classRepository;

public class Point2D {
    private double x;
    private double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point2D(){
        this(0,0);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distanceFromPoint(Point2D point2D){
        return Math.sqrt(Math.pow(x - point2D.x,2) + Math.pow(y - point2D.y,2));
    }

    public double module(){
        return distanceFromPoint(new Point2D());
    }
}
