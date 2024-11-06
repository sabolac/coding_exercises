package my.code;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.stream.IntStream;

import edu.princeton.cs.algs4.Counter;
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

        exercise_1_2_12();

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

    public static void exercise_1_2_4()
    {
        // What does the following code fragment print?
        // Answer: prints:
        // world
        // hello
        String string1 = "hello";
        String string2 = string1;
        string1 = "world";
        StdOut.println(string1);
        StdOut.println(string2);
    }

    public static void exercise_1_2_5()
    {
        // What does the following code fragment print?
        // Answer: "Hello World", Strings in Java are immutable, thus calling a method
        // does not change the object itself. Rather it returns a new String object
        String s = "Hello World";
        s.toUpperCase();
        s.substring(6, 11);
        StdOut.println(s);
    }

    public static void exercise_1_2_6()
    {
        // A string s is a circular rotation of a string t if it matches when the
        // characters are circularly shifted by any number of positions; e.g., ACTGACG
        // is a circular shift of TGACGAC, and vice versa. Detecting this condition is
        // important in the study of genomic sequences. Write a program that checks
        // whether two given strings s and t are circular shifts of one another.
        String s = "ACTGACG";
        String t = "GACGACT";

        if (s.length() == t.length() && t.concat(t).indexOf(s) != -1)
        {
            StdOut.printf("%s is a circular shift of %s\n", s, t);
        }
        else
        {
            StdOut.printf("%s is NOT a circular shift of %s\n", s, t);
        }
    }

    // reverses the given String
    public static String mystery(String s)
    {
        int N = s.length();
        if (N <= 1)
            return s;
        String a = s.substring(0, N / 2);
        String b = s.substring(N / 2, N);
        return mystery(b) + mystery(a);
    }

    public static void exercise_1_2_7()
    {
        // What does the following recursive function mystery return?
        String s = "123456789";
        StdOut.printf("%s --> %s\n", s, mystery(s));
    }

    public static int rank(int key, int[] a, Counter totalKeysExamined)
    { // Array must be sorted.
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi)
        { // Key is in a[lo..hi] or not present.
            totalKeysExamined.increment();
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid])
                hi = mid - 1;
            else if (key > a[mid])
                lo = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    public static void exercise_1_2_9()
    {
        // Instrument BinarySearch (page 47) to use a Counter to count the total number
        // of keys examined during all searches and then print the total after all
        // searches are complete. Hint : Create a Counter in main() and pass it as an
        // argument to rank().
        Counter c = new Counter("Total Keys Examined");
        int N = 10000000;
        int[] a = IntStream.range(0, N).toArray();
        for (int i = 0; i < N; i++)
        {
            rank(StdRandom.uniformInt(N), a, c);
        }
        StdOut.printf("%s\n", c.toString());
    }

    public static boolean isLeapYear(int year)
    {
        // leap years: divisible by 400, or by 4 but not by 100
        return (year % 400 == 0 || year % 100 != 0 && year % 4 == 0);

    }

    public static int[] daysOfMonths(int year)
    {
        // 1 January 31 days
        // 2 February 28 days (29 if leap year)
        // 3 March 31 days
        // 4 April 30 days
        // 5 May 31 days
        // 6 June 30 days
        // 7 July 31 days
        // 8 August 31 days
        // 9 September 30 days
        // 10 October 31 days
        // 11 November 30 days
        // 12 December 31 days
        int[] d = new int[12];
        d[0] = d[2] = d[4] = d[6] = d[7] = d[9] = d[11] = 31;
        d[1] = 28 + (isLeapYear(year) ? 1 : 0);
        d[3] = d[5] = d[8] = d[10] = 30;

        return d;

    }

    public static String dayOfTheWeek(int d, int m, int y) throws Exception
    {
        if (y < 2000)
            throw new Exception("year should be >= 2000");

        LocalDate ld = LocalDate.of(y, m, d);
        LocalDate ld_2000 = LocalDate.of(2000, 1, 1);
        StdOut.printf("%s is a %s\n", ld_2000, ld_2000.getDayOfWeek());
        StdOut.printf("%s is %s days from %s\n", ld, ChronoUnit.DAYS.between(ld_2000, ld), ld_2000);
        StdOut.printf("%s is a %s\n", ld, ld.getDayOfWeek());

        int dy = y - 2000;
        int daysFrom2000 = dy * 365;
        dy--;
        // add 1 day for each leap year since 2000
        daysFrom2000 += dy / 4 - dy / 100 + dy / 400;

        int[] dom = daysOfMonths(y);
        for (int i = 0; i < m - 1; i++) // do not add the current month since it is not complete yet
            daysFrom2000 += dom[i];
        daysFrom2000 += d - (y == 2000 ? 1 : 0); // add days, sub 1 for year 2000

        // 1/1/2000 was a Saturday, so start with Saturday
        String[] daysOfWeek =
        { "SATURDAY", "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY" };

        String dayOfWeek = daysOfWeek[daysFrom2000 % 7];
        StdOut.printf("%s is %s days from %s\n", ld, daysFrom2000, ld_2000);
        StdOut.printf("%s is a %s\n", ld, dayOfWeek);

        return dayOfWeek;
    }

    public static void exercise_1_2_12()
    {
        try
        {
            dayOfTheWeek(12, 3, 3541);
        }
        catch (Exception e)
        {
            StdOut.printf(e.toString());
        }
    }

}
