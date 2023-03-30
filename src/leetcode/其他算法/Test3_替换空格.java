package leetcode.其他算法;


/**
 * 请实现一个函数，将一个字符串s中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */

public class Test3_替换空格 {
    public String replaceSpace (String s) {
        StringBuilder newStr = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(' ' == chars[i]) {
                newStr.append("%20");
            } else {
                newStr.append(chars[i]);
            }
        }
        return newStr.toString();
    }
}
