import java.util.ArrayList;

public class AVLTree extends BST
{
    // Precondition: Our tree exists, and we are given a valid targ node (one that
    // is not null).
    // Postcondition: The target element is rotate to the left, as long as it is a
    // legal rotation.
    private void rotateLeft(Node prev, Node targ) 
    {
        if(prev == null)
        {
            Node post = targ.right;
            targ.right = post.left;
            post.left = targ;
            root = post;
        } else
        {
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
    }
    
    // Precondition: Our tree exists, and we are given a valid targ node (one that
    // is not null).
    // Postcondition: The target element is rotate to the right, as long as it is a
    // legal rotation.
    private void rotateRight(Node prev, Node targ)
    {
        if (prev == null)
        {
            Node post = targ.left;
            targ.left = post.right;
            post.right = targ;
            root = post;
        } else
        {
            if (targ.left == null)
            {
                System.out.println("ILLEGAL ROTATION");
                return;
            }
            Node post = targ.left;
            targ.left = post.right;
            post.right = targ;
            if (prev.right == targ)
            {
                prev.right = post;
            } else
            {
                prev.left = post;
            }
        }
    }

    // -------------BOTH PRE AND POST CONDITIONS APPLY TO insert() AND insertP()-------------
    // OVERRIDDED FUNCTION !!!!!!
    // Precondition: The AVL tree exists and we are fed a valid key to create 
    // a node.
    // Postcondition: We add the element into the tree, whilst automatically 
    // rotating the necessary elements to keep the tree balanced. 
    public void insert(int key){
        insertP(key, root, null);
    }

    // OVERRIDDED FUNCTION !!!!!!
    protected void insertP(int key, Node curr, Node parent) {
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
            insertP(key, curr.left, curr);
        }
        } else if (key > curr.key) // If val belongs to the right...
        {
            if (curr.right == null) // AND the right is empty, put right
            {
                curr.right = new Node(key);
            } else // if not, continue right
            {
                insertP(key, curr.right,curr);
            }
        }

        System.out.println("At " + curr.key + ". Has a balance of " + balanceCheck(curr));
        if(balanceCheck(curr) > 1)
        {
            if(balanceCheck(curr.right) < 0)
            {
                rotateRight(curr, curr.right);
            }
            rotateLeft(parent, curr);
        } else if (balanceCheck(curr) < -1)
        {
             if(balanceCheck(curr.left) > 0)
             {
                rotateLeft(curr, curr.left);
             }
             rotateRight(parent, curr);
        }
    }


    // OVERRIDDED FUNCTION !!!!!!
    // Precondition: Tree is formatted as normal, with all elements that were
    // inserted still there. Takes in an int to delete in the tree
    // Post condition: That item is removed from the tree and a replacement 
    // is placed accordingly, with rotations throughout the tree if necessary 
    // to keep it balanced.
    public void remove(int key) {
        Node prevToCurr = null;
        Node curr = root;
        Node toDelete;
        Node prevToDel;
        ArrayList<Node> nodes = new ArrayList<>();

        // Start at the very root
        if (root.key == key) 
        {
            prevToCurr = root;
            if (root.left != null) // Check all children to the left
            {
                curr = root.left;
                while (curr.right != null) 
                {
                    nodes.add(curr);
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
                    nodes.add(curr);
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
        } else {
            // Now what if the key ISNT in the root?
            // Starting at the root...
            prevToCurr = root;
            boolean direction = false; //False is left, true is right

            //FIND WHERE IT IS
            while (curr.key != key) 
            {
                nodes.add(curr);
                prevToCurr = curr;
                if (key < curr.key && curr.left != null) // Do we belong left?
                {
                    curr = curr.left;
                }
                if (key > curr.key && curr.right != null) // Do we belong right?
                {
                    curr = curr.right;
                }

            }

            if(prevToCurr.left == curr)
            {
                direction = false;
            } else if (prevToCurr.right == curr)
            {
                direction = true;
            }

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
            } else if(curr.left != null && curr.right == null) // Has a left child only?
            {
                toDelete = curr;
                prevToDel = prevToCurr;
                prevToCurr = curr;
                curr = curr.left;
                while(curr.right != null)
                {
                    nodes.add(curr);
                    prevToCurr = curr;
                    curr = curr.right;
                }

                if(direction)
                {
                    prevToDel.right = curr;
                } else
                {
                    prevToDel.left = curr;
                }

                if(curr.left != null)
                {
                    prevToCurr.right = curr.left;
                } else
                {
                    prevToCurr.right = null;
                }

                curr.left = toDelete.left;
                toDelete = null;
                curr = null;
            } else if (curr.left == null && curr.right != null) // Has a right child only?
            {
                toDelete = curr;
                prevToDel = prevToCurr;
                prevToCurr = curr;
                curr = curr.right;
                while(curr.left != null)
                {
                    nodes.add(curr);
                    prevToCurr = curr;
                    curr = curr.left;
                }

                if(direction)
                {
                    prevToDel.right = curr;
                } else
                {
                    prevToDel.left = curr;
                }

                if(curr.right != null)
                {
                    prevToCurr.left = curr.right;
                } else
                {
                    prevToCurr.left = null;
                }

                curr.right = toDelete.right;
                toDelete = null;
                curr = null;
            } else if (curr.left != null && curr.right != null) // Both children?
            {
                toDelete = curr;
                prevToDel = prevToCurr; // REMEMBER, the side that toDel is depends on DIRECTION (True for Right, False for Left)
                prevToCurr = curr;
                curr = curr.left; 

                if (prevToDel.right == toDelete)
                {
                    direction = true;
                }

                while (curr.right != null) 
                {
                    nodes.add(curr);
                    prevToCurr = curr;
                    curr = curr.right;
                }
                // SPECIAL CASE THAT CAN EASILY CAUSE ERRORS
                if(prevToCurr == toDelete)
                {
                    if(toDelete.right != null)
                    {
                        curr.right = toDelete.right;
                    }

                    if(direction)
                    {
                        prevToDel.right = curr;
                    } else
                    {
                        prevToDel.left = curr;
                    }
                } else
                {
                    if (curr.left != null)
                    {
                        prevToCurr.right = curr.left;
                    } else
                    {
                        prevToCurr.right = null;
                    }
                    
                    curr.right = toDelete.right;
                    curr.left = toDelete.left;
                    
                    if(direction)
                    {
                        prevToDel.right = curr;
                    } else
                    {
                        prevToDel.left = curr;
                    }
                }
            }
        }

        for(Node n: nodes){
            System.out.println(n.key);
        }

        for (int i = nodes.size() - 1; i >= 0; i--)
        {
            Node n = nodes.get(i); //the node in question
            Node p = null;

            if(i >= 1)
            {
                p = nodes.get(i-1);
            }
            // if (i < nodes.size() - 1)
            // {
            //     c = nodes.get(i + 1);
            // }


            if(balanceCheck(n) > 1)
            {
                if(balanceCheck(n.right) < 0)
                {
                    rotateRight(n,  n.right);
                }
                rotateLeft(p, n);
            } else if (balanceCheck(n) < -1)
            {
                if(balanceCheck(n.left) > 0)
                {
                    rotateLeft(n, n.left);
                }
                rotateRight(p, n);
            }
        }
    }
}
