package my.code;

import edu.princeton.cs.algs4.StdOut;

public class DoublingStackOfStrings
{
    private int size = 0;
    private String[] values = new String[1];

    public DoublingStackOfStrings()
    {
    }

    public void push(String item)
    {
        if (this.size == this.values.length)
        {
            this.growCapacity();
        }

        this.values[size++] = item;
    }

    public String pop()
    {
        if (this.size == 0)
        {
            throw new UnsupportedOperationException("pop() on an empty stack is not supported");
        }

        String item = this.values[--this.size];
        if (this.size < this.values.length / 4)
        {
            this.shrinkCapacity();
        }

        return item;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    private void growCapacity()
    {
        String[] newArray = new String[this.values.length * 2];
        StdOut.printf("growCapacity to %s\n", newArray.length);
        for (int i = 0; i < this.values.length; i++)
        {
            newArray[i] = this.values[i];
        }

        this.values = newArray;
    }

    private void shrinkCapacity()
    {
        String[] newArray = new String[this.values.length / 2];
        StdOut.printf("shrinkCapacity to %s\n", newArray.length);
        for (int i = 0; i < this.size; i++)
        {
            newArray[i] = this.values[i];
        }

        this.values = newArray;
    }

}
