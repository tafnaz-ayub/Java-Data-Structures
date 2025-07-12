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

    public Node removeLast(){
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
        if(length == 0){
            head = null;
            tail = null;
        }
        return temp;
    }
    public void prepend(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }
        else {
            Node temp = head;
            head = newNode;
            newNode.next = temp;
        }
        length++;
    }
    public Node removeFirst(){
        if(length == 0) return null;
        Node temp = head;
        if(length == 1){
            head = null;
            tail = null;
        }
        else{
            head = temp.next;
            temp.next = null;
        }
        length--;
        if(length == 0){
            head = null;
            tail = null;
        }
        return temp;
    }
    public Node get(int index){
        if(index<0 || index>length) return null;
        Node temp = head;
        for(int i=0;i<index;i++){
            temp = temp.next;
        }
        return temp;
    }
    public boolean set(int value, int index){
        if(index<0 || index>length) return false;
        Node newNode = new Node(value);
        Node temp = get(index);
        temp.value = value;
        return true;
    }
    public boolean insert(int value, int index){
        if(index<0 || index>length) return false;
        if(index == 0) {
            prepend(value);
            return true;
        }
        if(index == length){
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index-1);
        Node after = temp.next;
        temp.next = newNode;
        newNode.next = after;
        length++;
        return true;
    }
    public Node remove(int index){
        if(index<0 || index>length) return null;
        if(index == 0){
            return removeFirst();
        }
        if(index == length-1){
            return removeLast();
        }
        Node prev = get(index-1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }
    public void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;

        for(int i = 0 ;i<length;i++){
            after = temp.next;
            temp.next = before;
            before =temp;
            temp = after;
        }
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
        ll.removeLast();
        ll.removeLast();
        ll.prepend(10);
        ll.printList();
        ll.removeFirst();
        ll.printList();
        System.out.println(ll.get(8).value);
        ll.set(10,8);
        ll.printList();
        ll.insert(11,9);
        ll.printList();
        ll.remove(9);
        ll.printList();
        ll.reverse();
        ll.printList();
    }
}
