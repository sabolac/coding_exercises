package my.code;

public class Rational
{

    private final long numerator;
    private final long denominator;

    public Rational(int numerator, int denominator)
    {
        // if (denominator <= 0)
        // throw new Exception("denominator cannot be 0");

        int gcd = gcd(numerator, denominator);
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;

    }

    public static int gcd(int p, int q)
    {
        if (q == 0)
            return p;
        int r = p % q;
        return gcd(q, r);
    }

    public Rational plus(Rational b)
    {
        return new Rational(
                (int) (this.numerator * b.denominator + b.numerator * this.denominator),
                (int) (this.denominator * b.denominator));
    }

}
