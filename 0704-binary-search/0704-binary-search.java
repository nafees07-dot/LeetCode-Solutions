class Solution {
    public int search(int[] a, int target) {
        int l=0,h=a.length-1;
        while(l<=h){
            int m=l+(h-l)/2;
            if(a[m]==target)return m;
            else if(a[m]<target)
                 l=m+1;
                 else
                 h=m-1;
        }
        return -1;
    }
}