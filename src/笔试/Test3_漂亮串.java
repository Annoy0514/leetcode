package 笔试;

public class Test3_漂亮串 {
    private static int res;

    public static void main(String[] args) {
        res = getRedNums(8) % ((int)Math.pow(10,9) + 7);
        System.out.println(res);
    }
    public static int getRed(int n) {
        if(n <= 6) return 1;
        else {
            return 26 * getRed(n-1);
        }
    }
    private static int getRedNums(int n) {
        if(n < 6) return 0;
        else {
            return getRed(n);
        }
    }
}
