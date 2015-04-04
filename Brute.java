/*************************************************************************
 *  Compilation:  javac Brute.java
 *  Execution:    java Brute input.txt
 *  Dependencies: Point.java, In.java, StdDraw.java
 *************************************************************************/

import java.util.Arrays;

public class Brute {
    public static void main(String[] args) {
        
        // rescale coordinates and turn on animation mode
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.show(0);
        StdDraw.setPenRadius(0.01);  // make the points a bit larger

        // read in the input
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            Point p = new Point(x, y);
            p.draw();
            points[i] = p;
        }
        
        // reset the pen radius
        StdDraw.setPenRadius();
        
        Arrays.sort(points, 0, points.length);
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    for (int l = 0; l < N; l++) {
                        
                        // calculate slopes
                        double slopeone = points[i].slopeTo(points[j]);
                        double slopetwo = points[i].slopeTo(points[k]);
                        double slopethree = points[i].slopeTo(points[l]);
                        
                        // draw line segments
                        if (slopeone == slopetwo && slopetwo == slopethree) {
                            if (points[i].compareTo(points[j]) < 0
                                    && points[j].compareTo(points[k]) < 0
                                    && points[k].compareTo(points[l]) < 0) {
                                StdOut.print(points[i].toString()
                                                 + " -> " + points[j].toString()
                                                 + " -> " + points[k].toString()
                                                 + " -> " + points[l].toString()
                                                 + "\n");
                                points[i].drawTo(points[l]);
                            }
                        }
                    }
                }
            }
        }

        // display to screen all at once
        StdDraw.show(0);
    }
}