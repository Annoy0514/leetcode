package leetcode.Graph;

import java.util.HashSet;
import java.util.Set;

public class Test5_最长连续序列 {

    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        /**
         * 如果已知有一个 x,x+1,x+2,⋯,x+y 的连续序列，而我们却重新从 x+1，x+2 或者是 x+y 处开始尝试匹配，
         * 那么得到的结果肯定不会优于枚举 x 为起点的答案，因此我们在外层循环的时候碰到这种情况跳过即可。
         *
         */
        for (int num : num_set) {
            /**
             * 要枚举的数 x 一定在数组中不存在前驱数 x-1,否则会从 x-1 开始尝试匹配。
             * 因此在哈希表中检查是否存在 x-1 即能判断是否需要跳过。
             */
            if(!num_set.contains(num-1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak,currentStreak);
            }
        }
        return longestStreak;
    }
}
