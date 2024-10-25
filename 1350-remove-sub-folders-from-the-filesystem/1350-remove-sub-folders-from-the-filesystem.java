import java.util.*;

class Solution {
    public static List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> ans = new ArrayList<>();
        ans.add(folder[0]);
        String prev = folder[0];
        
        for (int i = 1; i < folder.length; i++) {
            String s = folder[i];
            if (!s.startsWith(prev + "/")) {
                ans.add(s);
                prev = s;
            }
        }
        return ans;
    }
}
