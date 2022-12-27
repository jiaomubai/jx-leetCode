package isSameTree;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jiaoxian
 * @name isSameTree
 * @date 2022/12/16 14:43
 * @description leetCode-100: 相同的树
 */
public class IsSameTree {

    /**
     * @description 递归-深度优先遍历
     * @author jiaoxian
     * @date 2022/12/16 14:45
     * @param p
     * @param q
     * @return boolean
     */
    // 如果两个树的根节点相同，则递归比较两个树的左子树和右子树是否也相同
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 如果两个树都为空，则两个树相同
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            // 如果有且只有一个树为空，则不相同
            return false;
        } else if (p.val != q.val) {
            // 如果两个树的根节点不相同，则两个树不相同
            return false;
        } else {
            // 递归比较两个树的左子树和右子树是否相同
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    /**
     * @description 广度优先遍历
     * @author jiaoxian
     * @date 2022/12/16 14:51
     * @param p
     * @param q
     * @return boolean
     *
     * 首先判断两个二叉树是否为空，如果两个二叉树都不为空，则从两个二叉树的根节点开始广度优先搜索。
     * 使用两个队列分别存储两个二叉树的节点。初始时将两个二叉树的根节点分别加入两个队列。每次从两个队列各取出一个节点，进行如下比较操作:
     * 1. 比较两个节点的值，如果两个节点的值不相同则两个二叉树一定不同；
     * 2. 如果两个节点的值相同，则判断两个节点的子节点是否为空，如果只有一个节点的左子节点为空，或者只有一个节点的右子节点为空，则两个二叉树的结构不同，因此两个二叉树一定不同；
     * 3. 如果两个节点的子节点的结构相同，则将两个节点的非空子节点分别加入两个队列，子节点加入队列时需要注意顺序，如果左右子节点都不为空，则先加入左子节点，后加入右子节点。
     * 如果搜索结束时两个队列同时为空，则两个二叉树相同。如果只有一个队列为空，则两个二叉树的结构不同，因此两个二叉树不同。
     *
     */
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            // 如果两个树都为空，则两个树相同
            return true;
        } else if (p == null || q == null) {
            // 如果两个树有且只有一个树为空，则两个树不相等
            return false;
        }
        // 将两个树的节点存储到队列中
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        queue1.offer(p);
        queue2.offer(q);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            // 获取到两个树的根节点
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if (node1.val != node2.val) {
                return false;
            }
            TreeNode left1 = node1.left;
            TreeNode right1 = node1.right;
            TreeNode left2 = node2.left;
            TreeNode right2 = node2.right;
            if (left1 == null ^ left2 == null) {
                return false;
            }
            if (right1 == null ^ right2 == null) {
                return false;
            }
            if (left1 != null) {
                queue1.offer(left1);
            }
            if (right1 != null) {
                queue1.offer(right1);
            }
            if (left2 != null) {
                queue2.offer(left2);
            }
            if (right2 != null) {
                queue2.offer(right2);
            }
        }
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public static void main(String[] args) {
        IsSameTree isSameTree = new IsSameTree();
        TreeNode p = TreeNode.createBinaryTree(new int[] {1, 2, 3, 4, 5});
        TreeNode q = TreeNode.createBinaryTree(new int[] {1, 2, 3, 4, 5, -1, 6});
        System.out.println(isSameTree.isSameTree2(p, q));
    }

}
