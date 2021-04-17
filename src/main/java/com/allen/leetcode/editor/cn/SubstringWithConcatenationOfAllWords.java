// 题目编号： 30
//给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。 
//
// 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。 
//
// 
//
// 示例 1： 
//
// 输入：
//  s = "barfoothefoobarman",
//  words = ["foo","bar"]
//输出：[0,9]
//解释：
//从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
//输出的顺序不重要, [9,0] 也是有效答案。
// 
//
// 示例 2： 
//
// 输入：
//  s = "wordgoodgoodgoodbestword",
//  words = ["word","good","best","word"]
//输出：[]
// 
// Related Topics 哈希表 双指针 字符串 
// 👍 451 👎 0


package com.allen.leetcode.editor.cn;

import java.util.*;

public class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        Solution solution = new SubstringWithConcatenationOfAllWords().new Solution();
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        List<Integer> result = solution.findSubstring(s, words);
        System.out.println(result.toString());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            if (s.length() == 0) {
                return new ArrayList<>();
            }
            // 返回值
            List<Integer> res = new ArrayList<>();
            // 1. 字符串数组中所有的字符存到map中，并累计出现的次数
            Map<String, Integer> counter = new HashMap<>();
            for (String word : words) {
                if (counter.containsKey(word)) {
                    Integer num = counter.get(word);
                    counter.put(word, ++num);
                    continue;
                }
                counter.put(word, 1);
            }
            int length = words[0].length();
            int totalLen = words[0].length() * words.length;
            Map<String, Integer> tempCounter = copyMap(counter);
            // 2. 从源字符串的头开始找，每次判断words中的字符串是否用完（map中的计数为0）
            //  如果全部用完，并且长度等于words中任意排列的总长度，就记录这个索引下标
            for (int i = 0, start = 0; i < s.length() - length + 1 && start < s.length() - length + 1; i++) {
                String word = s.substring(i, i + length);
                if (tempCounter.containsKey(word) && tempCounter.get(word) > 0) {
                    Integer count = tempCounter.get(word);
                    tempCounter.put(word, --count);
                    if (checkWords(tempCounter) && (i + length - start == totalLen)) {
                        res.add(start);
                        continue;
                    }
                    i = i + length - 1;
                } else {
                    start++;
                    i = start - 1;
                    tempCounter = copyMap(counter);
                }
            }

            return res;
        }

        private boolean checkWords(Map<String, Integer> map) {
            boolean flag = true;
            Collection<Integer> values = map.values();
            for (Integer value : values) {
                if (value > 0) {
                    flag = false;
                    break;
                }
            }
            return flag;
        }

        private Map<String, Integer> copyMap(Map<String, Integer> s) {
            Map<String, Integer> c = new HashMap<>();
            Set<Map.Entry<String, Integer>> entries = s.entrySet();
            for (Map.Entry<String, Integer> entry : entries) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                c.put(key, value);
            }
            return c;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}