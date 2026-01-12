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
    public void insert(int key){
        insertP(key, root, null);
    }

    // NOW OVERRIDE INSERT SO IT AUTOBALANCES ON INSERTS!
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

        System.out.println("At " + curr.key + ". Has a balance of " + balanceCheck(curr)); //<-------- causing a null pointer exception through height check
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
}
