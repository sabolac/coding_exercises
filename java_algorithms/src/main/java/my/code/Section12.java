package my.code;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
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

        exercise_1_2_3();

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

    public static void exercise_1_2_2()
    {
        // Write an Interval1D client that takes an int value N as command-line
        // argument, reads N intervals (each defined by a pair of double values) from
        // standard input, and prints all pairs that intersect.
        int N = 20;
        Interval1D[] a = new Interval1D[N];

        StdDraw.setCanvasSize(1200, 1200);
        StdDraw.setPenRadius(0.005);
        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-.05, 1.05);
        StdDraw.rectangle(0.5, 0.5, 0.52, 0.52);
        double min, max;
        for (int i = 0; i < N; i++)
        {
            max = StdRandom.uniformDouble();
            min = StdRandom.uniformDouble(0, max);
            a[i] = new Interval1D(min, max);
        }
        double yDelta = 0.005;
        double y = 0;
        boolean match;
        for (int i = 0; i < N - 1; i++)
        {
            match = false;
            StdDraw.setPenColor(StdDraw.BOOK_BLUE);
            for (int j = i + 1; j < N; j++)
            {
                if (a[i].intersects(a[j]))
                {
                    match = true;
                    y += yDelta;
                    StdDraw.line(a[j].min(), y, a[j].max(), y);
                }
            }
            if (match)
            {
                y += yDelta;
                StdDraw.setPenColor(StdDraw.BOOK_RED);
                StdDraw.line(a[i].min(), y, a[i].max(), y);
            }
            y += 0.02 / N * N;
        }

        StdDraw.show();
    }

    public static void exercise_1_2_3()
    {
        // Write an Interval2D client that takes command-line arguments N, min, and max
        // and generates N random 2D intervals whose width and height are uniformly
        // distributed between min and max in the unit square. Draw them on StdDraw and
        // print the number of pairs of intervals that intersect and the number of
        // intervals that are contained in one another.
        int N = 100;
        Interval2D[] p = new Interval2D[N];

        // since Interval2D does not expose any means of retrieving its coordinates
        // back, we need to keep track of them ourselves
        Interval1D[][] d = new Interval1D[N][2];

        double maxSide = StdRandom.uniformDouble();
        double minSide = StdRandom.uniformDouble(0, maxSide);

        double x1, x2, y1, y2;
        for (int i = 0; i < N; i++)
        {
            x1 = StdRandom.uniformDouble(0, 1.0 - minSide);
            x2 = StdRandom.uniformDouble(x1, Math.min(x1 + maxSide, 1.0));

            y1 = StdRandom.uniformDouble(0, 1.0 - minSide);
            y2 = StdRandom.uniformDouble(y1, Math.min(y1 + maxSide, 1.0));

            d[i][0] = new Interval1D(x1, x2);
            d[i][1] = new Interval1D(y1, y2);
            p[i] = new Interval2D(d[i][0], d[i][1]);
        }

        StdDraw.setCanvasSize(1200, 1200);
        StdDraw.setPenRadius(0.005);
        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-.05, 1.05);

        int overlapsCount = 0;
        int containsCount = 0;
        Interval1D dx1, dx2, dy1, dy2;
        for (int i = 0; i < N; i++)
        {
            p[i].draw();
            for (int j = i + 1; j < N; j++)
            {
                if (p[i].intersects(p[j]))
                {
                    overlapsCount++;
                    dx1 = d[i][0];
                    dy1 = d[i][1];
                    dx2 = d[j][0];
                    dy2 = d[j][1];

                    if (
                    // box 1 contains box 2
                    dx1.min() <= dx2.min() && dx1.max() >= dx2.max() &&
                            dy1.min() <= dy2.min() && dy1.max() >= dy2.max() ||
                    // OR box 2 contains box 1
                            dx2.min() <= dx1.min() && dx2.max() >= dx1.max() &&
                                    dy2.min() <= dy1.min() && dy2.max() >= dy1.max())
                    {
                        overlapsCount--;
                        containsCount++;
                    }
                }
            }
        }

        StdOut.printf("# of pairs that overlap: %s\n", overlapsCount);
        StdOut.printf("# of pairs that contains: %s\n", containsCount);
        StdDraw.show();
    }
}
