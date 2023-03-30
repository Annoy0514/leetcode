package 笔试;

public class 粘贴复制 {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "helloo";
        canCopy(str1,str2);
    }
    private static String canCopy(String str1, String str2) {
        char[] str_1 = str1.toCharArray();
        char[] str_2 = str2.toCharArray();
        for (int i = 0; i < str_2.length; i++) {
            if(str_1[i] == str_2[i]) continue;
//            else
        }
        System.out.println(str_1[1]);
        return null;
    }
}
