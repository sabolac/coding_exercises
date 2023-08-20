package my.code;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Section12
{
    public static void main(String[] args)
    {
        StdOut.println(">>>>>>>>> Start Execution");
        StdOut.printf(">>>>>>>>> Working dir:%s\n", System.getProperty("user.dir"));
        StdOut.printf(">>>>>>>>> Java Version:%s\n", System.getProperty("java.version"));
        StdOut.printf(">>>>>>>>> JAVA_HOME:%s\n", System.getProperty("java.home"));
        StdOut.printf(">>>>>>>>> CLASSPATH:%s\n", System.getProperty("java.class.path"));
        long start = System.currentTimeMillis();

        exercise_1_2_1();

        long end = System.currentTimeMillis();
        StdOut.printf(">>>>>>>>> total time in milliseconds:%s\n", end - start);
        StdOut.println(">>>>>>>>> End Execution");
    }

    public static void exercise_1_2_1()
    {
        // Write a Point2D client that takes an integer value N from the command line,
        // generates N random points in the unit square, and computes the distance
        // separating the closest pair of points.
        int N = 20;
        Point2D[] p = new Point2D[N];

        StdDraw.setCanvasSize(1000, 1000);
        StdDraw.enableDoubleBuffering();
        StdDraw.setPenRadius(0.02);
        for (int i = 0; i < N; i++)
        {
            p[i] = new Point2D(StdRandom.uniformDouble(), StdRandom.uniformDouble());
            p[i].draw();
        }

        Point2D a = p[0], b = p[1];
        double distance, minDistance = Double.MAX_VALUE;
        for (int i = 0; i < N - 1; i++)
        {
            for (int j = i + 1; j < N; j++)
            {
                distance = p[i].distanceTo(p[j]);
                if (distance < minDistance)
                {
                    minDistance = distance;
                    a = p[i];
                    b = p[j];
                }
            }
        }
        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        a.drawTo(b);
        StdOut.printf("shortest distance: %f\n", minDistance);
        StdDraw.show();
    }
}
