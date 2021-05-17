// 题目编号： 870
//给定两个大小相等的数组 A 和 B，A 相对于 B 的优势可以用满足 A[i] > B[i] 的索引 i 的数目来描述。 
//
// 返回 A 的任意排列，使其相对于 B 的优势最大化。 
//
// 
//
// 示例 1： 
//
// 输入：A = [2,7,11,15], B = [1,10,4,11]
//输出：[2,11,7,15]
// 
//
// 示例 2： 
//
// 输入：A = [12,24,8,32], B = [13,25,32,11]
//输出：[24,32,8,12]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length = B.length <= 10000 
// 0 <= A[i] <= 10^9 
// 0 <= B[i] <= 10^9 
// 
// Related Topics 贪心算法 数组 
// 👍 127 👎 0


package com.allen.leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 田忌赛马问题加强版
 * num1 田忌的马 num2 齐王的马
 * 使用双指针解决此问题 时间复杂度O(nlogn)
 */
public class AdvantageShuffle {
    public static void main(String[] args) {
        Solution solution = new AdvantageShuffle().new Solution();
        int[] num1 = {2,7,11,15};
        int[] num2 = {1,10,4,11};
        int[] res = solution.advantageCount(num1, num2);
        for (int re : res) {
            System.out.println(re);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] advantageCount(int[] nums1, int[] nums2) {
            int n = nums1.length;
            // 给num2 降序排列
            PriorityQueue<int[]> maxpq = new PriorityQueue<>(
                    (int[] pair1, int[] pair2) -> {
                        return pair2[1] - pair1[1];
                    }
            );

            for (int i = 0; i < n; i++) {
                maxpq.offer(new int[]{i, nums2[i]});
            }
            // 给num1升序
            Arrays.sort(nums1);

            // nums1[left]最小值，num1[right]最大值
            int left = 0, right = n - 1;
            int[] res = new int[n];

            while (!maxpq.isEmpty()) {
                int[] pair = maxpq.poll();
                // maxval是num2中的最大值，i是对应索引
                int i = pair[0], maxval = pair[1];
                if (maxval < nums1[right]) {
                    // 如果num1[right] 能胜过maxval，那就自己上
                    res[i] = nums1[right];
                    right--;
                } else {
                    // 否则就用最小的值混一下，养精蓄锐
                    res[i] = nums1[left];
                    left++;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}