package my.code;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Chapter1
{
    public static void main(String[] args)
    {
        StdOut.println(">>>>>>>>> Start Execution");
        // new App().runAll(args);
        exercise_1_1_14();
        StdOut.println(">>>>>>>>> End Execution");
    }

    public void runAll(String[] args)
    {
        exercise_1_1_1();
        exercise_1_1_2();
        exercise_1_1_3();
        exercise_1_1_6();
        exercise_1_1_7();
        exercise_1_1_8();
        exercise_1_1_9();
        exercise_1_1_11();
        exercise_1_1_12();
        exercise_1_1_13();
        exercise_1_1_14();
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
}
