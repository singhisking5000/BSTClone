public class Main {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        //
        tree.insert(10);
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        // tree.insert(6);
        tree.printTree();
        System.out.println(tree);
        System.out.println("----------------------------------------------------");
        // TESTING FOR REMOVE VVVVVVVVVVV
        // int num = 5;
        // System.out.println("removing " + num);
        // tree.remove(num);
        tree.rotateLeft(tree.root, tree.root.left);
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