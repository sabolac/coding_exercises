package my.code;

import edu.princeton.cs.algs4.StdOut;

public class ResizingArrayQueueOfStrings
{
    private String[] items;
    int size;
    int head, tail;

    public ResizingArrayQueueOfStrings()
    {
        this.size = 0;
        this.items = new String[16];
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
            this.growBackingArray();
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

        if (this.size > 10 && this.size < this.items.length / 3)
        {
            this.shrinkBackingArray();
        }

        return item;
    }

    private void growBackingArray()
    {
        String[] newArr = new String[(int) Math.ceil(this.items.length * 1.6)];
        this.copyToNewArray(newArr);
    }

    private void shrinkBackingArray()
    {
        String[] newArr = new String[(int) (this.items.length / 1.5)];
        this.copyToNewArray(newArr);
    }

    private void copyToNewArray(String[] newArr)
    {
        StdOut.printf("\nsize=%s capacity=%s\n", this.size, newArr.length);
        int i = 0;
        while (this.head != this.tail)
        {
            newArr[i++] = this.items[this.head++];
            this.head %= this.items.length;
        }
        newArr[i++] = this.items[this.tail];
        this.head = 0;
        this.tail = this.size - 1;
        this.items = newArr;
    }

    public static void main(String[] args) throws Exception
    {
        ResizingArrayQueueOfStrings q = new ResizingArrayQueueOfStrings();

        for (int i = 0; i < 100; i++)
        {
            q.enqueue(Integer.toString(i));
            if (i % 5 == 0 || i % 7 == 0)
            {
                StdOut.printf(" %s", q.dequeue());
            }
        }

        StdOut.printf(" %s", q.dequeue());
        StdOut.printf(" %s", q.dequeue());

        for (int i = 0; i < 100; i++)
        {
            q.enqueue(Integer.toString(i));
            if (i % 2 == 0 || i % 7 == 0)
            {
                StdOut.printf(" %s", q.dequeue());
            }
        }

        for (int i = 0; i < 109; i++)
        {
            StdOut.printf(" %s", q.dequeue());
        }
    }
}
