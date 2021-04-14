// 题目编号： 15
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 3230 👎 0


package com.allen.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> result = solution.threeSum(nums);
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();

            // 对nums进行排序
            Arrays.sort(nums);
            int sum = 0;
            for (int index = 1; index < nums.length-1; index++) {
                int start = 0;
                int end = nums.length -1;
                if (index > 1 && nums[index] == nums[index -1]) {
                    // 重置起始位置，防止漏掉两个相邻负数
                    start = index -1;
                }
                for (;start < index && end > index;) {
                    if (start > 0 && nums[start] == nums[start -1]) {
                        start++;
                        continue;
                    }
                    if (end < nums.length -1 && nums[end] == nums[end + 1]) {
                        end--;
                        continue;
                    }
                    sum = nums[index] + nums[start] + nums[end];
                    if (sum == 0) {
                        List<Integer> triple = new ArrayList<>();
                        triple.add(nums[index]);
                        triple.add(nums[start]);
                        triple.add(nums[end]);
                        result.add(triple);
                        start ++;
                        end--;
                    } else if (sum > 0) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}