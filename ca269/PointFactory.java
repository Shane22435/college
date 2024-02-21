enum Quadrant {
    Q1, // x +ve, y +ve
    Q2, // x -ve, y +ve
    Q3, // x -ve, y -ve
    Q4; // x +ve, y -ve
}

interface GridQuadrant {
    Quadrant getQuadrant(); // return which quadrant the point is in
    // if point is at (0,0) return null
}
// TODO: modify Point to implement GridQuadrant

interface CompareQuadrant {
    boolean isInSameQuadrant(Point p); // true if given point is
    // in the same quadrant as this point
}
// TODO: modify Point to implement CompareQuadrant

class Point implements GridQuadrant, CompareQuadrant {

    private double x, y;
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public Quadrant getQuadrant() {
        if (x > 0 && y > 0) return Quadrant.Q1;
        if (x < 0 && y > 0) return Quadrant.Q2;
        if (x < 0 && y < 0) return Quadrant.Q3;
        if (x > 0 && y < 0) return Quadrant.Q4;
        return null;
    }
    public boolean isInSameQuadrant(Point p) {
        return getQuadrant() == p.getQuadrant();
    }
}

interface PointMaker {
    Point makePoint(double x, double y); // returns point with given x,y
    int countPointsCreated(); // returns count of points created via factory
}

class PointFactory implements PointMaker {
    private int count = 0;
    public Point makePoint(double x, double y) {
        count++;
        return new Point(x, y);
    }
    public int countPointsCreated() {
        return count;
    }
}   