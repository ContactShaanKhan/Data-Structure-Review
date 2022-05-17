class DALNode {
    int val;
    DALNode left, right;

    public DALNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }

    // The print Helper is a pre-order traversal
    private void printHelper(DALNode node, StringBuilder out)
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

public class DeleteAllLeaves {
    public static void Delete (DALNode root) {
        if (root == null)
            return;

        helper(root);
    }
    
    private static boolean helper (DALNode root) {
        if (root == null)
            return false;

        // Return true if we are a leaf
        if (root.left == null && root.right == null)
            return true;

        if (helper(root.left))
            root.left = null;

        if (helper(root.right))
            root.right = null;

        return false;
    }

    public static void main(String... args) {
        // Construct a tree
        DALNode a = new DALNode(25);
        a.left = new DALNode(19);
        a.right = new DALNode(50);
        a.left.left = new DALNode(12);
        a.left.right = new DALNode(20);

        System.out.println("Original Tree: " + a);

        DeleteAllLeaves.Delete(a);

        System.out.println("Expected output: 25 19");
        System.out.println("New Tree: " + a);

    }    
}
