public class AVLTree extends BST
{
    protected void rotateLeft(Node prev, Node targ) 
    {
        if(prev == null)
        {
            Node post = targ.right;
            targ.right = post.left;
            post.left = targ;
            root = post;
        } else
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
    }

    protected void rotateRight(Node prev, Node targ)
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

    // NOW OVERRIDE INSERT SO IT AUTOBALANCES ON INSERTS!
    protected void insertP(int key, Node curr) {
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
        if(balanceCheck(curr) > 1)
        {
            // WE got problems boys
        }
    }
}
