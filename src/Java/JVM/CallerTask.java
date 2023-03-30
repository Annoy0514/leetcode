package Java.JVM;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallerTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "Hello,i am running";
    }

    public static void main(String[] args) {
        // 创建异步线程
        FutureTask<String> task = new FutureTask<>(new CallerTask());
        // 启动线程
        new Thread(task).start();
        try {
            // 等待执行完成，并获取返回结果
            String result = task.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
