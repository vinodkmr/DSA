package com.ds.vinod.ll;

public class TestLinkedList {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        System.out.println(linkedList.getSize());
        System.out.println("Adding");
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(40);

        System.out.println(linkedList.getSize());

        System.out.println("Traversing");
        linkedList.traverse();

        System.out.println("Deleting");
        linkedList.delete(40);


        linkedList.traverse();
        System.out.println("Reversing");
        linkedList.reverse();
        linkedList.traverse();


        System.out.println("Reversing using recursive");
        linkedList.reverseRecursive();
        linkedList.traverse();

        System.out.println("Ascending list order insertion");
        LinkedList list = new LinkedList();
        list.ascendInsert(10);
        list.ascendInsert(5);
        list.ascendInsert(-10);
        list.ascendInsert(99);
        list.traverse();

    }
}
