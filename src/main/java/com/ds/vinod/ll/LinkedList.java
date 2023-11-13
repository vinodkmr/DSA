package com.ds.vinod.ll;

public class LinkedList {
    private int size;
    private Node head;

    public int getSize() {
        return size;
    }
    public Node getHead() {
        return head;
    }

    public void add(int data){
        Node node = new Node(data);
        if(head == null){
            head = node;
            size++;
        }else{
            Node temp = head;
            while (temp.getNext() != null){
                temp = temp.getNext();
            }
            temp.setNext(node);
            size++;
        }
    }

    public void traverse(){
        Node temp = head;
        while (temp  != null){
            System.out.print(" "+temp.getData());
            temp = temp.getNext();
        }
        System.out.println();
    }

    public void delete(int data){
        if(head.getData() == data){
            Node temp = head;
            head = head.getNext();
            temp.setNext(null);
            size--;
            return;
        }

        Node prev = head;
        Node cur = head.getNext();
        while (cur != null){
            if(cur.getData() == data){
                prev.setNext(cur.getNext());
                cur.setNext(null);
                return;
            }
            prev = cur;
            cur = cur.getNext();
        }
        System.out.println("Item does not exist");
    }

    public void reverse() {
      Node prev = null;
      Node cur = head;
      while(cur != null){
          Node next = cur.getNext();
          cur.setNext(prev);

          prev = cur;
          cur = next;
      }
      head = prev;
    }

    public void reverseRecursive(){
        Node prev = null;
        Node cur = head;
        reverseRecursive(prev, cur);
    }

    private void reverseRecursive(Node prev, Node cur) {
        if(cur == null){
            head = prev;
            return;
        }

        Node next = cur.getNext();
        cur.setNext(prev);
        reverseRecursive(cur, next);
    }

    public void ascendInsert(int data) {
        Node node = new Node(data);
        if(head == null || head.getData() > data){
            node.setNext(head);
            head = node;
            size++;
        }else{
            Node prev = head;
            Node cur = head.getNext();
            while(cur != null){
                if(cur.getData() < data){
                    prev = cur;
                    cur = cur.getNext();
                }else{
                    prev.setNext(node);
                    node.setNext(cur);
                    size++;
                    return;
                }
            }
            prev.setNext(node);
            size++;
        }



    }
}
