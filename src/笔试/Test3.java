package 笔试;

import java.util.ArrayList;
import java.util.HashMap;

public class Test3 {
    public ArrayList<Integer> findConsecutiveSubArr2 (ArrayList<Integer> binaries) {
        // write code here
        int[] nums = new int[binaries.size()];
        for (int i = 0; i < binaries.size(); i++) {
            nums[i] = binaries.get(i);
        }
        int maxLength = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        map.put(count,0);
        int n = binaries.size();
        int[] res = null;
        int pre = 0;
        for (int i = 0; i < n; i++) {
            int num = binaries.get(i);
            if(num == 1) {
                count++;
            } else {
                count--;
            }
            if(map.containsKey(count)) {
                int preIndex = map.get(count);
                if(maxLength < i - preIndex) {
                    res = new int[i-preIndex];
                    System.arraycopy(nums,preIndex,res,0,i-preIndex);
                    maxLength = i - preIndex;
                }
                else if(maxLength == i-preIndex && count==0) {
                    int[] temp = new int[i-preIndex];
                    System.arraycopy(nums,preIndex,temp,0,i-preIndex);
                    int cur = getT(temp);
                    if(cur > pre) {
                        pre = cur;
                        maxLength = i-preIndex;
                        res = temp;
                    }
                }
            } else {
                map.put(count,1);
            }
        }
        ArrayList<Integer> ans = null;
        for (int i = 0; i < res.length; i++) {
            ans.add(res[i]);
        }
        return ans;
    }
    public static int getT(int[] arr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : arr) {
            stringBuilder.append(i);
        }
        return Integer.parseInt(stringBuilder.toString(),2);
    }
}
