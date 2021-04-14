// 题目编号： 16
//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针 
// 👍 751 👎 0


package com.allen.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 16 最接近的三数之和
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new ThreeSumClosest().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int res = nums[0] + nums[1] + nums[2];
            for (int i = 0; i < nums.length - 2; i++) {
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[left] + nums[right] + nums[i];
                    if (sum == target) {
                        return sum;
                    }
                    if (Math.abs(sum - target) < Math.abs(res - target)) {
                        res = sum;
                    }

                    if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}