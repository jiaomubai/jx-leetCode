package util;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: TreeNode
 * @Description: 二叉树生成工具
 * @Author: jiaoxian
 * @Date: 2022/10/17 16:58
 **/
public class TreeNode {

    /**
     * 数据域
     */
    public int val;

    /**
     * 左子树
     */
    public TreeNode left;

    /**
     * 右子树
     */
    public TreeNode right;

    public TreeNode(int x) {
        this.val = x;
        this.left = null;
        this.right = null;
    }

    public TreeNode() {

    }

    public static TreeNode createBinaryTree(int[] arr) {
        // 构建和原数组相同的树节点列表
        List<TreeNode> treeNodeList = arr.length > 0 ? new ArrayList<>(arr.length) : null;
        TreeNode root = null;
        // 把输入数值数组, 先转化为二叉树节点列表
        for (int i = 0; i < arr.length; i++) {
            TreeNode node = null;
            if (arr[i] != -1) {
                // 用 -1 表示null
                node = new TreeNode(arr[i]);
            }
            treeNodeList.add(node);
            if (i == 0) {
                root = node;
            }
        }
        // 遍历一遍, 根据规则左右孩子赋值即可, 注意这里结束规则是
        // i * 2 + 2 < arr.length 避免空指针
        // 如果父节点的数组下标是 i, 那么它的左孩子下标是 i * 2 + 1, 右孩子下标就是 i * 2 + 2
        for (int i = 0; i * 2 + 2 < arr.length; i++) {
            TreeNode node = treeNodeList.get(i);
            if (node != null) {
                node.left = treeNodeList.get(2 * i + 1);
                node.right = treeNodeList.get(2 * i + 2);
            }
        }
        return root;
    }

    /**
     * @param root:
     * @return
     * @Author jiaoxian
     * @Description binaryTreeTraversal 二叉树遍历
     * @Date 2022/10/17 17:31
     **/
    public static void binaryTreeTraversal(TreeNode root) {
        System.out.println("前序(根 -> 左 -> 右)遍历结果为:");
        List<Integer> firstResult = new ArrayList<>();
        traversalFirst(root, firstResult);
        display(firstResult);

        System.out.println("中序(左 -> 根 -> 右)遍历结果为:");
        List<Integer> middleResult = new ArrayList<>();
        traversalMiddle(root, middleResult);
        display(middleResult);

        System.out.println("后序(左 -> 右 -> 根)遍历结果为:");
        List<Integer> secondResult = new ArrayList<>();
        traversalSecond(root, secondResult);
        display(secondResult);
    }

    /**
     * @param root:
     * @param result:
     * @return void
     * @Author jiaoxian
     * @Description traversalFirst 二叉树前序遍历
     * @Date 2022/10/17 17:36
     **/
    public static void traversalFirst(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        // 根
        result.add(root.val);
        // 左
        traversalFirst(root.left, result);
        // 右
        traversalFirst(root.right, result);
    }

    /**
     * @param root:
     * @param result:
     * @return void
     * @Author jiaoxian
     * @Description traversalMiddle 二叉树中序遍历
     * @Date 2022/10/17 17:37
     **/
    public static void traversalMiddle(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        // 左
        traversalMiddle(root.left, result);
        // 根
        result.add(root.val);
        // 右
        traversalMiddle(root.right, result);
    }

    /**
     * @param root:
     * @param result:
     * @return void
     * @Author jiaoxian
     * @Description traversalSecond 二叉树后序遍历
     * @Date 2022/10/17 17:37
     **/
    public static void traversalSecond(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        // 左
        traversalSecond(root.left, result);
        // 右
        traversalSecond(root.right, result);
        // 根
        result.add(root.val);
    }

    /**
     * @param list:
     * @return void
     * @Author jiaoxian
     * @Description display 遍历 ArrayList
     * @Date 2022/10/17 17:47
     **/
    public static void display(List<Integer> list) {
        if (list.size() == 0) {
            return;
        }
        for (int i = 0; i < list.size() - 1; i++) {
            System.out.print(list.get(i) + " -> ");
        }
        System.out.println(list.get(list.size() - 1));
    }

    /**
     * @Author jiaoxian
     * @Description traversalMiddle 迭代法中序遍历二叉树
     * @Date 2022/10/18 9:17
     * @param root:
     * @return java.util.List<java.lang.Integer>
     **/
    public static List<Integer> traversalMiddle(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, -1};
        TreeNode root = TreeNode.createBinaryTree(data);
        TreeNode.binaryTreeTraversal(root);
//        List<Integer> result = TreeNode.traversalMiddle(root);
//        TreeNode.display(result);
    }

}
