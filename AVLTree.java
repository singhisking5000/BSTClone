public class AVLTree extends BST
{
    protected void rotateLeft(Node prev, Node targ) 
    {
        Node post = targ.right;
        prev.right = post;
        if(post.left != null)
        {
            targ.right = post.left;
        }
        post.left = targ;
    }
}
