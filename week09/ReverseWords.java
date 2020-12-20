public class ReverseWords {
    /**
     * 题号名称：151. 翻转字符串里的单词
     * 题目链接：https://leetcode-cn.com/problems/reverse-words-in-a-string/
     * 算法思路：整个字符串翻转，然后再将每个单词翻转
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(N)
     */
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String str = reverseWord(s);
        String[] strArray = str.split("\\s+");
        for (int i = 0; i < strArray.length; i++) {
            if (strArray[i].length() == 0) {
                continue;
            }
            sb.append(reverseWord(strArray[i]));
            if (i != strArray.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public String reverseWord(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
