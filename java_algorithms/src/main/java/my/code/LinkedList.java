package my.code;

import edu.princeton.cs.algs4.StdOut;

public class LinkedList<T extends Comparable<T>>
{
    class Node
    {
        T value;
        Node next;

        Node(T v)
        {
            this.value = v;
        }
    }

    int size = 0;
    Node head, tail;

    public LinkedList()
    {
    }

    // insert at the front (before head)
    public void insert(T t)
    {
        Node n = new Node(t);
        n.next = this.head;
        this.head = n;
        this.size++;
        if (size == 1)
        {
            this.tail = this.head;
        }
    }

    public void insertAfter(Node n1, Node n2)
    {
        if (n1 == null || n2 == null)
            return;
        n2.next = n1.next;
        n1.next = n2;
        // if adding n2 to the tail, adjust the tail
        if (n1 == this.tail)
            this.tail = n2;
        this.size++;
    }

    // append to the back (after tail)
    public void append(T t)
    {
        if (this.size == 0)
        {
            this.insert(t);
            return;
        }

        Node n = new Node(t);
        this.tail.next = n;
        this.tail = n;
        this.size++;
    }

    public T removeLast() throws Exception
    {
        if (this.size == 0)
        {
            throw new Exception("removeLast: cannot remove from an empty list");
        }

        T t = this.tail.value;
        if (size == 1)
        {
            this.head = this.tail = null;
            this.size--;
            return t;
        }

        Node n = this.head;
        while (n.next != this.tail)
            n = n.next;

        this.tail = n;
        this.tail.next = null;
        this.size--;
        return t;
    }

    public void removeAfter(Node n)
    {
        if (n.next == null)
        {
            return;
        }

        if (n.next == this.tail)
        {
            // removing the tail node, so adjust
            this.tail = n;
        }

        n.next = n.next.next;
        this.size--;
    }

    public void removeAllWithValue(T v)
    {
        Node n = this.head;
        Node p = null;// previous node
        while (n != null)
        {
            if (n.value == v)
            {
                if (p == null)// removing head node
                {
                    n = n.next;
                    this.head = n;
                }
                else
                {
                    p.next = n.next;
                    if (n == this.tail) // removing tail node
                    {
                        this.tail = p;
                    }
                    n = n.next;
                }
                this.size--;
            }
            else
            {
                p = n;
                n = n.next;
            }
        }

        if (this.size == 0)
        {
            this.head = this.tail = null;
        }
    }

    public void reverse()
    {
        // nothing to do when there is one or no node in the list
        if (this.size <= 1)
            return;

        Node current = this.head;
        Node next; // node after current
        Node reverseHead = null;// head node of the reserve list as we progress

        // swap head and tail nodes due to reverse
        this.head = this.tail;
        this.tail = current;

        while (current != null)
        {
            next = current.next;
            current.next = reverseHead;
            reverseHead = current;
            current = next;
        }
    }

    public T deleteKth(int k) throws Exception
    {
        if (k < 1)
        {
            throw new Exception(String.format("cannot delete %s th node, k should be > 0", k));
        }

        if (this.size < k)
        {
            throw new Exception(String.format("cannot delete %s th node from a list of %s", k, this.size));
        }

        T v;
        if (k == 1)
        {
            this.size--;
            v = this.head.value;
            if (this.size == 0)
            {
                this.head = this.tail = null;
            }
            else
            {
                this.head = this.head.next;
                if (this.size == 1)
                {
                    this.tail = this.head;
                }
            }
            return v;
        }

        Node p = this.head;
        Node n = p.next;
        while (--k > 1)
        {
            p = n;
            n = n.next;
        }

        v = n.value;
        if (n == this.tail)
        {
            this.tail = p;
        }
        p.next = n.next;
        this.size--;
        return v;
    }

    public void print()
    {
        Node n = this.head;
        while (n != null)
        {
            StdOut.printf("%s -> ", n.value);
            n = n.next;
        }
        StdOut.printf(" .\n");
    }

