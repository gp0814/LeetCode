class Solution {
    public int countPalindromicSubsequence(String s) {
    int first[] = new int[26];
    int last[] = new int[26];
    Arrays.fill(first, -1);
    int ans = 0; 
    

    for(int i = 0; i<s.length(); i++)
    {
      int x = s.charAt(i) - 'a';
      if(first[x]==-1)
      first[x] = i;
      last[x] = i; 
    }  

    for(int i=0; i<26; i++)
    {
      if(first[i]==-1)
      continue;
      HashSet<Character> hs = new HashSet();
      for(int j = first[i]+1; j<last[i]; j++)
      hs.add(s.charAt(j));
      ans += hs.size();
    }

      return ans;  
    }
}