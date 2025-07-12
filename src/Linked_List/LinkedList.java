package Linked_List;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    public LinkedList(){
        head = null;
        tail = null;
        length = 0;
    }

    private class Node {
        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }
    }

    public void append(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node remove(){
        if(length == 0) return null;

        Node temp = head;
        Node prev = head;

        if(length == 1){
            temp = head;
            head = null;
            tail = null;
        } else {
            while(temp.next != null){
                prev = temp;
                temp = temp.next;
            }
            prev.next = null;
            tail = prev;
        }
        length--;
        return temp;
    }

    public void printList(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + " --> ");
            temp = temp.next;
        }
        System.out.println("null");
        System.out.println("Length of linked list: " + length);
    }

    public static void main(String[] args){
        LinkedList ll = new LinkedList();
        for(int i = 0; i <= 10; i++) {
            ll.append(i);
        }
        ll.printList();
        ll.remove();
        ll.remove();
        ll.printList();
    }
}
