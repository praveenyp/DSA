
// CHECK IF THE TREES ARE IDENTICAL OR TREE IS THE SUB TREE OF ANOTHER...

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = right = null;
    }
}

public class Main5 {

    public boolean isIdentical(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }
        if (tree1 == null || tree2 == null) {
            return false;
        }
        return (tree1.val == tree2.val) &&
                isIdentical(tree1.left, tree2.left) &&
                isIdentical(tree1.right, tree2.right);
    }

    public boolean isSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (isIdentical(root1, root2)) {
            return true;
        }

        return isSubtree(root1.left, root2) || isSubtree(root1.right, root2);

    }

    public static void main(String[] args) {
        Main5 solution = new Main5();

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(5);

        System.out.println(solution.isSubtree(root1, root2));
    }
}