    public Node findFirstNodeWithValue(T v)
    {
        Node n = this.head;
        while (n != null && n.value != v)
            n = n.next;

        return n;
    }

    public boolean find(T v)
    {
        return findFirstNodeWithValue(v) != null;
    }

    public T max()
    {
        if (this.size == 0)
            return null;

        Node currentMax = this.head, n = this.head;
        while (n != null)
        {
            if (n.value.compareTo(currentMax.value) > 0)
            {
                currentMax = n;
            }
            n = n.next;
        }
        return currentMax.value;
    }

    public T maxRecursive()
    {
        if (this.size == 0)
        {
            return null;
        }

        return this.maxR(this.head);
    }

    private T maxR(Node n)
    {
        if (n.next == null)
            return n.value;

        T subMax = this.maxR(n.next);
        return n.value.compareTo(subMax) > 0 ? n.value : subMax;
    }

    public static void main(String[] args) throws Exception
    {
        LinkedList<Integer> l = new LinkedList<>();
        l.insert(1);
        l.insert(2);
        l.insert(3);
        l.insert(4);
        l.print();
        l.append(5);
        l.append(6);
        l.append(7);
        l.print();
        l.removeLast();
        l.removeLast();
        l.removeLast();
        l.removeLast();
        l.removeLast();
        l.removeLast();
        l.removeLast();
        l.print();
        l.append(1);
        l.append(2);
        l.append(3);
        l.append(4);
        l.print();
        l.removeLast();
        l.removeLast();
        l.print();
        l.removeLast();
        l.removeLast();
        l.print();

        l.insert(1);
        l.insert(2);
        l.insert(3);
        l.insert(4);
        l.insert(5);
        l.insert(6);

        StdOut.printf("find(%s): %s\n", 1, l.find(1));
        StdOut.printf("find(%s): %s\n", 2, l.find(2));
        StdOut.printf("find(%s): %s\n", 4, l.find(4));
        StdOut.printf("find(%s): %s\n", 5, l.find(5));
        StdOut.printf("find(%s): %s\n", 6, l.find(6));
        StdOut.printf("find(%s): %s\n", 10, l.find(10));
        l.print();
        l.deleteKth(4);
        l.print();
        l.deleteKth(1);
        l.print();
        l.deleteKth(2);
        l.print();
        l.deleteKth(1);
        l.print();
        l.deleteKth(2);
        l.print();
        l.append(1);
        l.insert(3);
        l.print();
        l.removeLast();
        l.print();
        l.insert(4);
        l.append(1);
        l.print();
        l.removeAfter(l.findFirstNodeWithValue(2));
        l.print();
        l.removeAfter(l.findFirstNodeWithValue(2));
        l.print();
        l.removeAfter(l.findFirstNodeWithValue(4));
        l.print();
        l.insertAfter(l.findFirstNodeWithValue(4), l.new Node(3));
        l.print();
        l.insertAfter(l.findFirstNodeWithValue(2), l.new Node(1));
        l.print();
        StdOut.printf("max=%s\n", l.max());
        StdOut.printf("max=%s\n", l.maxRecursive());
        l.reverse();
        l.print();
        l.removeAllWithValue(3);
        l.print();
        StdOut.printf("max=%s\n", l.max());
        StdOut.printf("max=%s\n", l.maxRecursive());
        l.removeAllWithValue(3);
        l.print();
        StdOut.printf("max=%s\n", l.max());
        StdOut.printf("max=%s\n", l.maxRecursive());
        l.removeAllWithValue(4);
        l.print();
        StdOut.printf("max=%s\n", l.max());
        StdOut.printf("max=%s\n", l.maxRecursive());
        l.insert(1);
        l.insert(2);
        l.append(3);
        l.append(3);
        l.append(2);
        l.reverse();
        l.print();
        l.removeAllWithValue(1);
        l.print();
        l.removeAllWithValue(2);
        l.print();
        l.removeAllWithValue(1);
        l.print();
        l.removeAllWithValue(3);
        l.print();
        l.removeAllWithValue(3);
        l.print();
    }
}
