package my.code;

public class VisualCounter
{

    // maximum number of operations
    private final int maxOperations;

    // max specifies the maximum absolute value for the counter
    private final int maxTally;

    private int count;
    private int operationCount;

    public VisualCounter(int maxOperations, int maxTally) throws Exception
    {

        if (maxTally <= 0)
            throw new Exception("maxTally should be positive");
        if (maxOperations <= 0)
            throw new Exception("maxOperations should be positive");

        this.maxOperations = maxOperations;
        this.maxTally = maxTally;

    }

    public void increment() throws Exception
    {
        if (operationCount == this.maxOperations)
            throw new Exception("max operation count reached");

        if (count == this.maxTally)
            throw new Exception("max tally reached");

        this.operationCount++;
        count++;
    }

    public void decrement() throws Exception
    {
        if (operationCount == this.maxOperations)
            throw new Exception("max operation count reached");

        this.operationCount++;
        count--;
    }

    public int tally()
    {
        return count;
    }
}
