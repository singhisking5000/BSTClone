public class Node{
    public int key;
    public Node left, right;

    public Node(int item)
    {
        key = item;
        // this is ugly
        left = right = null;
    }

    public boolean hasChildren ()
    {
        if(this.left == null && this.right == null)
        {
            return false;
        } else
        {
            return true;
        }
    }
}