package my.code;

import edu.princeton.cs.algs4.StdOut;

public class Queue<T>
{
    // 1.3.29 Write a Queue implementation that uses a circular linked list, which
    // is the sameas a linked list except that no links are null and the value of
    // last.next is first whenever the list is not empty. Keep only one Node
    // instance variable (last).
    class Node
    {
        T value;
        Node next;

        Node(T v)
        {
            this.value = v;
        }
    }

    private Node last;

    public void enqueue(T v)
    {
        Node n = new Node(v);

        if (this.last == null)
        {
            this.last = n;
            this.last.next = n;// last is first as well
            return;
        }

        Node first = this.last.next;
        n.next = first;
        this.last.next = n;
        this.last = n;
    }

    public T dequeue() throws Exception
    {
        if (this.isEmpty())
        {
            throw new Exception("cannot dequeue: queue is empty");
        }

        Node first = this.last.next;
        T value = first.value;

        // one node only, removing will make the queue empty
        if (first == this.last)
        {
            this.last = null;
            return value;
        }

        first = first.next;
        last.next = first;
        return value;
    }

    public boolean isEmpty()
    {
        return this.last == null;
    }

    public void print()
    {
        if (this.isEmpty())
        {
            StdOut.printf("<empty>\n");
            return;
        }

        Node current = this.last;
        do
        {
            current = current.next;
            StdOut.printf("%s ->", current.value);

        }
        while (current != this.last);
        StdOut.printf("[%s]\n", current.next.value);
    }

    public static void main(String[] args) throws Exception
    {
        Queue<Integer> q = new Queue<Integer>();

        q.print();
        for (int i = 1; i < 11; i++)
        {
            q.enqueue(i);
            q.print();
        }

        for (int i = 1; i < 11; i++)
        {
            StdOut.printf("dequeue: %s\n", q.dequeue());
            q.print();
        }
    }
}
