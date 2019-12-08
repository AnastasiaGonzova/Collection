package classes;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int[] getXY(){
        int[] xy = new int[2];
        xy[0] = x;
        xy[1] = y;
        return xy;
    }

    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }

    public double distance(){
        return sqrt(pow(this.x, 2) + pow(this.y,2));
    }

    public double distance(int x, int y){
        return sqrt(pow(x - this.x, 2) + pow(y - this.y,2));
    }

    public double distance(Point p){
        return sqrt(pow(p.x - this.x, 2) + pow(p.y - this.y,2));
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Float.compare(point.x, x) == 0 && Float.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        int result = 7;
        result = 31*result + Integer.hashCode(x);
        result = 31*result + Integer.hashCode(y);
        return result;
    }
}
