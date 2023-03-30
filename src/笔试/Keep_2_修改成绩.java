package 笔试;

public class Keep_2_修改成绩 {
    public static void main(String[] args) {
        System.out.println(max_score(43215));
    }
    public static int max_score(int score) {
        String tmp = String.valueOf(score);
        int max = score;
        int len = tmp.length();
        int[] res = new int[len];
        for (int m = 0; m < len; m++) {
            res[m] = tmp.charAt(m)-'0';
        }
        for (int i = 0; i < len-1; i++) {
            for(int j = i+1; j < len; j++) {
                max = Math.max(max,swap(res,i,j));
                System.out.println(max);
            }
        }
        return max;
    }
    public static int swap(int[] tmp, int n, int m) {
        int c = 0;
        c = tmp[n];
        tmp[n] = tmp[m];
        tmp[m] = c;
        String res = "";
        for (int i = 0; i < tmp.length; i++) {
            res += tmp[i];
        }
        System.out.println(Integer.parseInt(res));
        System.out.println("------");
        return Integer.parseInt(res);
    }
}
