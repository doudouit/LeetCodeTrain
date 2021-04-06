//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下： 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// 
//string convert(string s, int numRows); 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "PAYPALISHIRING", numRows = 3
//输出："PAHNAPLSIIGYIR"
// 
//示例 2：
//
// 
//输入：s = "PAYPALISHIRING", numRows = 4
//输出："PINALSIGYAHRPI"
//解释：
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
// 
//
// 示例 3： 
//
// 
//输入：s = "A", numRows = 1
//输出："A"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由英文字母（小写和大写）、',' 和 '.' 组成 
// 1 <= numRows <= 1000 
// 
// Related Topics 字符串 
// 👍 1088 👎 0


package com.allen.leetcode.editor.cn;

/**
 * 解题思路：
 *
 * 1.设有numRows行，令n = 2 * numRows - 2.
 *
 * 2.第一行的字符位置是 n * i（n * i < 字符串长度）xx
 *
 * 3.第二行字符位置是 n*i + 1 和 n*i+n-1
 *
 * 4.第三行字符位置是 n*i + 2 和 n*i+n-2
 *
 * 5.第x - 1（x > 1）行字符位置是n*i + x - 2 和 n*i+n-x + 2
 *
 * 6.第numRows行字符位置是n*i+numRows/2
 */
public class ZigzagConversion {
    public static void main(String[] args) {
        Solution solution = new ZigzagConversion().new Solution();
        String s = "PAYPALISHIRING";
        solution.convert(s, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convert(String s, int numRows) {
            if(numRows == 1) {
                return s;
            }
            StringBuilder ans = new StringBuilder();
            int n = numRows * 2 -2;
            // 第一行字符
            for(int m = 0; m * n < s.length(); m++){
                ans.append(s.charAt(m * n));
            }
            // (0, numRows-1)行
            for(int j = 1; j < numRows - 1; j++){
                for(int m = 0; ; m++){
                    // 竖着的
                    if(m * n + j < s.length()) {
                        ans.append(s.charAt(m * n + j));
                    } else {
                        break;
                    }
                    // 斜着的
                    if(m * n + n - j < s.length()) {
                        ans.append(s.charAt(m * n + n - j));
                    } else {
                        break;
                    }
                }
            }
            // 第numRows-1行
            for(int m = 0; m * n + n / 2 < s.length(); m++){
                ans.append(s.charAt(m * n + n / 2));
            }
            return ans.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}