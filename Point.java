/*************************************************************************
 * Name: Andrea Clausen
 *
 * Compilation:  javac Point.java
 * Execution:
 * Dependencies: StdDraw.java
 *
 * Description: An immutable data type for points in the plane.
 *
 *************************************************************************/

import java.util.Comparator;

public class Point implements Comparable<Point> {

    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER = new SlopeOrder();

    private final int x;                              // x coordinate
    private final int y;                              // y coordinate
        
    private class SlopeOrder implements Comparator<Point> {
        public int compare(Point q, Point r) {
            
            //calculate slopes with this point
            double s1 = slopeTo(q);
            double s2 = slopeTo(r);
            
            if (s1 < s2) return -1; // q is less than r
            if (s1 > s2) return +1; // q is larger than r
            return 0;               // q and r are equal

        }
    }

    // create the point (x, y)
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // slope between this point and that point
    public double slopeTo(Point that) {
        /* YOUR CODE HERE */
        // slope of a degenerate line segment (between a point and itself) is negative infinity
        if (this.x == that.x && this.y == that.y) {
            return Double.NEGATIVE_INFINITY;
        }
        // slope of a vertical line segment is positive infinity
        else if (this.x == that.x) {
            return Double.POSITIVE_INFINITY;
        }
        // return slope for all other line segments and positive zero for horizontal slopes
        else {
            double slope = (((double) that.y) - ((double) this.y)) / (((double) that.x) - ((double) this.x));
            if (slope == -0.0) return 0.0;
            else               return slope;
        }
    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    public int compareTo(Point that) {
        /* YOUR CODE HERE */
        // returns -1 if this point is smaller than that one
        // returns +1 if this point is larger than that one
        // returns 0 if the points are the same     
        if (this.y < that.y) return -1;
        if (this.y > that.y) return +1;
        if (this.x < that.x) return -1;
        if (this.x > that.x) return +1;
        return 0;
    }

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    // unit test
    public static void main(String[] args) {
        /* YOUR CODE HERE */
    }
}