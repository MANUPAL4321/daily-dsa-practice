class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTreeMaximumPathSum {

    private static int maxSum = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        findMaxPath(root);
        return maxSum;
    }

    private static int findMaxPath(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(0, findMaxPath(root.left));
        int right = Math.max(0, findMaxPath(root.right));

        int currentPathSum = left + right + root.val;

        maxSum = Math.max(maxSum, currentPathSum);

        return root.val + Math.max(left, right);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("Maximum Path Sum: " + maxPathSum(root));
    }
}
