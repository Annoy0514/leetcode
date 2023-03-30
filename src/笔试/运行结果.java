package 笔试;

public class 运行结果 {
    public static void main(String[] args) {
        int[] num = {10};
        add(num);
        System.out.println(num[0]);
    }
    public static void add(int[] num) {
        num[0] +=5;
    }
}
