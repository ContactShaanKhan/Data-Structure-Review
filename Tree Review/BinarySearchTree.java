public class BinarySearchTree {
    public int val;
    public BinarySearchTree left, right;

    public BinarySearchTree(int val) {
        this.val = val;
    }

    // The print Helper is a pre-order traversal
    private void printHelper(BinarySearchTree node, StringBuilder out)
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

    public void insert(int val) {
        BinarySearchTree root = this;
        
        BinarySearchTree ptr = root;
        while (ptr != null) {
            // Not allowed
            if (val == ptr.val)
                return;

            else if (val < ptr.val) {
                if (ptr.left == null) {
                    ptr.left = new BinarySearchTree(val);
                    return;
                }
                else {
                    ptr = ptr.left;
                }
            }

            else {
                if (ptr.right == null) {
                    ptr.right = new BinarySearchTree(val);
                    return;
                }
                else {
                    ptr = ptr.right;
                }
            }
        }
    }
    
    public int inOrderSuccessor(BinarySearchTree root)
    {
        int minv = root.val;
        while (root.left != null)
        {
            minv = root.left.val;
            root = root.left;
        }
        return minv;
    }


    // Returns the new tree
    public BinarySearchTree remove(int val) {
        BinarySearchTree root = this;

        BinarySearchTree ptr = root;
        BinarySearchTree parent = null;

        while (ptr != null) {
            // Found the node to delete
            if (val == ptr.val) {
                // Case 1: The node is a leaf
                if (ptr.left == null && ptr.right == null) {
                    // Simply remove then...

                    // If we are removing the root
                    if (parent == null) {
                        return null;
                    }
                    else {
                        // If this was the left child
                        if (parent.left.val == val) {
                            parent.left = null;
                            return root;
                        }
                        else {
                            parent.right = null;
                            return root;
                        }
                    }
                }

                // Case 2: Only one child
                // 2a: left is null
                else if (ptr.left == null && ptr.right != null) {
                    if (root.val == val) {
                        return ptr.right;
                    }
                    // If this was the left child
                    else if (parent.left.val == val) {
                        parent.left = ptr.right;
                        return root;
                    }
                    else {
                        parent.right = ptr.right;
                        return root;
                    }
                }

                // 2b
                else if (ptr.right == null && ptr.left != null) {
                    if (root.val == val) {
                        return ptr.left;
                    }
                    // If this was the left child
                    else if (parent.left.val == val) {
                        parent.left = ptr.left;
                        return root;
                    }
                    else {
                        parent.right = ptr.left;
                        return root;
                    }
                }

                // Case 3: Two children:
                else {
                    // Find in order successor
                    if (root.val == val) {
                        int temp = inOrderSuccessor(root.right);
                        
                        // Now delete that node
                        remove(temp);

                        root.val = temp;
                        return root;
                    }
                    else if (parent.left.val == val) {
                        int temp = inOrderSuccessor(ptr.right);

                        remove(temp);

                        ptr.val = temp;
                        return root;
                    }
                }
            }
                
            // The rest is responsible for traversing

            else if (val < ptr.val) {
                if (ptr.left == null) {
                    throw new IllegalAccessError();
                }
                else {
                    parent = ptr;
                    ptr = ptr.left;
                }
            }

            else {
                if (ptr.right == null) {
                    throw new IllegalAccessError();
                }
                else {
                    parent = ptr;
                    ptr = ptr.right;
                }
            }
        }

        throw new IllegalAccessError();
    }

    public static void main (String... args) {
        BinarySearchTree t = new BinarySearchTree(50);
        t.insert(75);
        t.insert(100);
        t.insert(25);
        t.insert(10);
        t.insert(30);
        t.insert(60);

        System.out.println("Initial tree:" + t);
    }
}
