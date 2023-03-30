package leetcode.模拟;

import java.util.Arrays;

public class Test1_扑克牌顺子 {
    public boolean IsContinuous(int [] numbers) {
        int index = 0;
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 1; i++) {
            if(numbers[i] == 0) { // 1.统计大小王数量
                index++;
            } else if(numbers[i] == numbers[i+1]) { // 2.如果相邻两张牌相等，返回false
                return false;
            }
        }
        return numbers[4] - numbers[index] < 5; // 最大牌-最小牌<5，即可构成顺子
    }
}
