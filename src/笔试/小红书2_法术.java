package 笔试;

import java.util.Arrays;
import java.util.Scanner;

public class 小红书2_法术 {
    //排序+双指针
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        long k = in.nextLong();
        long arr[] = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        long ans = 0;

        Arrays.sort(arr);

//        int j = n - 1;
//        for (int i = 0; i < n; i++) {
//            while (j >= 0 && arr[i] * arr[j] >= k  ) {
//                j--;
//            }
//            if (i > j) {
//                ans--;
//            }
//            ans += n - 1 - j;
//        }
//        for(int j = n-1; j >= 1; j--) {
//            if(arr[])
//        }

        System.out.println(ans);

    }

}
