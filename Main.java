public class Main {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        // Please feel free to test anything you would like, I tried to organize this so that it was easier to see 
        // before and after a removed item, but you can change that if you'd like.
        tree.insert(6);
        tree.insert(5);
        tree.insert(4);
        tree.insert(2);
        tree.insert(3);
        tree.insert(1);
        tree.insert(7);
        tree.printTree();
        System.out.println(tree);
        System.out.println("----------------------------------------------------");
        int num = 1;
        tree.remove(num);
        System.out.println("Removing: " + num);
        num = 2;
        tree.remove(num);
        System.out.println("Removing: " + num);
        tree.printTree();
        System.out.println(tree.toString());
        System.out.println("----------------------------------------------------");
    }
}