// 题目编号： 14
//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 0 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1560 👎 0


package com.allen.leetcode.editor.cn;

/**
 * 14 最长公共前缀
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
        String[] strs = {"ab","a"};
        String s = solution.longestCommonPrefix(strs);
        System.out.println(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }

            String reg = strs[0];
            for (String str : strs) {
                while (!str.startsWith(reg)) {
                    if (reg.length() == 1) {
                        return "";
                    }
                    reg = reg.substring(0, reg.length() -1);
                }
            }
            return reg;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}