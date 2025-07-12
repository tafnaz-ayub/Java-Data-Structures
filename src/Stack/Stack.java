package Stack;
public class Stack {
    private Node top;
    private int height;
    public class Node{
        int value;
        Node next;
        public Node(int value){
            this.value = value;
        }
    }
    public Stack(int value){
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }
    public void push(int value){
        Node newNode = new Node(value);
        if(height==0) top = newNode;
        else{
            newNode.next = top;
            top = newNode;
        }
    }
    public Node pop(){
        if(height==0) return null;
        Node temp = top;
        top = temp.next;
        temp.next = null;
        return temp;
    }
    public Node peek() {
        return top;
    }
    public void printStack() {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        Stack stack = new Stack(10);
        stack.push(20);
        stack.push(30);
        stack.printStack();
        stack.pop();
        stack.printStack();
        System.out.println(stack.peek().value);
    }
}