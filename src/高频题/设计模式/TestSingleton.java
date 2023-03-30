package 高频题.设计模式;

public class TestSingleton {
    public static void main(String[] args) throws Exception{
        Singleton1.otherMethod();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(Singleton1.getINSTANCE());
        System.out.println(Singleton1.getINSTANCE());
    }
}
