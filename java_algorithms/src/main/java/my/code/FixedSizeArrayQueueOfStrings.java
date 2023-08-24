package my.code;

import edu.princeton.cs.algs4.StdOut;

public class FixedSizeArrayQueueOfStrings
{
    private String[] items;
    int size;
    int head, tail;

    public FixedSizeArrayQueueOfStrings()
    {
        this(100);
    }

    public FixedSizeArrayQueueOfStrings(int capacity)
    {
        this.size = 0;
        this.items = new String[capacity];
    }

    public void enqueue(String s) throws Exception
    {
        if (this.size == 0)
        {
            this.head = this.tail = 0;
            this.items[this.tail] = s;
            this.size++;
            return;
        }

        if (this.size == this.items.length)
        {
            throw new Exception("Queue capacity reached. No space left to add more items.");
        }

        ++this.tail;
        this.tail %= this.items.length;
        this.items[this.tail] = s;
        this.size++;
    }

    public String dequeue() throws Exception
    {
        if (this.size == 0)
        {
            throw new Exception("Queue is empty, can't dequeue");
        }

        String item = this.items[this.head];
        this.size--;
        ++this.head;
        this.head %= this.items.length;

        return item;
    }

    public static void main(String[] args) throws Exception
    {
        FixedSizeArrayQueueOfStrings q = new FixedSizeArrayQueueOfStrings(5);
        q.enqueue("1");
        q.enqueue("2");
        StdOut.printf("%s", q.dequeue());
        q.enqueue("3");
        q.enqueue("4");
        StdOut.printf("%s", q.dequeue());
        q.enqueue("5");
        StdOut.printf("%s", q.dequeue());
        q.enqueue("6");
        q.enqueue("7");
        StdOut.printf("%s", q.dequeue());
        StdOut.printf("%s", q.dequeue());

        q.enqueue("8");
        StdOut.printf("%s", q.dequeue());
        StdOut.printf("%s", q.dequeue());
        q.enqueue("9");
        StdOut.printf("%s", q.dequeue());
        StdOut.printf("%s", q.dequeue());
        q.enqueue(" 1");
        q.enqueue(" 2");
        q.enqueue(" 3");
        q.enqueue(" 4");
        q.enqueue(" 5");
        StdOut.printf("%s", q.dequeue());
        StdOut.printf("%s", q.dequeue());
        StdOut.printf("%s", q.dequeue());
        StdOut.printf("%s", q.dequeue());
        StdOut.printf("%s", q.dequeue());
        q.enqueue(" 1");
        q.enqueue(" 2");

        StdOut.printf("%s", q.dequeue());
        StdOut.printf("%s", q.dequeue());
        q.enqueue(" 3");
        q.enqueue(" 4");
        StdOut.printf("%s", q.dequeue());
        q.enqueue(" 5");
        StdOut.printf("%s", q.dequeue());
        StdOut.printf("%s\n", q.dequeue());
    }
}
