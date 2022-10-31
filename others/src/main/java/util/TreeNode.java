package util;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: TreeNode
 * @Description: ���������ɹ���
 * @Author: jiaoxian
 * @Date: 2022/10/17 16:58
 **/
public class TreeNode {

    /**
     * ������
     */
    public int val;

    /**
     * ������
     */
    public TreeNode left;

    /**
     * ������
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
        // ������ԭ������ͬ�����ڵ��б�
        List<TreeNode> treeNodeList = arr.length > 0 ? new ArrayList<>(arr.length) : null;
        TreeNode root = null;
        // ��������ֵ����, ��ת��Ϊ�������ڵ��б�
        for (int i = 0; i < arr.length; i++) {
            TreeNode node = null;
            if (arr[i] != -1) {
                // �� -1 ��ʾnull
                node = new TreeNode(arr[i]);
            }
            treeNodeList.add(node);
            if (i == 0) {
                root = node;
            }
        }
        // ����һ��, ���ݹ������Һ��Ӹ�ֵ����, ע���������������
        // i * 2 + 2 < arr.length �����ָ��
        // ������ڵ�������±��� i, ��ô���������±��� i * 2 + 1, �Һ����±���� i * 2 + 2
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
     * @Description binaryTreeTraversal ����������
     * @Date 2022/10/17 17:31
     **/
    public static void binaryTreeTraversal(TreeNode root) {
        System.out.println("ǰ��(�� -> �� -> ��)�������Ϊ:");
        List<Integer> firstResult = new ArrayList<>();
        traversalFirst(root, firstResult);
        display(firstResult);

        System.out.println("����(�� -> �� -> ��)�������Ϊ:");
        List<Integer> middleResult = new ArrayList<>();
        traversalMiddle(root, middleResult);
        display(middleResult);

        System.out.println("����(�� -> �� -> ��)�������Ϊ:");
        List<Integer> secondResult = new ArrayList<>();
        traversalSecond(root, secondResult);
        display(secondResult);
    }

    /**
     * @param root:
     * @param result:
     * @return void
     * @Author jiaoxian
     * @Description traversalFirst ������ǰ�����
     * @Date 2022/10/17 17:36
     **/
    public static void traversalFirst(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        // ��
        result.add(root.val);
        // ��
        traversalFirst(root.left, result);
        // ��
        traversalFirst(root.right, result);
    }

    /**
     * @param root:
     * @param result:
     * @return void
     * @Author jiaoxian
     * @Description traversalMiddle �������������
     * @Date 2022/10/17 17:37
     **/
    public static void traversalMiddle(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        // ��
        traversalMiddle(root.left, result);
        // ��
        result.add(root.val);
        // ��
        traversalMiddle(root.right, result);
    }

    /**
     * @param root:
     * @param result:
     * @return void
     * @Author jiaoxian
     * @Description traversalSecond �������������
     * @Date 2022/10/17 17:37
     **/
    public static void traversalSecond(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        // ��
        traversalSecond(root.left, result);
        // ��
        traversalSecond(root.right, result);
        // ��
        result.add(root.val);
    }

    /**
     * @param list:
     * @return void
     * @Author jiaoxian
     * @Description display ���� ArrayList
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
     * @Description traversalMiddle �������������������
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
