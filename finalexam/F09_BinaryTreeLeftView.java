import java.util.*;

public class F09_BinaryTreeLeftView {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    // 建立二元樹（層序輸入，-1代表null）
    static TreeNode buildTree(List<Integer> vals) {
        if (vals.isEmpty() || vals.get(0) == -1) return null;

        TreeNode root = new TreeNode(vals.get(0));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int idx = 1;
        while (!q.isEmpty() && idx < vals.size()) {
            TreeNode node = q.poll();

            // 左子節點
            int leftVal = vals.get(idx++);
            if (leftVal != -1) {
                node.left = new TreeNode(leftVal);
                q.offer(node.left);
            }

            if (idx >= vals.size()) break;

            // 右子節點
            int rightVal = vals.get(idx++);
            if (rightVal != -1) {
                node.right = new TreeNode(rightVal);
                q.offer(node.right);
            }
        }

        return root;
    }

    // BFS輸出每層最左側節點值
    static void printLeftView(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        System.out.print("LeftView:");

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (i == 0) {
                    System.out.print(" " + node.val);
                }
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> vals = new ArrayList<>();
        while (sc.hasNextInt()) {
            vals.add(sc.nextInt());
        }
        sc.close();

        TreeNode root = buildTree(vals);
        printLeftView(root);
    }
}
