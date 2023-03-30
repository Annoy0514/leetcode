package 笔试;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Test1_合并区间 {
    public int[][] merge (int[][] arr) {
        // write code here
        if(arr.length==0 || arr == null) {
            return new int[0][2];
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                return arr1[0] - arr2[0];
            }
        });
        ArrayList<int[]> isMerged = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int left = arr[i][0];
            int right = arr[i][1];
            if(isMerged.size() == 0 || isMerged.get(isMerged.size() - 1)[1] < left) {
                isMerged.add(new int[]{left,right});
            } else {
                isMerged.get(isMerged.size() - 1)[1] = Math.max(isMerged.get(isMerged.size() - 1)[1],right);
            }
        }
        return isMerged.toArray(new int[isMerged.size()][]);
    }
}
