class Solution {
    public boolean canBeValid(String s, String locked) {
        int len = s.length();
        
        
        if (len % 2 == 1) return false;

        
        Stack<Integer> lo = new Stack<>();
        Stack<Integer> u = new Stack<>();

        for (int i = 0; i < len; i++) {
            if (locked.charAt(i) == '0') {
                u.push(i); 
            } else if (s.charAt(i) == '(') {
                lo.push(i); 
            } else { 
                if (!lo.isEmpty()) {
                    lo.pop(); 
                } else if (!u.isEmpty()) {
                    u.pop(); 
                } else {
                    return false;
                }
            }
        }
        while (!lo.empty() && !u.empty() && lo.peek() < u.peek()) {
            lo.pop();
            u.pop();
        }

        if (!lo.empty() || u.size()%2==1) {
            return false;
        }

        return true;
    }
}