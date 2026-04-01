package traverser;

import java.util.Stack;

public class DepthFirstTraversal {

    // Perform iterative DFS on node starting from root (pre-order)
    public static void iterativeDFS(TreeNode node) {
        if (node == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);

        while (!stack.empty()) {
            TreeNode currentNode = stack.pop();
            System.out.println("Current: " + currentNode.key);
            System.out.println("--- ");

            for (int i = currentNode.child.size() - 1; i >= 0; i--) {
                stack.push(currentNode.child.get(i));
            }
        }
    }

    // Perform recursive DFS starting from root
    public static void recursiveDFS(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.println("Current: " + node.key);
        System.out.println("--- ");

        for (TreeNode child : node.child) {
            recursiveDFS(child);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);

        (root.child).add(new TreeNode(2));
        (root.child).add(new TreeNode(34));
        (root.child).add(new TreeNode(56));
        (root.child).add(new TreeNode(100));

        (root.child.get(0).child).add(new TreeNode(77));
        (root.child.get(0).child).add(new TreeNode(88));

        (root.child.get(2).child).add(new TreeNode(1));

        (root.child.get(3).child).add(new TreeNode(7));
        (root.child.get(3).child).add(new TreeNode(8));
        (root.child.get(3).child).add(new TreeNode(9));

        System.out.println("=== Iterative DFS ===");
        iterativeDFS(root);

        System.out.println("\n=== Recursive DFS ===");
        recursiveDFS(root);
    }
}
