public class Main {
    public static void main(String[] args) {
        BST tree = new BST();
        //
        tree.insert(10);
        tree.insert(5);
        tree.insert(9);
        tree.insert(8);
        tree.insert(6);
        tree.insert(7);
        tree.printTree();
        System.out.println(tree);
        System.out.println("----------------------------------------------------");
        // TESTING FOR REMOVE VVVVVVVVVVV
        int num = 5;
        System.out.println("removing " + num);
        tree.remove(num);
        tree.printTree();
        System.out.println(tree.toString());
        System.out.println("----------------------------------------------------");
        //tree.insert(3);
        // tree.printTree();
        // System.out.println(tree.toString());
        
        // System.out.println("Current Tree Balance: " + tree.balanceCheck(tree.root));
        // System.out.println(tree.search(10));
        // System.out.println(tree.search(9));
    }
}