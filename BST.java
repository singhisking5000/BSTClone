import java.util.ArrayList;

class BST {
    public Node root;
    private ArrayList<String> elements = new ArrayList<String>();
    public BST() {
        root = null;
    }

    // !!! FOR BOTH insert() AND insertP()!!!
    // Precondition: We have a tree, empty or not, and we require a key, which is the element we are going to insert
    // Postcondition: The key is inserted into the tree in accordance to the rules placed by having a Binary Search Tree
    public void insert(int key) {
        insertP(key, root);
    }
    private void insertP(int key, Node curr) {
            // If its the first is empty
        if (curr == null) {
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

        System.out.println("At " + curr.key + ". Has a balance of " + balanceCheck(curr)); //<-------- causing a null pter exception through height check
    }


    // !!!FOR BOTH search() AND searchP()!!!
    // Precondition: A tree exists, and we take in a key which we search for, telling us whether it exists in this tree or not
    // Postcondition: Return true is the elemnt exists in the tree, false if not
    public boolean search(int key) {
        if (root != null)
        {
            return searchP(key, root);
        } else
        {
            return false;
        }
    }

    private boolean searchP(int key, Node curr) {
        if (curr.key == key) // If we found it, YIPPEE
        {
            System.out.println(getHeight(curr));
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

    // Precondition: Tree is formatted as normal, with all elements that were inserted still there. Takes in an int to delete in the tree
    // Post condition: Int taken in will be deleted from the tree, with the appropiate node replacing it to make the tree still logical
    public void remove(int key) {
        Node prevToCurr = null;
        Node curr = root;
        Node toDelete;
        Node prevToDel;
        // Start at the very root
        if (root.key == key) 
        {
            prevToCurr = root;
            if (root.left != null) // Check all children to the left
            {
                curr = root.left;
                while (curr.right != null) 
                {
                    prevToCurr = curr;
                    curr = curr.right;
                }

                if (curr.left != null) 
                {
                    prevToCurr.right = curr.left;
                } else 
                {
                    prevToCurr.right = null;
                }
                curr.left = root.left;
                curr.right = root.right;
                root = curr;
            } else if (root.right != null) // Check all children to the right
            {
                curr = root.right;
                while (curr.left != null)
                {
                    prevToCurr = curr;
                    curr = curr.left;
                }
                if (curr.right != null) 
                {
                    prevToCurr.left = curr.right;
                } else 
                {
                    prevToCurr.left = null;
                }
                curr.left = root.left;
                curr.right = root.right;
                root = curr;
            } else if (root.left == null && root.right == null)// If its LITERALLY just the root
            {
                root = null;
            }
        } else // Now what if the key ISNT in the root?
        {
            // SEARCH FOR DEM
            // Starting at the root...
            prevToCurr = root;
            boolean direction = false; //False is left, true is right
            if (key < root.key && root.left != null) 
            {
                direction = false;
                curr = root.left;
            }
            if (key > root.key && root.right != null) 
            {
                direction = true;
                curr = root.right;
            }
            while (curr.left != null && curr.left.key != key && curr.right != null && curr.right.key != key) 
            {
                if (key < curr.key && curr.left != null) 
                {
                    prevToCurr = curr;
                    curr = curr.left;
                }
                if (key > curr.key && curr.right != null)
                {
                    prevToCurr = curr;
                    curr = curr.right;
                }
            }
            //no children
            if(curr.left == null && curr.right == null) // No children?
            {
                curr = null;
                if(direction)
                {
                    prevToCurr.right = null;
                }  else
                {
                    prevToCurr.left = null;
                }
            } else if(curr.left != null && curr.right == null) // Left Child only?
            {
                // If we only have a left child
                if(direction)
                {
                    prevToCurr.right = curr.left;
                    curr = null;
                } else 
                {
                    prevToCurr.left = curr.left;
                    curr = null;
                }
            } else if (curr.left == null && curr.right != null) // Right Child only?
            {
                if(direction)
                {
                    prevToCurr.right = curr.right;
                    curr = null;
                } else
                {
                    prevToCurr.left = curr.right;
                    curr = null;
                }
            } else if (curr.left != null && curr.right != null) // Both children?
            {
                if (curr.left != null && curr.left.key == key) // Is it the one on the left?
                {
                    prevToCurr = curr;
                    prevToDel = curr;
                    curr = curr.left;
                    toDelete = curr;
                    if (toDelete.left != null) 
                    {
                        prevToCurr = curr;
                        curr = curr.left;
                        while (curr.right != null) 
                        {
                            prevToCurr = curr;
                            curr = curr.right;
                        }
                        if (curr.left != null) 
                        {
                            prevToCurr.right = curr.left;
                        } else
                        {
                            prevToCurr.right = null;
                        }
                        curr.left = toDelete.left;
                        curr.right = toDelete.right;
                        prevToDel.left = curr;
                    } else if (toDelete.right != null) 
                    {
                        prevToCurr = curr;
                        curr = curr.right;
                        while (curr.left != null) 
                        {
                            prevToCurr = curr;
                            curr = curr.left;
                        }
                        if (curr.right != null) 
                        {
                            prevToCurr.left = curr.right;
                        } else 
                        {
                            prevToCurr.left = null;
                        }
                        curr.left = toDelete.left;
                        curr.right = toDelete.right;
                        prevToDel.right = curr;
                    }
                }
                if (curr.right.key == key) // Is it the one on the left?
                {
                    prevToCurr = curr;
                    prevToDel = curr;
                    curr = curr.right;
                    toDelete = curr;
                    if (toDelete.left != null) 
                    {
                        prevToCurr = curr;
                        curr = curr.left;
                        while (curr.right != null) 
                        {
                            prevToCurr = curr;
                            curr = curr.right;
                        }
                        if (curr.left != null) 
                        {
                            prevToCurr.right = curr.left;
                        } else 
                        {
                            prevToCurr.right = null;
                        }

                        curr.left = toDelete.left;
                        curr.right = toDelete.right;
                        prevToDel.left = curr;
                    } else if (toDelete.right != null) 
                    {
                    prevToCurr = curr;
                    curr = curr.right;
                    while (curr.left != null) 
                    {
                        prevToCurr = curr;
                        curr = curr.left;
                    }
                    if (curr.right != null) 
                    {
                        prevToCurr.left = curr.right;
                    } else {
                        prevToCurr.left = null;
                    }
                    curr.left = toDelete.left;
                    curr.right = toDelete.right;
                    prevToDel.right = curr;
                    }
                }
            }
        }
    }


    // Precondition: Tree exists, and we check the balance of a set node in the tree
    // Postcondition: Returns an int that represents the balance of the branches on each side of the node (- means more left elements, + is more right elements)
    public int balanceCheck(Node checkMe)
    {
        if(checkMe == null)
        {
            return 0;
        } else
        {
           return getHeight(checkMe.right) - getHeight(checkMe.left);     
        }
    }

    // Precondition: Requires a tree exists and a node to find the height of
    // Postcondition: returns an int representing the height of the node we provide the function
    private int getHeight(Node n)
    {
        if(n == null)
        {
            return -1;
        }
        if(n.left == null && n.right == null)
        {
            return 0;
        }

       return 1 + Math.max(getHeight(n.left), getHeight(n.right));
    }


    // Precondition: Tree exists
    // Postcondition: Returns a readable and easily formatted string that represents the tree and its branches.
    public String toString() {
        
        return "";
    }

    private ArrayList<String> getElements()
    {
        return getElementsP(root);
    }
    private ArrayList<String> getElementsP(Node curr)
    {
        elements.add(Integer.toString(curr.key));

        elements.add(getChildren(curr));
        if(curr.left.hasChildren())
        {
            getElementsP(curr.left);
        }
        return elements;
    }
    private String getChildren(Node n)
    {
        String toReturn = "";
        if(n.left != null)
        {
            toReturn += n.left.key + ", ";
        } else
        {
            toReturn += ", - ";
        }
        if(n.right != null)
        {
            toReturn += n.right.key + ", ";
        } else
        {
            toReturn += ", - ";
        }
        return toReturn;
    }

























    // Add the following functions to your BST
    // Please use this code to verify your tree integrity
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