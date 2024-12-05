class Solution {
    public boolean canChange(String start, String target) {
        // `n` ko target string ki length set kar rahe hain.
        int n = target.length();
        int i = 0, j = 0; // Dono pointers `start` aur `target` string ke liye shuru mein set karte hain.
        
        // Loop tab tak chalega jab tak `i` aur `j` dono n se chhote ya barabar hain.
        while (i <= n && j <= n) {
            
            // `target` mein underscore (`_`) skip karte hain aur aage badhte hain.
            while (i < n && target.charAt(i) == '_') i++;
            
            // `start` mein underscore (`_`) skip karte hain aur aage badhte hain.
            while (j < n && start.charAt(j) == '_') j++;
            
            // Agar koi pointer end pe pahunch gaya ho, to dono pointers ka end pe hona zaroori hai.
            if (i == n || j == n) {
                return i == n && j == n;
            }
            
            // Agar `target` aur `start` ke current characters match nahi karte, to false return karte hain.
            if (target.charAt(i) != start.charAt(j)) return false;
            
            // Agar current character 'L' hai, to ensure karte hain ki woh aage na jaa sake (index `j` >= `i` hona chahiye).
            if (target.charAt(i) == 'L') {
                if (j < i) return false; // Agar 'L' left ki jagah right move kar raha ho, to false return karo.
            }
            // Agar current character 'R' hai, to ensure karte hain ki woh peeche na jaa sake (index `i` >= `j` hona chahiye).
            else {
                if (i < j) return false; // Agar 'R' right ki jagah left move kar raha ho, to false return karo.
            }
            
            // Dono pointers ko aage badhao.
            i++;
            j++;
        }
        return true; // Agar loop successfully complete ho gaya, to true return karte hain.
    }
}
