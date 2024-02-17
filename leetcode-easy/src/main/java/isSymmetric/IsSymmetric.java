//package isSymmetric;
//
//import util.TreeNode;
//
//import java.util.LinkedList;
//import java.util.Queue;
//
///**
// * @author jiaoxian
// * @name isSymmetric
// * @date 2022/12/26 15:02
// * @description leetCode-101: 对称二叉树
// */
//public class IsSymmetric {
//
//    // 递归
//    // 如果一个树的左子树与右子树镜像对称，那么这个树是对称的。
//    // 因此, 该问题可以转化为: 两个树在什么情况下互为镜像？
//    // 如果同时满足下面的条件, 两个树互为镜像：
//    //      它们的两个根结点具有相同的值
//    //      每个树的右子树都与另一个树的左子树镜像对称
//    // 我们可以实现这样一个递归函数, 通过同步移动两个指针的方法来遍历这棵树,
//    // p 指针和 q 指针一开始都指向这棵树的根, 随后 p 右移时, q 左移, p 左移时, q 右移。
//    // 每次检查当前 p 和 q 节点的值是否相等, 如果相等再判断左右子树是否对称。
//
//    public boolean isSymmetric(TreeNode root) {
//        return check(root, root);
//    }
//
//    public boolean check(TreeNode p, TreeNode q) {
//        if (p == null && q == null) {
//            return true;
//        }
//        if (p == null || q == null) {
//            return false;
//        }
//        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
//    }
//
//    // 迭代
//    // 首先我们引入一个队列, 这是把递归程序改写成迭代程序的常用方法。
//    // 初始化时我们把根节点入队两次。
//    // 每次提取两个结点并比较它们的值（队列中每两个连续的结点应该是相等的, 而且它们的子树互为镜像）,
//    // 然后将两个结点的左右子结点按相反的顺序插入队列中。
//    // 当队列为空时, 或者我们检测到树不对称（即从队列中取出两个不相等的连续结点）时, 该算法结束。
//
//    public boolean isSymmetric2(TreeNode root) {
//        return check(root, root);
//    }
//
//    public boolean check2(TreeNode u, TreeNode v) {
//        Queue<TreeNode> q = new LinkedList<TreeNode>();
//        q.offer(u);
//        q.offer(v);
//        while (!q.isEmpty()) {
//            u = q.poll();
//            v = q.poll();
//            if (u == null && v == null) {
//                continue;
//            }
//            if ((u == null || v == null) || (u.val != v.val)) {
//                return false;
//            }
//
//            q.offer(u.left);
//            q.offer(v.right);
//
//            q.offer(u.right);
//            q.offer(v.left);
//        }
//        return true;
//    }
//
//}
