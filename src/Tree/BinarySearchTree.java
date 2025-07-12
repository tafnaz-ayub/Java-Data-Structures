package Tree;

public class BinarySearchTree {
    private Node root;
    public BinarySearchTree(){
        root = null;
    }
    public class Node {
        int value;
        Node right;
        Node left;

        public Node(int value){
            this.value = value;
        }
    }
    public boolean insert(int value){
        Node newNode = new Node(value);
        if(root == null){
            root = newNode;
            return true;
        }
        Node temp = root;
        while(true){
            if(newNode.value<temp.value){
                if(temp.left==null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            }
            else{
                if(temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }
    public boolean contain(int value){
        if(root == null) return false;
        Node temp = root;
        while(temp!=null){
            if(value<temp.value)
                temp = temp.left;
            else if(value> temp.value)
                temp = temp.right;
            else
                return true;
        }
        return false;
    }
    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(8);
        bst.insert(1);
        System.out.println("Root: "+bst.root.value);
        System.out.println("Left: "+bst.root.left.value);
        System.out.println("Right: "+bst.root.right.value);
        if(bst.contain(8)) System.out.println("It is in bst");
        else System.out.println("It is not in bst");
    }
}
