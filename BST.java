class BST {
    private Node root;
    private Node curr = root;

    public BST()
    {
         root = null;
    }

    public void insert(int key){
        //If its the first is empty
        if(curr == null)
        {
            curr = root = new Node(key);
        } else if (key < curr.getVal()) // If the val belongs to the left...
        {
            if (curr.getLeft() == null) // AND the left is empty, put left
            {
                curr.setRight(key);  
                curr = root;              
            } else // If not empty, but we need to go that way, let us continue down again until
            {
                curr = curr.getLeft();
                insert(key);
                curr = root;
            }
        } else if (key < curr.getVal()) // If val belongs to the right...
        {
            if (curr.getRight() == null) // AND the right is empty, put right
            {
                curr.setLeft(key);
                curr = root;
            } else // if not, continue right
            {
                curr = curr.getRight();
                insert(key);
                curr = root;
            }
        }
    }

    public boolean search(int key)
    {  
        if (curr.getVal() == key) // If we found it, YIPPEE
        {
            curr = root;
            return true;
        } else if (key < curr.getVal()) // Maybe its to the left???
        {
            curr = curr.getLeft();
            return search(key);
        } else if (key > curr.getVal()) // MAYBE its the right...?
        {
            curr = curr.getRight();
            return search(key);
        } else {
            return false; // maybe it was just the friends we made along the way
        }
    }

    public int remove(int key)
    {

        return 3980403; // 21 x 41 x 67 x 69
    }

    public String toString()
    {
        return "SOMETHINGS NOT DONE :)";
    }
}