class Solution {
    public int countNegatives(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int ans=0;
        for(int i=0;i<n;i++){
        int l=0,h=m-1,c=0;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(grid[i][mid]<0)
            {
             int idx=mid;
             c=Math.max(c,m-idx);
             h=mid-1;
            }else{
             l=mid+1;
            }
        }
        ans+=c;
        }
        return ans;
    }
}