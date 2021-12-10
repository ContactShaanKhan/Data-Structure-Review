class TreeNode
{
    char val;
    TreeNode left, right;

    public TreeNode(char val)
    {
        this.val = val;
        this.left = this.right = null;
    }
}

// All of the following are ways to get the depth of a tree
public class TreeDepth {
    // Method 1
    public static int depth1(TreeNode root)
    {
        // Base case
        if(root == null)
            return 0;

        // Take max of the left and right heights
        // If this was a ternary tree, just get max of all 3

        int max, left, right;

        // Get height of the left sub-tree
        left = depth1(root.left);

        // Get height of the right sub-tree
        right = depth1(root.right);

        // Take the Max of them
        max = (left > right)? left : right;

        // Return max + 1
        return max + 1;
    }

    // A Condensed version of depth1, but it really does it the same way
    public static int depth2(TreeNode root) 
    {
        return (root == null)? 0 : 1 + Math.max( depth2(root.left) , depth2(root.right)  );
    }
    
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
                                |___
                                    |
                                    Z
        */                   

        TreeNode P = new TreeNode('P');
        TreeNode A = new TreeNode('A');
        TreeNode Q = new TreeNode('Q');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode Z = new TreeNode('Z');

        P.left = A;
        P.right = Q;
        Q.left = B;
        Q.right = C;
        C.right = Z;

        System.out.println("Expected Height of the Tree: 4");
        System.out.println("Height found with method 1: " + depth1(P));
        System.out.println("Height found with method 2: " + depth2(P));
    }
}
