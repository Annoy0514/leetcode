package 笔试;

import java.util.ArrayList;
import java.util.Arrays;

public class 欧科云链_test1 {
    public String[] permutate (String s) {
        // write code here
        ArrayList<String> res = new ArrayList<>();
        String[] ans = new String[Integer.MAX_VALUE];
        if(s.length() == 0 || s == null) {
            return ans;
        }
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        boolean[] isVis = new boolean[s.length()];
        Arrays.fill(isVis,false);
        StringBuffer tmp = new StringBuffer();
        Permu(res,chars,tmp,isVis);
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    public static void Permu(ArrayList<String> res, char[] s, StringBuffer tmp,boolean[] vis) {
        if(tmp.length() == s.length) {
            res.add(new String(tmp));
            return;
        }
        for (int i = 0; i < s.length; i++) {
            if(vis[i]) {
                continue;
            }
            if(i>0 && s[i-1] == s[i] && !vis[i-1]) {
                continue;
            }
            vis[i] = true;
            tmp.append(s[i]);
            Permu(res, s, tmp, vis);
            vis[i] = false;
            tmp.deleteCharAt(tmp.length()-1);
        }
    }
}
