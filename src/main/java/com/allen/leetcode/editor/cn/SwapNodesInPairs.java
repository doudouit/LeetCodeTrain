//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。） 
// Related Topics 递归 链表 
// 👍 882 👎 0


package com.allen.leetcode.editor.cn;

/**
 * 24 两两交换链表中的节点
 */
public class SwapNodesInPairs{
    public static void main(String[] args) {
         Solution solution = new SwapNodesInPairs().new Solution();

         ListNode l1 = new ListNode(1);
         ListNode l2 = new ListNode(2);
         ListNode l3 = new ListNode(3);
         ListNode l4 = new ListNode(4);
         ListNode l5 = new ListNode(5);
         ListNode l6 = new ListNode(6);
         ListNode l7 = new ListNode(7);
         ListNode l8 = new ListNode(8);
         ListNode l9 = new ListNode(9);
         ListNode l10= new ListNode(10);

         l1.next = l2;
         l2.next = l3;
         l3.next = l4;
         l4.next = l5;
         l5.next = l6;
         l6.next = l7;
         l7.next = l8;
         l8.next = l9;
         l9.next = l10;

        ListNode listNode = solution.swapPairs(l1);
        System.out.println(listNode.val);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode s = head.next;
        ListNode behind = null;
        while (head.next != null) {
            ListNode headNext = head.next;
            if (behind != null && headNext != null) {
                // 这行变  s变量对应的指针就跟着变
                behind.next = headNext;
            }

            ListNode next = null;
            if (head.next.next != null) {
                next = head.next.next;
            }

            if (head.next.next != null) {
                head.next = next;
            } else {
                head.next = null;
            }

            // 交换头结点与头结点的下一个节点 这行变  s变量对应的指针就跟着变
            headNext.next = head;
            behind = head;
            if (head.next != null) {
                head = next;
            }
        }
        return s;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
}