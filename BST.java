class BST {

    private Node root;

    public BST()
    {
         root = null;
    }

   
    public void insert(int key){
        if(root == null)
        {
            root = new Node(key);
        } else if(key > root.getVal())
        {
            root.setRight(key);
        }
    }

    public boolean search(int key){

    }

    public int remove(int key){

    }

    public String toString(){
        
    }

}