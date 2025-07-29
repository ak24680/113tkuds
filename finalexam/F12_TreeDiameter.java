import java.util.*;

public class F12_TreeDiameter {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    static int maxDiameter = 0;

    static TreeNode buildTree(List<Integer> vals) {
        if (vals.isEmpty() || vals.get(0) == -1) return null;

        TreeNode root = new TreeNode(vals.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int idx = 1;
        while (!queue.isEmpty() && idx < vals.size()) {
            TreeNode node = queue.poll();

            int leftVal = vals.get(idx++);
            if (leftVal != -1) {
                node.left = new TreeNode(leftVal);
                queue.offer(node.left);
            }

            if (idx >= vals.size()) break;

            int rightVal = vals.get(idx++);
            if (rightVal != -1) {
                node.right = new TreeNode(rightVal);
                queue.offer(node.right);
            }
        }
        return root;
    }

    static int height(TreeNode node) {
        if (node == null) return 0;

        int leftH = height(node.left);
        int rightH = height(node.right);

        int diameterHere = leftH + rightH;
        if (diameterHere > maxDiameter) {
            maxDiameter = diameterHere;
        }

        return Math.max(leftH, rightH) + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> vals = new ArrayList<>();
        while (sc.hasNextInt()) {
            vals.add(sc.nextInt());
        }
        TreeNode root = buildTree(vals);
        maxDiameter = 0;
        height(root);

        System.out.println(maxDiameter);

        sc.close();
    }
}
