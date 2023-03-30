package 高频题.多线程;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) {
//        /**
//         * 1.继承Thread类
//         */
//        new CreateThread_1().start();
//
//        /**
//         * 2.实现Runnable接口
//         */
//        CreateThread_Runnable runnable = new CreateThread_Runnable();
//        Thread thread_2 = new Thread(runnable);
//        thread_2.start();

        /**
         * 3.实现Callable和Future接口
         */
        Callable<Integer> myCallable = new MyCallable();
        FutureTask<Integer> ft = new FutureTask<>(myCallable);

        for(int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" +i);
            if(i == 30) {
                Thread thread = new Thread(ft);
                thread.start();
            }
        }
        System.out.println("主线程for循环结束。。。");
        try {
            int sum = ft.get();
            System.out.println("sum = " + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
