class Solution {
    public int maximumRobots(int[] a, int[] b, long bud) {
        //max(a)+k*sum(b)
        
        int l=0,h=a.length;
        int ans=0;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(Solve(a,b,bud,mid)){
             ans=Math.max(ans,mid);
             l=mid+1;
            }else{
                h=mid-1;
            }
        }
        return ans;
    }
    public static boolean Solve(int[] a,int[] b,long bud,int k){
        long sum=0;
        int n=a.length;
        Deque<Integer> dq=new ArrayDeque<>();
        for(int i=0;i<k;i++){
            sum+=b[i];
            while(!dq.isEmpty()&&dq.peekLast()<a[i]){
                dq.pollLast();
            }
            dq.offerLast(a[i]);
        }
        long ans=0;
       ans=(!dq.isEmpty())?dq.peekFirst()+sum*k:sum*k;
        if(ans<=bud)return true;
        for(int i=k;i<n;i++){
            sum-=b[i-k];
            if(dq.peekFirst()==a[i-k]){
                dq.pollFirst();
            }
            while(!dq.isEmpty()&&dq.peekLast()<a[i]){
                dq.pollLast();
            }
            dq.offerLast(a[i]);
            sum+=b[i];
            ans=dq.peekFirst()+sum*k;
            if(ans<=bud)return true;
        }
        return false;
    }
}