package 笔试;

import java.util.*;

class Shop{
    int idx;
    int key;
    int value;
    Shop(int i,int k, int v) {
        idx = i;
        key = k;
        value = v;
    }
}

public class 联想_test1 {
    public static void main(String[] args) {
        Map<Integer, Integer> store = new HashMap<>();
        Map<Integer, Shop> shopping = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            store.put(i+1,nums[i]);
        }
        for (int j = 0; j < m; j++) {
            int key = sc.nextInt();
            int value = sc.nextInt();
            shopping.put(j,new Shop(j,key,value));
        }

        shopping.forEach((key,value) -> {
            if(store.containsKey(shopping.get(key).key)) {
                if(store.get(shopping.get(key).key) >= shopping.get(key).value) {
                    updateStore(store,shopping.get(key).key,shopping.get(key).value);
                    System.out.println("item #" + shopping.get(key).key +": Success!");
                } else {
                    System.out.println("item #" + shopping.get(key).key +": Sorry!");
                }
            } else {
                System.out.println("item #" + shopping.get(key).key +": Sorry!");
            }
        });
    }

    public static void updateStore(Map<Integer,Integer> store, int key, int value) {
        int new_value = store.get(key) - value;
        store.put(key,new_value);
    }
}
