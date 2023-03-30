package 笔试;

import java.util.Scanner;

public class 实验数据 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] strChar = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            strChar[i] = str.charAt(i);
        }
        System.out.println(getMin(strChar));
    }

    public static int getMin(char[] strChar) {
        int ans = 0;
        int x = 0;
        if(strChar[0] == '?') {
            if(strChar[1] != '1'){
                strChar[0] = '1';
                if(strChar[1] == '?') {
                    strChar[1] = '0';
                }
            } else if(strChar[1] == '1') {
                strChar[0] = '2';
            }

        }
        for (int i = 1; i < strChar.length-1; i++) {
                if(strChar[i] == '?') {
                    strChar[i] = (char)(x+'0');
                    while (strChar[i] == strChar[i-1] || strChar[i] == strChar[i+1]) {
                        x++;
                        strChar[i] = (char)(x+'0');
                    }
                    x = 0;
                } else {
                    continue;
                }
        }
        if(strChar[strChar.length-1] == '?') {
            for(int i = 0; i < 10; i++) {
                strChar[strChar.length-1] = (char)(i+'0');
                if(strChar[strChar.length-1] != strChar[strChar.length-2]) {
                    String fromChar = new String(strChar);
                    ans = Integer.parseInt(fromChar);
                    if(ans % 3 == 0) break;
                    else continue;
                }
            }
        }
        return ans;
    }
}
