#!/usr/bin/env python3

# pylint: disable=invalid-name
# pylint: disable=missing-class-docstring
# pylint: disable=missing-function-docstring
# pylint: disable=missing-module-docstring
from pprint import pprint as pp

# Implement a nested class DoubleNode for building doubly-linked lists, where
# each node contains a reference to the item preceding it and the item following it in the
# list (null if there is no such item). Then implement static methods for the following
# tasks: insert at the beginning, insert at the end, remove from the beginning, remove
# from the end, insert before a given node, insert after a given node, and remove a given
# node.


class LinkedList:
    class DoubleNode:
        def __init__(self, v):
            self.value = v
            self.next = None
            self.previous = None

    def __init__(self):
        self.head = None

    def insert(self, v):
        node = LinkedList.DoubleNode(v)
        if not self.head:
            self.head = node
            return
        node.next = self.head
        self.head = node

    def print(self):
        n = self.head
        while n:
            pp(n.value)
            n = n.next


def main():
    l = LinkedList()
    l.insert(1)
    l.insert(2)
    l.insert(3)
    l.print()


main()
