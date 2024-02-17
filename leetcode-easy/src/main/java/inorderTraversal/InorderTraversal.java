//package inorderTraversal;
//
//import util.TreeNode;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @ClassName: InorderTraversal
// * @Description: leetCode-94: 二叉树的中序遍历
// * @Author: jiaoxian
// * @Date: 2022/10/17 17:51
// **/
//public class InorderTraversal {
//
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        traversalMiddle(root, result);
//        return result;
//    }
//
//    public void traversalMiddle(TreeNode root, List<Integer> res) {
//        if (root == null) {
//            return;
//        }
//        // 左
//        traversalMiddle(root.left, res);
//        // 根
//        res.add(root.val);
//        // 右
//        traversalMiddle(root.right, res);
//    }
//
//    public static void main(String[] args) {
//        // 调用自定义的工具类使用数组完成二叉树的初始化
//        int[] nums = {1,2,3,4,5,6,7,8,9,10,-1};
//        TreeNode root = TreeNode.createBinaryTree(nums);
//        InorderTraversal inorderTraversal = new InorderTraversal();
//        List<Integer> result = inorderTraversal.inorderTraversal(root);
//        TreeNode.display(result);
//    }
//
//}
