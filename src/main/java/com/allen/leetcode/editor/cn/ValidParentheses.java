// 题目编号： 20
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2330 👎 0


package com.allen.leetcode.editor.cn;

import java.util.Stack;

/**
 * 20 有效的括号
 */
public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        String s = "()";
        boolean valid = solution.isValid(s);
        System.out.println(valid);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            if (s.length() == 0) {
                return true;
            }

            Stack stack = new Stack();
            for (int i = 0; i < s.length(); i++) {
                String currentStr = s.substring(i, i + 1);
                if (currentStr.equals("(") || currentStr.equals("[") || currentStr.equals("{")) {
                    stack.push(currentStr);
                } else if (currentStr.equals(")") && stack.size() > 0 && stack.peek().equals("(")
                        || currentStr.equals("]") && stack.size() > 0 && stack.peek().equals("[")
                        || currentStr.equals("}") && stack.size() > 0 && stack.peek().equals("{")) {

                    stack.pop();
                } else {
                    return false;
                }
            }
            return stack.size() == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}