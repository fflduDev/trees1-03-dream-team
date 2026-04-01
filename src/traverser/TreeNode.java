package traverser;

import java.util.Vector;

public class TreeNode {
    int key;
    Vector<TreeNode> child;

    public TreeNode(int data) {
        key = data;
        child = new Vector<>();
    }
}
