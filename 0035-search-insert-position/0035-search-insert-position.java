class Solution {
    public int searchInsert(int[] a, int target) {
        int l=0;
        int h=a.length-1;
           if(target>a[a.length-1])return a.length;
              if(target<a[0])return 0;
        int ans=Integer.MAX_VALUE;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(a[mid]==target){
               return mid;
            }else if(a[mid]>target){
                ans=mid;
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
     
        return ans;
    }
}