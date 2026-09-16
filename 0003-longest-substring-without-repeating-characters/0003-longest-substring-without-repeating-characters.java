class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans=0;
        //if(s.isEmpty())return 0;
        if(s.length()==1)return 1;
        int l=0,h=s.length();
       while(l<=h){
        int mid=(l+h)/2;
        if(solve(mid,s)){
            ans=mid;
            l=mid+1;
        }else{
            h=mid-1;
        }
       }
    return ans;
    }
    public boolean solve(int m,String s){
        int n=s.length();
        HashMap<Character,Integer> hs=new HashMap<>();
        for(int i=0;i<m;i++){
          char ch=s.charAt(i);
           hs.put(ch,hs.getOrDefault(ch,0)+1);
        }
        if(hs.size()==m)return true;
        for(int i=m;i<n;i++){
            if(hs.get(s.charAt(i-m))==1)
            hs.remove(s.charAt(i-m));
            else
            hs.put(s.charAt(i-m),hs.get(s.charAt(i-m))-1);
            hs.put(s.charAt(i),hs.getOrDefault(s.charAt(i),0)+1);
            if(hs.size()==m)return true;
        }
        return false;
    }
}