package my.code;

public class Matrix
{
    // vector dot product
    public static double dot(double[] x, double[] y)
    {
        if (x.length != y.length)
        {
            throw new IllegalArgumentException(
                    String.format("the ranks of matrices are not equal: %s != %s ", x.length, y.length));
        }

        double result = 0.0;

        for (int i = 0; i < x.length; i++)
        {
            result += x[i] * y[i];
        }

        return result;
    }

    // matrix-matrix product
    public static double[][] mult(double[][] a, double[][] b)
    {
        if (a[0].length != b.length)
        {
            throw new IllegalArgumentException(
                    String.format("the ranks of matrices are not compatible for matrix multiplication: %s != %s ",
                            a[0].length, b.length));
        }

        double[][] result = new double[a.length][b[0].length];
        double sum;
        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < b[0].length; j++)
            {
                sum = 0;
                for (int k = 0; k < b.length; k++)
                    sum += a[i][k] * b[k][j];
                result[i][j] = sum;
            }
        }

        return result;
    }

    // matrix-vector product
    static double[] mult(double[][] a, double[] x)
    {
        if (a[0].length != x.length)
        {
            throw new IllegalArgumentException(
                    String.format("the ranks of matrices are not compatible for matrix multiplication: %s != %s ",
                            a[0].length, x.length));
        }

        double[] result = new double[a.length];
        double sum;
        for (int i = 0; i < a.length; i++)
        {
            sum = 0;
            for (int j = 0; j < x.length; j++)
                sum += a[i][j] * x[j];

            result[i] = sum;
        }
        return result;
    }

    // vector-matrix product
    public static double[] mult(double[] y, double[][] a)
    {
        if (a.length != y.length)
        {
            throw new IllegalArgumentException(
                    String.format("the ranks of matrices are not compatible for matrix multiplication: %s != %s ",
                            a.length, y.length));
        }

        double[] result = new double[a[0].length];
        double sum;
        for (int i = 0; i < result.length; i++)
        {
            sum = 0;
            for (int j = 0; j < y.length; j++)
                sum += a[j][i] * y[j];

            result[i] = sum;
        }
        return result;
    }

    public static double[][] transpose(double[][] a)
    {
        double[][] result = new double[a[0].length][a.length];

        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++)
                result[j][i] = a[i][j];

        return result;
    }
}
