public class CompareTree {
    class Node {
        int val;
        Node left, right;
    }

    public boolean isIdentical(Node a, Node b) {
        // If both are null they are the same
        if (a == null && b == null)
            return true;

        // If just one is null, they are different
        if (a == null || b == null)
            return false;

        // Compare the node we are looking at
        boolean root = a.val == b.val;

        // Compare left
        boolean left = isIdentical(a.left, b.left);

        // Compare right
        boolean right = isIdentical(a.right, b.right);

        return root && left && right;
    }

    public boolean isMirror(Node a, Node b) {
        // If both are null they are the same
        if (a == null && b == null)
            return true;

        // If just one is null, they are different
        if (a == null || b == null)
            return false;

        // Compare the node we are looking at
        boolean root = a.val == b.val;

        // Compare left
        boolean left = isIdentical(a.left, b.right);

        // Compare right
        boolean right = isIdentical(a.right, b.left);

        return root && left && right;
    }
}
