public class Node{
    int key;
    Node left, right;

    public Node(int item)
    {
        key = item;
        // this is ugly
        left = right = null;
    }

    public int getVal()
    {
        return key;
    }
    
    //Children
    public void setLeft(int item)
    {
        left = new Node(item);
    }
    public void setRight(int item)
    {
        right = new Node(item);
    }
    public Node getLeft()
    {
        return left;
    }
    public Node getRight()
    {
        return right;
    }
}