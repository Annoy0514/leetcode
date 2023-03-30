package 笔试;

import java.util.Scanner;

public class 携程_2_you得分 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++) {
            int y = scanner.nextInt();
            int o = scanner.nextInt();
            int u = scanner.nextInt();
            System.out.println(getScore(y,o,u));
        }
    }
    public static int getScore(int y, int o, int u) {
        int tmp = Math.min(y,o);
        int same = Math.min(tmp,u);
        o -= same;
        if(o <= 0) {
            return 2*same;
        } else {
            return 2*same+o-1;
        }
    }
}
