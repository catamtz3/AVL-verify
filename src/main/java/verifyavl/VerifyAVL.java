package verifyavl;

public class VerifyAVL {
    public static boolean verifyAVL(AVLNode root) {
        return (isTree(root) && isBSTUtil(root, 0, Integer.MAX_VALUE));
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
            if(root.height != (1+Math.max(leftHeight, rightHeight))) {
                return false;
            }
            root.height = Math.max(leftHeight, rightHeight) + 1;
            return Math.abs(leftHeight - rightHeight) <= 1;
        }
        return false;
    }

//    public static boolean checkHeight(AVLNode root){
//        int leftH = root.left != null ? root.height: -1;
//        int rightH = root.right != null ? root.height: -1;
//        if (root.height != (1+Math.max(leftH,rightH))){
//            return false;
//        }
//        return true;
//    }

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