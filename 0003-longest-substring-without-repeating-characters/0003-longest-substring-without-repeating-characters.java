class Solution {
    public int lengthOfLongestSubstring(String s) {
  int ans=0;
  int l=0;
  HashSet<Character> hs=new HashSet<>();
  for(int i=0;i<s.length();i++){
    char c=s.charAt(i);
    while(hs.contains(c)){
     hs.remove(s.charAt(l));
     l++;
    }
    hs.add(c);
    ans=Math.max(ans,i-l+1);
  }
    return ans;
    }
    
}