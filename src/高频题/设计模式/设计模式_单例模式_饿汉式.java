package 高频题.设计模式;

import java.io.Serializable;

public class 设计模式_单例模式_饿汉式 implements Serializable {
    // 实现一个私有的构造方法
    private 设计模式_单例模式_饿汉式() {
        // 防止反射破坏单例模式
        if(INSTANCE != null) {
            throw new RuntimeException("已经创建过单例对象！");
        }
        System.out.println("private singleton");
    }

    // 只要类实例化，就创建
    private static final 设计模式_单例模式_饿汉式 INSTANCE = new 设计模式_单例模式_饿汉式();

    public static 设计模式_单例模式_饿汉式 getInstance() {
        return INSTANCE;
    }

    public static void otherMethod() {
        System.out.println("otherMethod()");
    }

}
