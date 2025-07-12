package Queue;

public class Queue {
    private Node first;
    private Node last;
    private int length;

    public Queue(){
        first = null;
        last = null;
        length = 0;
    }

    public class Node {
        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }
    }
    public void enqueue(int val){
        Node newNode = new Node(val);
        if(length == 0){
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        length++;
    }
    public Node dequeue(){
        if(length==0) return null;
        Node temp = first;
        first = temp.next;
        temp.next = null;
        length--;
        if(length==0){
            first = null;
            last = null;
        }
        return temp;
    }
    public void printQueue(){
        Node temp = first;
        while(temp != null){
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println("\nLength of Queue: " + length);
    }
    public static void main(String[] args){
        Queue queue = new Queue();
        for(int i = 1;i<=10;i++)
            queue.enqueue(i);
        queue.printQueue();
        for(int i = 1;i<=5;i++)
            queue.dequeue();
        queue.printQueue();
    }
}
