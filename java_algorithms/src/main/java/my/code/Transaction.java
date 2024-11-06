package my.code;

import edu.princeton.cs.algs4.Date;

public class Transaction implements Comparable<Transaction>
{
    private final String who;
    private final Date when;
    private final double amount;

    public Transaction(String who, Date when, double amount)
    {
        this.who = who;
        this.when = when;
        this.amount = amount;
    }

    public String who()
    {
        return who;
    }

    public Date when()
    {
        return when;
    }

    public double amount()
    {
        return amount;
    }

    @Override
    public int compareTo(Transaction that)
    {
        int whoOrder = this.who.compareTo(that.who);
        if (whoOrder != 0)
            return whoOrder;

        int whenOrder = this.when.compareTo(that.when);
        if (whenOrder != 0)
            return whenOrder;

        if (this.amount < that.amount)
            return -1;

        if (this.amount > that.amount)
            return +1;
        return 0;
    }

    public boolean equals(Object that)
    {
        if (that == this)
            return true;
        if (that == null)
            return false;
        if (that.getClass() != this.getClass())
            return false;
        Transaction t = (Transaction) that;
        return this.compareTo(t) == 0;
    }
}
