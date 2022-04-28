package verifyavl;

public class VerifyAVL {
    public static boolean verifyAVL(AVLNode root) {
        return (isTree(root) && isBSTUtil(root, 0, Integer.MAX_VALUE) && checkHeight(root, 0));
    }

    public static boolean isTree(AVLNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = 0;
        int rightHeight = 0;
        if ((root.left != null && root.left.key > root.key) || (root.right != null && root.right.key < root.key)) {
            return false;
        }
        if (isTree(root.left) && isTree(root.right)) {
            if (root.right != null) {
                rightHeight = root.right.height;
            }
            if (root.left != null) {
                leftHeight = root.left.height;
            }
            root.height = Math.max(leftHeight, rightHeight) + 1;
            return Math.abs(leftHeight - rightHeight) <= 1;
        }
        return false;
    }

    public static boolean checkHeight(AVLNode root, int height){
        if(root == null){
            return true;
        } else if (root.height != height){
            return false;
        }
        return (checkHeight(root.left, height+1) && checkHeight(root.right, height+1));
    }

    public static boolean isBSTUtil(AVLNode node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.key < min || node.key > max) {
            return false;
        }
        return (isBSTUtil(node.left, min, node.key- 1) && isBSTUtil(node.right, node.key + 1, max));
    }
}