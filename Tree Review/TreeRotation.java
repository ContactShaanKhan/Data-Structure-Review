class TreeNode
{
    public char val;
    public TreeNode left, right;

    public TreeNode(char val)
    {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    // Root of the Tree
    public static void leftRotate(TreeNode root) 
    {        
        /*
                        P                                      
                ________|________                           
                |               |
                A               Q            ------> 
                            ____|____
                            |       |
                            B       C

                            
                        Q
                ________|________
                |               |
                P               C
            ____|____
            |       |
            A       B
        */

        TreeNode P, A, Q, B, C, temp;
        P = A = Q = B = C = null;

        P = root;
        A = P.left;
        Q = P.right;

        if(Q != null)
        {
            B = Q.left;
            C = Q.right;
        }

        // Temporarily store B since it is going to move
        temp = B;

        // Now set right child of Q to be P
        if(Q != null)
            Q.left = P;
        
        P.right = temp;
        
    }

    public static void rightRotate(TreeNode root)
    {
        /*
                        Q
                ________|________
                |               |
                P               C      ------> 
            ____|____
            |       |
            A       B

                        P                                      
                ________|________                           
                |               |
                A               Q            
                            ____|____
                            |       |
                            B       C

        */

        TreeNode P, A, Q, B, C, temp;
        P = A = Q = B = C = null;

        Q = root;
        P = Q.left;
        C = Q.right;

        if(P != null)
        {
            A = P.left;
            B = P.right;
        }

        // Temporarily store B since it is going to move
        temp = B;

        // Now set right child of Q to be P
        if(P != null)
            P.right = Q;
        
        Q.left = temp;
    }

    public static int getHeight(TreeNode root) 
    {
        return (root == null)? 0 : Math.max( getHeight(root.left) , getHeight(root.right) ) + 1;
    }

    // The print Helper is a pre-order traversal
    private void printHelper(TreeNode node, StringBuilder out)
    {
        if (node == null)
            return;
        out.append(node.val + " ");
        printHelper(node.left, out);
        printHelper(node.right, out);
    }

    @Override
    public String toString()
    {
        StringBuilder out = new StringBuilder();

        printHelper(this, out);

        return out.toString();
    }
}

// https://en.wikipedia.org/wiki/Tree_rotation

public class TreeRotation 
{
    public static void main(String... args)
    {
       /* Make this tree:
                    P                                      
            ________|________                           
            |               |
            A               Q       
                        ____|____
                        |       |
                        B       C
       */ 

        TreeNode P = new TreeNode('P');
        TreeNode A = new TreeNode('A');
        TreeNode Q = new TreeNode('Q');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');

        P.left = A;
        P.right = Q;
        Q.left = B;
        Q.right = C;

        System.out.println("Original Tree (Pre-order): " + P);

        TreeNode.leftRotate(P);

        System.out.println("After Right Rotate (Pre-order): " + Q);

        TreeNode.rightRotate(Q);

        System.out.println("After Left Rotate (Pre-order) (Same as original): " + P);
    }
}
