public class Main {
    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(5);
        tree.insert(1);
        tree.insert(0);
        tree.insert(10);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(3);
        tree.insert(-1);
        tree.insert(-2);
        tree.insert(-3);
        tree.printTree();
        System.out.println("----------------------------------------------------");
        System.out.println("removing 5");
        tree.remove(5);
        tree.printTree();
        System.out.println("----------------------------------------------------");
        tree.insert(5);
        tree.printTree();
        
        System.out.println("Current Tree Balance: " + tree.balanceCheck(tree.root));
        System.out.println(tree.search(10));
        System.out.println(tree.search(9));
    }
}