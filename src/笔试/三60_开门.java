package 笔试;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class 三60_开门 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        
        System.out.println(Arrays.toString(arr));
    }
}
