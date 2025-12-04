class BST {
    private Node root;

    public BST()
    {
         root = null;
    }

    public void insert(int key)
    {
        insertP(key, root);
    }

    private void insertP(int key, Node curr){
        //If its the first is empty
        if(curr == null)
        {
            curr = root = new Node(key);
        } else if (key < curr.key) // If the val belongs to the left...
        {
            if (curr.left == null) // AND the left is empty, put left
            {
                curr.left = new Node(key);              
            } else // If not empty, but we need to go that way, let us continue down again until
            {
                insertP(key, curr.left);
            }
        } else if (key > curr.key) // If val belongs to the right...
        {
            if (curr.right == null) // AND the right is empty, put right
            {
                curr.right = new Node(key);
            } else // if not, continue right
            {
                insertP(key, curr.right);
            }
        }
    }

    public boolean search (int key){
        return searchP(key, root);
    }
    private boolean searchP(int key, Node curr)
    {  
        if (curr.key == key) // If we found it, YIPPEE
        {
            return true;
        } else if (key < curr.key && curr.left != null) // Maybe its to the left???
        {
            return searchP(key, curr.left);
        } else if (key > curr.key && curr.right != null) // MAYBE its the right...?
        {
            return searchP(key, curr.right);
        } else {
            return false;
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






    //Add the following functions to your BST
    //Please use this code to verify your tree integrity
    public boolean isBSTOrNot() {
        return isBSTOrNot(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean isBSTOrNot(Node root, int minValue, int maxValue) {
        // check for root is not null or not
        if (root == null) {
            return true;
        }
        // check for current node value with left node value and right node value and recursively check for left sub tree and right sub tree
        if(root.key >= minValue && root.key <= maxValue && isBSTOrNot(root.left, minValue, root.key) && isBSTOrNot(root.right, root.key, maxValue)){
            return true;
        }
        return false;
    }
   // please use the following pieces of code to display your tree in a more easy to follow style (Note* you'll need to place the Trunk class in it's own file)
    public static void showTrunks(Trunk p)
    {
        if (p == null) {
            return;
        }
 
        showTrunks(p.prev);
        System.out.print(p.str);
    }
 
    public void printTree(){
        printTree(root, null, false);
    }

    private void printTree(Node root, Trunk prev, boolean isLeft)
    {
        if (root == null) {
            return;
        }
 
        String prev_str = "    ";
        Trunk trunk = new Trunk(prev, prev_str);
 
        printTree(root.right, trunk, true);
 
        if (prev == null) {
            trunk.str = "———";
        }
        else if (isLeft) {
            trunk.str = ".———";
            prev_str = "   |";
        }
        else {
            trunk.str = "`———";
            prev.str = prev_str;
        }
 
        showTrunks(trunk);
        System.out.println(" " + root.key);
 
        if (prev != null) {
            prev.str = prev_str;
        }
        trunk.str = "   |";
 
        printTree(root.left, trunk, false);
    }

//this goes into it's own file
    class Trunk
   {
    Trunk prev;
    String str;
 
    Trunk(Trunk prev, String str)
    {
        this.prev = prev;
        this.str = str;
    }
   };
}