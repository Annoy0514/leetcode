package 笔试.可参考学习;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Test1_邮箱格式处理 {
    public static void main(String[] args) {
        ArrayList<String> emails = new ArrayList<>();
        emails.add("123@qq.com");
        emails.add("123.@qq.com");
        emails.add("1234+a33@qq.com");
        emails.add("123qwe+adad@qq.com");
        emails.add("123.a@qq.com");
        List ans = getEmail(emails);
        for (Object an : ans) {
            System.out.println(an);
        }
    }

    public static List<String> getEmail(List<String> emails) {
        HashSet<String> set = new HashSet<>();
        for (String email : emails) {
            StringBuilder sb = new StringBuilder(email);
            int a_index  = sb.indexOf("@");
            for (int i = 0; i < email.length() && i < a_index; i++) {
                // 1.定位到'.',将'.'删除
                if(sb.charAt(i) == '.') {
                    sb.deleteCharAt(i);
                    i--;
                    a_index = sb.indexOf("@");
                }
                // 2.定位到'+'，删除'+'后到'@'之间的所有内容
                else if(sb.charAt(i) == '+') {
                    sb.delete(i,a_index);
                    i--;
                    a_index = sb.indexOf("@");
                }
            }
            set.add(sb.toString());
        }
        return new ArrayList<>(set);
    }

}
