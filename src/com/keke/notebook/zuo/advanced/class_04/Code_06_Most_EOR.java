package com.keke.notebook.zuo.advanced.class_04;

import java.util.HashMap;

/**
 * Created by KEKE on 2019/5/30
 */
public class Code_06_Most_EOR {

    public static int mostEOR(int[] arr) {
        int ans = 0;
        int xor = 0;
        int[] mosts = new int[arr.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
            if (map.containsKey(xor)) {
                int pre = map.get(xor);
                mosts[i] = pre == -1 ? 1 : (mosts[pre] + 1);
            }
            if (i > 0) {
                mosts[i] = Math.max(mosts[i - 1], mosts[i]);
            }
            map.put(xor, i);
            ans = Math.max(ans, mosts[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {3,0,2,2};
        System.out.println(mostEOR(arr));
    }
}
