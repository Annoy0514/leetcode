package 高频题.多线程;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    private int i = 0;

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for(; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" +sum);
            sum += i;
        }
        return sum;
    }
}
