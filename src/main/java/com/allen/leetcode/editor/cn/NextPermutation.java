// 题目编号： 31
//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 
// 👍 1068 👎 0


package com.allen.leetcode.editor.cn;


/**
 * 解题思路
 * 第一步： 在num[i]中找到i使得num[i] < num[i+1], 此时较小数为nums[i]，并且[i+1, n)一定为下降区间。
 * 第二步： 如果找到了这样的i, 则在下降区间[i+1, n)中从后往前找到第一个j，使得nums[i] < nums[j]，此时较大数为nums[j]
 * 第三步： 交换nums[i] 和 nums[j]，此时区间[i+1, n)一定为降序区间。
 * 最后原地交换[i+1, n)区间内的元素，使其变为升序，无需对该区间进行排序。
 * <p>
 * 如果第一步找不到合适的下标i, 说明当前序列已经是最大的排列。直接执行第三步生成最小序列。
 */
public class NextPermutation {
    public static void main(String[] args) {
        Solution solution = new NextPermutation().new Solution();
        int[] nums = {8, 9, 6, 10, 7, 2};
        solution.nextPermutation(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            int i = 0, j = 0;
            for (i = nums.length - 2; i >= 0; i--) {
                if (nums[i] < nums[i + 1]) {
                    break;
                }
            }

            if (i >= 0) {
                for (j = nums.length - 1; j > i; j--) {
                    if (nums[j] > nums[i]) {
                        break;
                    }
                }
                swap(nums, i, j);
            }

            reverse(nums, i + 1, nums.length - 1);
        }

        public void reverse(int[] arr, int i, int j) {
            while (i < j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        public void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}