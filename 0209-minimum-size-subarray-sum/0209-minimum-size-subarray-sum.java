class Solution {
    public int minSubArrayLen(int k, int[] a) {
        int ans=Integer.MAX_VALUE;
        if(a.length==1&&a[0]>=k){
    return 1;
        }else if(a.length==1&&a[0]<k){
            return 0;
        }
        int j=0,sum=0;
       for(int i=0;i<a.length;i++){
        sum+=a[i];
          while(sum>=k){
            ans=Math.min(ans,i-j+1);
            sum-=a[j];
            j++;
          }
       }
       int cnt=0;
       cnt=(ans==Integer.MAX_VALUE)?0:ans;
       return cnt;
    }
    }
    