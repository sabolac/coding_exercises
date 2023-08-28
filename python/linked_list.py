from pprint import pp


class LinkedList:
    class Node:
        def __init__(self, v):
            self.value = v
            self.next = None

    def __init__(self):
        self.size = 0
        self.head = None
        self.tail = None

    def insert(self, v):
        n = LinkedList.Node(v)
        n.next = self.head
        self.head = n
        if not self.tail:
            self.tail = n
        self.size += 1

    def insert_after(self, n1, n2):
        if not n1.next:
            self.tail = n2
        n2.next = n1.next
        n1.next = n2
        self.size += 1

    def print(self):
        n = self.head
        while n:
            print(n.value, end=" -> ")
            n = n.next
        print()

    def find_first_node_with_value(self, v):
        n = self.head
        while n and n.value != v:
            n = n.next
        return n

    def append(self, v):
        if self.size == 0:
            self.insert(v)
            return
        n = LinkedList.Node(v)
        self.tail.next = n
        self.tail = n
        self.size += 1

    def remove_last(self):
        pass


def main():
    l = LinkedList()
    l.insert(1)
    l.print()
    l.insert(2)
    l.insert(3)
    l.insert(4)
    l.insert(5)
    l.print()
    l.insert_after(l.find_first_node_with_value(1), LinkedList.Node(0))
    l.print()
    l.insert_after(l.find_first_node_with_value(3), LinkedList.Node(2.5))
    l.print()
    l.insert_after(l.find_first_node_with_value(5), LinkedList.Node(4.5))
    l.print()
    l.append(-1)
    l.print()


main()