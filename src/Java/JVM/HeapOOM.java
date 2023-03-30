package Java.JVM;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {
    // 定义一个静态对象(不可回收)
    static class OOMObject{}

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            // 不断创建静态对象，随着对象数量的增加，总容量触及最大堆的容量限制后就会产生内存溢出异常(OOM)
            list.add(new OOMObject());
        }
    }
}
