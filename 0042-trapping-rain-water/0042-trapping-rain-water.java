class Solution {
    public int trap(int[] a) {
        int n=a.length;
        if(n==0)return 0;
       int ans=0;
       int lm=0,rm=0;
       int l=0,r=n-1;
       while(l<r){
        lm=Math.max(a[l],lm);
        rm=Math.max(a[r],rm);
        if(lm>rm){
            ans+=(rm-a[r]);
            r--;
        }else{
            ans+=(lm-a[l]);
            l++;
        }
       }
         return ans;
    }
}