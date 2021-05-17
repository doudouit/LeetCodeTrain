// 题目编号： 993
//在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。 
//
// 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。 
//
// 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。 
//
// 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。 
//
// 
//
// 示例 1： 
// 
//
// 
//输入：root = [1,2,3,4], x = 4, y = 3
//输出：false
// 
//
// 示例 2： 
// 
//
// 
//输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
//输出：true
// 
//
// 示例 3： 
//
// 
//
// 
//输入：root = [1,2,3,null,4], x = 2, y = 3
//输出：false 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点数介于 2 到 100 之间。 
// 每个节点的值都是唯一的、范围为 1 到 100 的整数。 
// 
//
// 
// Related Topics 树 广度优先搜索 
// 👍 149 👎 0


package com.allen.leetcode.editor.cn;


import com.allen.leetcode.editor.util.TreeNode;

public class CousinsInBinaryTree {
    public static void main(String[] args) {
        Solution solution = new CousinsInBinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public boolean isCousins(TreeNode root, int x, int y) {
            if (root == null) {
                return false;
            }
            int levelX = findLevel(root, x, 1), levelY = findLevel(root, y, 1);
            if (levelX != levelY) {
                return false;
            }

            return !hasSameParent(root, x, y);
        }

        private int findLevel(TreeNode root, int x, int level) {
            if (root == null) {
                return 0;
            }
            if (root.val != x) {
                int leftLevel = findLevel(root.left, x, level + 1),
                        rightLevel = findLevel(root.right, x, level + 1);
                if (leftLevel == 0) {
                    return rightLevel;
                }
                return leftLevel;
            }
            return level;
        }

        private boolean hasSameParent(TreeNode root, int x, int y) {
            if (root == null) {
                return false;
            }
            if (root.left != null && root.right != null && root.left.val == x && root.right.val == y) {
                return true;
            }
            if (root.left != null && root.right != null && root.left.val == y && root.right.val == x) {
                return true;
            }
            return hasSameParent(root.left, x, y) || hasSameParent(root.right, x, y);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}