package 高频题.牛客100.字符串;

public class Test1_字符串变形_简单 {
    public static void main(String[] args) {
        String s = "This is a sample";
        int n = 16;
        System.out.println(trans(s,16));
    }
    public static String trans(String s, int n) {
        StringBuilder res = new StringBuilder();
        int index = 0; // 应当插入的位置
        for (int i = s.length()-1; i >= 0; i--) {
            if(s.charAt(i) == ' ') {
                res.append(" ");
                index = res.length();
            }
            if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                res.insert(index,(char)(s.charAt(i) - 'A' + 'a'));
            } else if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                res.insert(index,(char)(s.charAt(i) - 'a' + 'A'));
            }
        }
        return res.toString();
    }
}
