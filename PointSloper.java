/*************************************************************************
 *  Compilation:  javac PointSloper.java
 *  Execution:    java PointSloper input.txt
 *  Dependencies: Point.java, In.java, StdDraw.java
 *
 *  Takes the name of a file as a command-line argument.
 *  Reads in an integer N followed by N pairs of points (x, y)
 *  with coordinates between 0 and 32,767, and calculates the slope
 *  between some of those points.
 *
 *************************************************************************/

public class PointSloper {
    public static void main(String[] args) {

        // read in the input
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            Point p = new Point(x, y);
            points[i] = p;
        }

        StdOut.print(points[3] + " " + points[4] + "\n");
        double slope = points[3].slopeTo(points[4]);
        StdOut.print("Slope: " + slope + "\n");
        
    }
}