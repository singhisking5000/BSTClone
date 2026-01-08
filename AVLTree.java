public class AVLTree extends BST
{
    protected void rotateLeft(Node prev, Node targ) 
    {
        // this code is buns... time to learn how to rotate...
        if (targ.right == null)
        {
            System.out.println("ILLEGAL ROTATION");
            return;
        }
        Node post = targ.right;
        targ.right = post.left;
        post.left = targ;
        if (prev.right == targ)
        {
            prev.right = post;
        } else
        {
            prev.left = post;
        }
        
    }

    protected void rotateRight(Node prev, Node targ)
    {
        if (targ.left == null)
        {
            System.out.println("ILLEGAL ROTATION");
            return;
        }
        Node post = targ.left;
        targ.right = post.left;
        post.left = targ;
        prev.right = post;
    }
}
