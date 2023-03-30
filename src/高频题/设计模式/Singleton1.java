package 高频题.设计模式;

import java.io.Serializable;

public class Singleton1  implements Serializable {
    // 实现一个私有的构造方法
    private Singleton1() {
        // 防止反射破坏单例模式
        if(INSTANCE != null) {
            throw new RuntimeException("已经创建过单例对象");
        }
        System.out.println("private singleton");
    }

    // 只要类实例化，就创建
    private static final Singleton1 INSTANCE = new Singleton1();

    public static Singleton1 getINSTANCE() {
        return INSTANCE;
    }

    public static void otherMethod() {
        System.out.println("otherMethod");
    }

}
