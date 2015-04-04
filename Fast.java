/*************************************************************************
 *  Compilation:  javac Fast.java
 *  Execution:    java Fast input.txt
 *  Dependencies: Point.java, In.java, StdDraw.java
 *************************************************************************/

import java.util.Arrays;
    
public class Fast {
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
        Point[] slopes = new Point[N];
        for (int i = 0; i < N; i++) {
            int x = in.readInt();
            int y = in.readInt();
            Point p = new Point(x, y);
            p.draw();
            points[i] = p;
            slopes[i] = p;
        }
        
        // reset the pen radius
        StdDraw.setPenRadius();
        
        /*StdOut.print("Before:" + "\n");
        for (int i = 0; i < N; i++) {
            StdOut.print(points[i] + " ");
        }
        StdOut.print("\n");*/
        
        //sort points in natural order
        Arrays.sort(points, 0, points.length);
        for (int i = 0; i < N; i++) {
            
            // origin
            Point p = points[i];
            
            // sort points according to slopes they make with p in a second array
            Arrays.sort(slopes, 0, slopes.length, p.SLOPE_ORDER);
            
            // check if 3 or more adjacent points have equal slopes to origin
            int count = 1;
            for (int j = 0; j < N; j++) {
                
                // get the j-th point's slope with reference to the origin
                double slope = points[i].slopeTo(slopes[j]);
                
                if (j-1 >= 0) {
                    double slopelast = points[i].slopeTo(slopes[j-1]);
                    if (slope == slopelast) count++;
                    else                    count = 1;
                }
                
                if (j+1 < N) {
                    double slopenext = points[i].slopeTo(slopes[j+1]);
                    if (count > 2 && slope != slopenext) {
                        Point[] print = new Point[count];
                        for (int k = 0; k < count; k++) {
                            print[k] = slopes[j-count+1];
                        }
                        Arrays.sort(print, 0, print.length);
                        print[0].drawTo(print[count-1]);
                    }
                }
                
                /*if (j-2 >=0) {
                    double slopelast = points[i].slopeTo(slopes[j-1]);
                    double slopelastlast = points[i].slopeTo(slopes[j-2]);
                    if (slope == slopelast && slopelastlast == slopelast) {
                        if (points[i].compareTo(slopes[j-2]) < 0
                                    && points[i].compareTo(slopes[j-1]) < 0
                                    && points[i].compareTo(slopes[j]) < 0) {
                            StdOut.print(points[i].toString()
                                             + " -> " + slopes[j-2].toString()
                                             + " -> " + slopes[j-1].toString()
                                             + " -> " + slopes[j].toString()
                                             + "\n");
                            points[i].drawTo(slopes[j]);
                        }
                    }
                }*/
                //StdOut.print(count + "\n");
            }
         }
    
  
            // print the points and p
            
            /*StdOut.print("Slopes after sorting:\n");
            for (int j = 0; j < N; j++) {
                StdOut.print(points[i].slopeTo(slopes[j]) + " ");
            }
            StdOut.print("\n");*/

        // display to screen all at once
        StdDraw.show(0);
    }
}