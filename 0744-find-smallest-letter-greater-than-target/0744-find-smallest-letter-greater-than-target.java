class Solution {
    public char nextGreatestLetter(char[] ch, char k) {
        int n=ch.length;
        int l=0,h=n-1;
        int ans=0;
        if(k>=ch[n-1]||k<ch[0]){
            return ch[0];
        }
        while(l<=h){
            int mid=l+(h-l)/2;
            if(ch[mid]==k){
               return ch[mid+1];
            }else if(ch[mid]>k){
              ans=mid;
              h=mid-1;
            }else{
             l=mid+1;
            }
        }
        return ch[ans];
    }
}