package 高频题.排序算法;

public class B {
    public static B t1 = new B();
    public static B t2 = new B();
    {
        System.out.println("构造快");
    }
    static
    {
        System.out.println("静态快");
    }

    public static void main(String[] args) {
        B t = new B();
    }
}
