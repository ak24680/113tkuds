import java.util.*;

public class F11_BSTClosestValue {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

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

    static int closestValue(TreeNode root, int target) {
        int closest = root.val;
        TreeNode node = root;

        while (node != null) {
            int curVal = node.val;
            if (curVal == target) {
                return curVal;
            }

            int curDiff = Math.abs(curVal - target);
            int closestDiff = Math.abs(closest - target);

            if (curDiff < closestDiff) {
                closest = curVal;
            } else if (curDiff == closestDiff && curVal < closest) {
                closest = curVal;
            }

            if (target < curVal) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        return closest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> vals = new ArrayList<>();
        while (sc.hasNextInt()) {
            vals.add(sc.nextInt());
        }
        int target = vals.remove(vals.size() - 1);

        TreeNode root = buildTree(vals);
        int ans = closestValue(root, target);
        System.out.println(ans);

        sc.close();
    }
}
