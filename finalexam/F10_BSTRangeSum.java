import java.util.*;

public class F10_BSTRangeSum {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    static TreeNode buildTree(List<Integer> vals) {
        if (vals.isEmpty() || vals.get(0) == -1) return null;

        TreeNode root = new TreeNode(vals.get(0));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int idx = 1;
        while (!q.isEmpty() && idx < vals.size()) {
            TreeNode node = q.poll();

            int leftVal = vals.get(idx++);
            if (leftVal != -1) {
                node.left = new TreeNode(leftVal);
                q.offer(node.left);
            }

            if (idx >= vals.size()) break;

            int rightVal = vals.get(idx++);
            if (rightVal != -1) {
                node.right = new TreeNode(rightVal);
                q.offer(node.right);
            }
        }
        return root;
    }

    static int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;

        if (root.val < L) {
            return rangeSumBST(root.right, L, R);
        } else if (root.val > R) {
            return rangeSumBST(root.left, L, R);
        } else {
            return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> vals = new ArrayList<>();
        while (sc.hasNextInt()) {
            vals.add(sc.nextInt());
        }

        if (vals.size() < 3) {
            System.out.println("Invalid input");
            return;
        }
        int R = vals.remove(vals.size() - 1);
        int L = vals.remove(vals.size() - 1);

        TreeNode root = buildTree(vals);

        int ans = rangeSumBST(root, L, R);
        System.out.println(ans);

        sc.close();
    }
}
