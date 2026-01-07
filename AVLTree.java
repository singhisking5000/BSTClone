public class AVLTree extends BST
{
    protected void rotateLeft(Node prev, Node targ) 
    {
        // this code is buns... time to learn how to rotate...
        Node post = targ.right;
        targ.right = post.left;
        // targ.left should remain the same
        prev.right = post;
    }
}
