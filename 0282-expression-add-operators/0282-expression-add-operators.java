import java.util.*;
class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        dfs(ans, "", num, target, 0, 0, 0);
        return ans;
    }
    private void dfs(List<String> ans,
                     String path,
                     String num,
                     int target,
                     int index,
                     long value,
                     long prev) {
        if (index == num.length()) {
            if (value == target)
                ans.add(path);
            return;
        }
        for (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(index) == '0')
                break;
            String curStr = num.substring(index, i + 1);
            long cur = Long.parseLong(curStr);
            if (index == 0) {
                dfs(ans, curStr, num, target,
                        i + 1, cur, cur);
            } else {              
                dfs(ans,
                        path + "+" + curStr,
                        num,
                        target,
                        i + 1,
                        value + cur,
                        cur);              
                dfs(ans,
                        path + "-" + curStr,
                        num,
                        target,
                        i + 1,
                        value - cur,
                        -cur);
                dfs(ans,
                        path + "*" + curStr,
                        num,
                        target,
                        i + 1,
                        value - prev + prev * cur,
                        prev * cur);
            }
        }
    }
}