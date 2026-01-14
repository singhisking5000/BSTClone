public class Main {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        //
        tree.insert(6);
        tree.insert(5);
        tree.insert(4);
        tree.insert(2);
        tree.insert(3);
        tree.insert(1);
        tree.insert(7);
        // tree.insert();
        // tree.insert();
        // tree.insert(6);
        tree.printTree();
        System.out.println(tree);
        System.out.println("----------------------------------------------------");
        int num = 1;
        tree.remove(num);
        System.out.println("Removing: " + num);
        num = 2;
        tree.remove(num);
        System.out.println("Removing: " + num);
        // tree.rotateLeft(tree.root.left.left, tree.root.left.left.left);
        // tree.rotateRight(tree.root.left, tree.root.left.left);
        // tree.rotateRight(tree.root, tree.root.left);
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