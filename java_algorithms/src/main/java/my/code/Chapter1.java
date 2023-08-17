package my.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Chapter1
{
    public static void main(String[] args)
    {
        StdOut.println(">>>>>>>>> Start Execution");
        exercise_1_1_31();
        StdOut.println(">>>>>>>>> End Execution");
    }

    private static void exercise_1_1_1()
    {
        // Give the value of each of the following expressions
        StdOut.printf("( 0 + 15 ) / 2 = %s\n", ((0 + 15) / 2));
        StdOut.printf("2.0e-6 * 100000000.1 = %s\n", (2.0e-6 * 100000000.1));
        StdOut.printf("true && false || true && true = %s\n", (true && false || true && true));
    }

    private static void exercise_1_1_2()
    {
        // Give the type and value of each of the following expressions
        String typeName;

        typeName = (((Object) ((1 + 2.236) / 2))).getClass().getName();
        typeName = typeName.substring(typeName.lastIndexOf(".") + 1).toLowerCase();
        StdOut.printf("(1 + 2.236) / 2 = %s (%s)\n", (1 + 2.236) / 2, typeName);

        typeName = (((Object) (1 + 2 + 3 + 4.0))).getClass().getName();
        typeName = typeName.substring(typeName.lastIndexOf(".") + 1).toLowerCase();
        StdOut.printf("1 + 2 + 3 + 4.0 = %s (%s)\n", (1 + 2 + 3 + 4.0), typeName);

        typeName = (((Object) (4.1 >= 4))).getClass().getName();
        typeName = typeName.substring(typeName.lastIndexOf(".") + 1).toLowerCase();
        StdOut.printf("4.1 >= 4 = %s (%s)\n", (4.1 >= 4), typeName);

        typeName = (((Object) (1 + 2 + "3"))).getClass().getName();
        typeName = typeName.substring(typeName.lastIndexOf(".") + 1).toLowerCase();
        StdOut.printf("1 + 2 + \"3\" = %s (%s)\n", (1 + 2 + "3"), typeName);
    }

    private static void exercise_1_1_3()
    {
        StdOut.printf("Enter 3 integers seperated by space followed by Enter and Ctrl+D:");
        int[] numbers = StdIn.readAllInts();
        for (int i : numbers)
        {
            StdOut.printf("Entered:%s\n", i);
        }

        if (numbers.length != 3)
        {
            StdOut.printf("Unexpected number of numbers: %s (expected 3)\n", numbers.length);
            return;
        }

        if (numbers[0] == numbers[1] && numbers[0] == numbers[2])
        {
            StdOut.printf("equals\n");
        }
        else
        {
            StdOut.printf("not equals\n");
        }
    }

    private static void exercise_1_1_6()
    {
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++)
        {
            StdOut.println(f);
            f = f + g;
            g = f - g;
        }
    }

    private static void exercise_1_1_7()
    {
        double t = 9.0;
        while (Math.abs(t - 9.0 / t) > 0.001)
        {
            t = (9.0 / t + t) / 2.0;
        }
        StdOut.printf("%.5f\n", t);

        int sum = 0;
        for (int i = 1; i < 1000; i++)
            for (int j = 0; j < i; j++)
                sum++;
        StdOut.println(sum);

        sum = 0;
        for (int i = 1; i < 1000; i *= 2)
            for (int j = 0; j < 1000; j++)
                sum++;
        StdOut.println(sum);

    }

    private static void exercise_1_1_8()
    {
        System.out.println('b');
        System.out.println('b' + 'c');
        System.out.println((char) ('a' + 4));
    }

    private static String toBinaryString(int i)
    {
        StringBuilder sb = new StringBuilder();
        while (i != 0)
        {
            sb.append((1 & i) == 0 ? '0' : '1');
            i >>>= 1;
        }
        return String.format("%32s", sb.reverse().toString()).replace(' ', '0');
    }

    private static String toBinaryStringBuiltIn(int i)
    {
        String s = Integer.toBinaryString(i);
        return String.format("%32s", s).replace(' ', '0');
    }

    private static void exercise_1_1_9()
    {
        StdOut.printf("%s\n", toBinaryString(-1));
        StdOut.printf("%s\n", toBinaryStringBuiltIn(-1));

        StdOut.printf("%s\n", toBinaryString(-2));
        StdOut.printf("%s\n", toBinaryStringBuiltIn(-2));

        StdOut.printf("%s\n", toBinaryString(1));
        StdOut.printf("%s\n", toBinaryStringBuiltIn(1));

        StdOut.printf("%s\n", toBinaryString(2));
        StdOut.printf("%s\n", toBinaryStringBuiltIn(2));

        StdOut.printf("%s\n", toBinaryString(3));
        StdOut.printf("%s\n", toBinaryStringBuiltIn(3));

        StdOut.printf("%s\n", toBinaryString(5));
        StdOut.printf("%s\n", toBinaryStringBuiltIn(5));

        StdOut.printf("%s\n", toBinaryString(16));
        StdOut.printf("%s\n", toBinaryStringBuiltIn(16));

        StdOut.printf("%s\n", toBinaryString(Integer.MAX_VALUE));
        StdOut.printf("%s\n", toBinaryStringBuiltIn(Integer.MAX_VALUE));

        StdOut.printf("%s\n", toBinaryString(Integer.MIN_VALUE));
        StdOut.printf("%s\n", toBinaryStringBuiltIn(Integer.MIN_VALUE));
    }

    private static void exercise_1_1_11()
    {
        // Write a code fragment that prints the contents of a two-dimensional boolean
        // array, using * to represent true and a space to represent false. Include row
        // and column numbers.
        boolean[][] arr =
        {
            { true, false, true, true },
            { true, false, true, false },
            { false, false, true, true }
        };

        StdOut.printf("  ");
        for (int column = 0; column < arr[0].length; column++)
        {
            StdOut.printf("%s ", column);
        }
        StdOut.printf("\n");

        int row = 0;
        for (boolean[] bs : arr)
        {
            StdOut.printf("%s ", row++);
            for (boolean b : bs)
            {
                StdOut.printf("%s ", b ? '*' : ' ');
            }
            StdOut.printf("\n");
        }
    }

    private static void exercise_1_1_12()
    {
        int[] a = new int[10];
        for (int i = 0; i < 10; i++)
            a[i] = 9 - i;
        for (int i = 0; i < 10; i++)
            a[i] = a[a[i]];
        for (int i = 0; i < 10; i++)
            System.out.println(a[i]);
    }

    private static void exercise_1_1_13()
    {
        // Write a code fragment to print the transposition (rows and columns changed)
        // of a two-dimensional array with M rows and N columns.
        int[][] arr =
        {
            { 1, 2, 3, 0, 1 },
            { 4, 5, 6, 0, 1 },
            { 7, 8, 9, 0, 1 }
        };

        for (int i = 0; i < arr[0].length; i++)
        {
            for (int j = 0; j < arr.length; j++)
            {
                StdOut.printf("%s ", arr[j][i]);
            }
            StdOut.println();
        }
    }

    private static int lg(int n)
    {
        // logarithm is undefined for negative numbers and 0
        if (n <= 0)
        {
            throw new IllegalArgumentException("logarithm is undefined for negative numbers and 0");
        }

        int i;
        for (i = 0; (n >>>= 1) != 0; i++)
            ;
        return i;
    }

    private static void exercise_1_1_14()
    {
        // Write a static method lg() that takes an int value N as argument and returns
        // the largest int not larger than the base-2 logarithm of N. Do not use Math.
        for (int i = 1; i <= 32; i++)
        {
            StdOut.printf("lg(%s) = %s\n", i, lg(i));
        }
    }

    private static int[] histogram(int[] a, int M)
    {
        int[] h = new int[M];
        for (int i : a)
        {
            if (i >= 0 && i < M)
                h[i]++;
        }

        return h;
    }

    private static void exercise_1_1_15()
    {
        // Write a static method histogram() that takes an array a[] of int values and
        // an integer M as arguments and returns an array of length M whose ith entry is
        // the number of times the integer i appeared in the argument array. If the
        // values in a[] are all between 0 and M–1, the sum of the values in the
        // returned array should be equal to a.length.
        int[] a =
        { 1, 2, 0, 2, 1, 1, 1, 2, 4 };

        int[] h = histogram(a, 5);
        for (int i : h)
        {
            StdOut.printf("%s ", i);
        }
    }

    public static String exR1(int n)
    {
        if (n <= 0)
            return "";
        return exR1(n - 3) + n + exR1(n - 2) + n;
    }

    private static void exercise_1_1_16()
    {
        StdOut.printf("%s\n", exR1(6));
    }

    // returns a*b
    public static int mystery1(int a, int b)
    {
        if (b == 0)
            return 0;
        if (b % 2 == 0)
            return mystery1(a + a, b / 2);
        return mystery1(a + a, b / 2) + a;
    }

    // returns pow(a,b)
    public static int mystery2(int a, int b)
    {
        if (b == 0)
            return 1;
        if (b % 2 == 0)
            return mystery2(a * a, b / 2);
        return mystery2(a * a, b / 2) * a;
    }

    private static void exercise_1_1_18()
    {
        StdOut.printf("%s\n", mystery1(2, 25));
        StdOut.printf("%s\n", mystery1(3, 11));
        StdOut.printf("%s\n", mystery1(12, 7));

        StdOut.printf("%s\n", mystery2(2, 10));
        StdOut.printf("%s\n", mystery2(3, 4));
        StdOut.printf("%s\n", mystery2(10, 4));
    }

    private static long fibonacci1(int N)
    {
        if (N == 0)
            return 0;
        if (N == 1)
            return 1;
        return fibonacci1(N - 1) + fibonacci1(N - 2);
    }

    private static long fibonacci(int N)
    {
        if (N == 0)
            return 0;
        if (N == 1)
            return 1;
        long[] savedResults = new long[N + 1];
        savedResults[0] = 0;
        savedResults[1] = 1;
        return fibonacci(N - 1, savedResults) + fibonacci(N - 2, savedResults);
    }

    private static long fibonacci(int N, long[] savedResults)
    {
        if (N <= 1)
            return savedResults[N];
        if (savedResults[N - 1] == 0)
            savedResults[N - 1] = fibonacci(N - 1, savedResults);
        if (savedResults[N - 2] == 0)
            savedResults[N - 2] = fibonacci(N - 2, savedResults);
        if (savedResults[N] == 0)
            savedResults[N] = savedResults[N - 1] + savedResults[N - 2];
        return savedResults[N];
    }

    private static long fibonacciNonRecursive(int N)
    {
        long[] savedResults = new long[N + 1];
        if (N == 0)
            return 0;
        if (N == 1)
            return 1;
        savedResults[0] = 0;
        savedResults[1] = 1;
        for (int i = 2; i <= N; i++)
            savedResults[i] = savedResults[i - 1] + savedResults[i - 2];
        return savedResults[N];
    }

    private static void exercise_1_1_19()
    {
        for (int N = 0; N < 90; N++)
            StdOut.println(N + " " + fibonacciNonRecursive(N));
    }

    // returns ln(n!)
    private static double lnFactorial(int n)
    {
        if (n == 0 || n == 1)
            return 0;
        return Math.log(n) + lnFactorial(n - 1);
    }

    private static void exercise_1_1_20()
    {
        StdOut.printf("%s\n", lnFactorial(0));
        StdOut.printf("%s\n", lnFactorial(1));
        StdOut.printf("%s\n", lnFactorial(5));
        StdOut.printf("%s\n", lnFactorial(10));
        StdOut.printf("%s\n", lnFactorial(12));
    }

    private static void exercise_1_1_21()
    {
        String name;
        int v1;
        int v2;
        float avg;
        StdOut.printf("Name\tVal1\tVal2\tAvg\n");
        while (!StdIn.isEmpty())
        {
            name = StdIn.readString();
            v1 = StdIn.readInt();
            v2 = StdIn.readInt();
            avg = ((float) v1) / v2;
            StdOut.printf("%s\t%d\t%d\t%.3f\n", name, v1, v2, avg);
        }
    }

    private static int rank(int key, int[] a)
    {
        return rank(key, a, false);
    }

    private static int rank(int key, int[] a, boolean trace)
    {
        return rank(key, a, 0, a.length - 1, trace ? 0 : -1);
    }

    private static int rank(int key, int[] a, int lo, int hi, int depth)
    {
        // Index of key in a[], if present, is not smaller than lo and not larger
        // than hi.
        if (depth >= 0)
            StdOut.printf("%s lo:%s hi:%s\n", "  ".repeat(depth++), lo, hi);
        if (lo > hi)
            return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid])
            return rank(key, a, lo, mid - 1, depth);
        else if (key > a[mid])
            return rank(key, a, mid + 1, hi, depth);
        else
            return mid;
    }

    private static void exercise_1_1_22()
    {
        // Write a version of BinarySearch that uses the recursive rank() given on page
        // 25 and traces the method calls. Each time the recursive method is called,
        // print the argument values lo and hi, indented by the depth of the recursion.
        // Hint: Add an argument to the recursive method that keeps track of the depth.
        int[] a = IntStream.range(1, 100).toArray();
        rank(27, a);
    }

    private static void binarySearch(String fileName, boolean printMatching)
    {
        int[] whitelist = new In(fileName).readAllInts();
        Arrays.sort(whitelist);
        while (!StdIn.isEmpty())
        {
            int key = StdIn.readInt();
            if (rank(key, whitelist) < 0)
            {
                if (!printMatching)
                    StdOut.println(key);
            }
            else
            {
                if (printMatching)
                    StdOut.println(key);
            }
        }
    }

    private static void generateRandomInts()
    {
        Random rd = new Random();
        int maxValue = 100000;
        int length = 1300;
        for (int i = 0; i < length; i++)
        {
            StdOut.println(rd.nextInt(maxValue));
        }
    }

    private static void exercise_1_1_23(String[] args)
    {
        // Add to the BinarySearch test client the ability to respond to a second
        // argument: + to print numbers from standard input that are not in the
        // whitelist, - to print numbers that are in the whitelist.
        boolean printMatching = args[1].equals("-");
        binarySearch(args[0], printMatching);
    }

    public static int gcd(int p, int q, boolean trace)
    {
        if (trace)
            StdOut.printf("p:%s q:%s\n", p, q);
        if (q == 0)
            return p;
        int r = p % q;
        return gcd(q, r, trace);
    }

    private static void exercise_1_1_24(String[] args)
    {
        // Give the sequence of values of p and q that are computed when Euclid’s
        // algorithm is used to compute the greatest common divisor of 105 and 24.
        // Extend the code given on page 4 to develop a program Euclid that takes two
        // integers from the command line and computes their greatest common divisor,
        // printing out the two arguments for each call on the recursive method. Use
        // your program to compute the greatest common divisor or 1111111 and 1234567.
        int p = Integer.parseInt(args[0]);
        int q = Integer.parseInt(args[1]);
        int result = gcd(p, q, true);
        StdOut.printf("gcd(%s, %s) = %s\n", p, q, result);
    }

    private static double binomial(int N, int k, double p)
    {
        double[][] savedResults = new double[N + 1][k + 1];
        for (int i = 0; i <= N; i++)
            for (int j = 0; j <= k; j++)
                savedResults[i][j] = Double.NEGATIVE_INFINITY;

        savedResults[0][0] = 1.0;
        return binomial(N, k, p, savedResults);
    }

    private static double binomial(int N, int k, double p, double[][] savedResults)
    {
        if (N < 0 || k < 0)
            return 0.0;

        if (savedResults[N][k] != Double.NEGATIVE_INFINITY)
            return savedResults[N][k];

        double result1 = binomial(N - 1, k, p, savedResults);
        double result2 = binomial(N - 1, k - 1, p, savedResults);
        double result = (1.0 - p) * result1 + p * result2;
        savedResults[N][k] = result;
        return result;
    }

    private static void exercise_1_1_27()
    {
        double result = binomial(100, 20, 0.1);
        StdOut.printf("result=%s", result);
    }

    private static void exercise_1_1_28()
    {
        // remove duplicates from a sorted array and print the resulting array
        int maxValue = 100;
        int length = 200;
        Random rd = new Random();
        int[] arr = new int[length];

        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = rd.nextInt(maxValue);
        }
        Arrays.sort(arr);

        ArrayList<Integer> uniqueVals = new ArrayList<>();
        int current = arr[0];
        uniqueVals.add(current);
        for (int i = 1; i < arr.length; i++)
        {
            if (arr[i] != current)
            {
                current = arr[i];
                uniqueVals.add(current);
            }
        }

        for (int i : uniqueVals)
        {
            StdOut.printf("%s ", i);
        }
    }

    private static int countSmaller(int k, int[] arr)
    {
        return countSmaller(k, arr, 0, arr.length - 1);
    }

    private static int countSmaller(int k, int[] arr, int lo, int hi)
    {
        if (lo > hi)
        {
            if (hi < 0)
                return 0;
            while (hi < arr.length && arr[hi] < k)
                hi++;
            return hi;
        }
        int mid = lo + (hi - lo) / 2;
        if (k < arr[mid])
            return countSmaller(k, arr, lo, mid - 1);
        if (k > arr[mid])
            return countSmaller(k, arr, mid + 1, hi);
        else
        {
            while (mid >= 0 && arr[mid] == k)
                mid--;
            return mid + 1;
        }
    }

    private static int countEquals(int k, int[] arr)
    {
        int i = rank(k, arr);
        if (i == -1)
            return 0; // no match

        int start = i, end = i;

        while (start >= 0 && arr[start] == k)
        {
            start--;
        }

        while (end < arr.length && arr[end] == k)
        {
            end++;
        }

        return end - start - 1;
    }

    private static void exercise_1_1_29()
    {
        // Equal keys. Add to BinarySearch a static method rank() that takes a key and
        // a sorted array of int values (some of which may be equal) as arguments and
        // returns the number of elements that are smaller than the key and a similar
        // method count() that returns the number of elements equal to the key. Note :
        // If i and j are the values returned by rank(key, a) and count(key, a)
        // respectively, then a[i..i+j-1] are the values in the array that are equal to
        // key.
        int[] a =
        { 0, 1, 1, 2, 2, 2, 3, 3, 3, 3, 6, 8, 9 };
        // StdOut.printf("# smaller than 3: %s\n", countSmaller(3, a));
        StdOut.printf("# smaller than 0:%s\n", countSmaller(0, a));
        StdOut.printf("# smaller than 1:%s\n", countSmaller(1, a));
        StdOut.printf("# smaller than 2:%s\n", countSmaller(2, a));
        StdOut.printf("# smaller than 3:%s\n", countSmaller(3, a));
        StdOut.printf("# smaller than 4:%s\n", countSmaller(4, a));
        StdOut.printf("# smaller than 5:%s\n", countSmaller(5, a));
        StdOut.printf("# smaller than 6:%s\n", countSmaller(6, a));
        StdOut.printf("# smaller than 7:%s\n", countSmaller(7, a));
        StdOut.printf("# smaller than 8:%s\n", countSmaller(8, a));
        StdOut.printf("# smaller than 9:%s\n", countSmaller(9, a));
        StdOut.printf("# smaller than 10:%s\n", countSmaller(10, a));
        StdOut.printf("# smaller than 20:%s\n", countSmaller(20, a));
        StdOut.printf("# smaller than -1:%s\n", countSmaller(-1, a));

        StdOut.printf("# equals 0:%s\n", countEquals(0, a));
        StdOut.printf("# equals 1:%s\n", countEquals(1, a));
        StdOut.printf("# equals 2:%s\n", countEquals(2, a));
        StdOut.printf("# equals 3:%s\n", countEquals(3, a));
        StdOut.printf("# equals 4:%s\n", countEquals(4, a));
        StdOut.printf("# equals 5:%s\n", countEquals(5, a));
        StdOut.printf("# equals 6:%s\n", countEquals(6, a));
        StdOut.printf("# equals 9:%s\n", countEquals(9, a));
        StdOut.printf("# equals -1:%s\n", countEquals(-1, a));
    }

    private static boolean relativePrime(int v1, int v2)
    {
        return gcd(v1, v2, false) == 1;
    }

    private static void exercise_1_1_30()
    {
        int n = 30;
        boolean[][] arr = new boolean[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                arr[i][j] = relativePrime(i, j);

        StdOut.printf("  ");
        for (int column = 0; column < arr[0].length; column++)
        {
            StdOut.printf("%s ", column);
        }
        StdOut.printf("\n");

        int row = 0;
        for (boolean[] bs : arr)
        {
            StdOut.printf("%s ", row++);
            for (boolean b : bs)
            {
                StdOut.printf("%s ", b ? '*' : ' ');
            }
            StdOut.printf("\n");
        }
    }

    private static void exercise_1_1_31()
    {
        int SIZE = 1000;
        int r = 400;
        int N = 20;
        double p = 0.5;
        double[] x = new double[N];
        double[] y = new double[N];

        StdDraw.setCanvasSize(SIZE, SIZE);
        StdDraw.setScale(-SIZE / 2, SIZE / 2);
        StdDraw.enableDoubleBuffering();

        double angleSpacing = 2 * Math.PI / N;
        for (int i = 0; i < N; i++)
        {
            x[i] = r * Math.cos(i * angleSpacing);
            y[i] = r * Math.sin(i * angleSpacing);
        }

        StdDraw.setPenColor(StdDraw.BOOK_BLUE);
        for (int i = 0; i < N - 1; i++)
            for (int j = i + 1; j < N; j++)
                if (StdRandom.bernoulli(p))
                    StdDraw.line(x[i], y[i], x[j], y[j]);

        StdDraw.setPenRadius(.05);
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        for (int i = 0; i < N; i++)
        {
            StdDraw.point(x[i], y[i]);
        }

        StdDraw.show();
    }
}
