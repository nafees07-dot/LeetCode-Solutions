class Solution {
    public int[] searchRange(int[] a, int target) {
        int l=0,h=a.length-1;
        int n=a.length;
        int ans=0;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(a[mid]==target){
                return solve(a,mid,target);
            }else if(a[mid]<target){
                l=mid+1;
            }else{
                h=mid-1;
            }
        }
        return new int[]{-1,-1};
    }
    public int[] solve(int[] a,int m,int target){
        int l=0,h=m-1;
        int min=m,max=m;
        int n=a.length;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(a[mid]==target){
                min=mid;
               h=mid-1;
            }else if(a[mid]<target){
                l=mid+1;
            }else{
                h=mid-1;
            }
        }
        l=m+1;
        h=a.length-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(a[mid]==target){
                max=mid;
               l=mid+1;
            }else if(a[mid]<target){
                l=mid+1;
            }else{
                h=mid-1;
            }
        }
        return new int[]{min,max};
    }
}