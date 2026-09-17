class Solution {
    public int[] maxSlidingWindow(int[] a, int k) {
        int n=a.length;
        Deque<Integer> dq=new ArrayDeque<>();
        int[] b=new int[n-k+1];
        for(int i=0;i<k;i++){
            while(!dq.isEmpty()&&dq.peekLast()<a[i]){
                dq.pollLast();
            }
            dq.offerLast(a[i]);
        }
        b[0]=dq.peekFirst();
        int j=1;
        for(int i=k;i<n;i++){
            if(a[i-k]==dq.peekFirst()){
                dq.pollFirst();
            }
            while(!dq.isEmpty()&&dq.peekLast()<a[i]){
                dq.pollLast();
            }
            dq.offerLast(a[i]);
            b[j++]=dq.peekFirst();
        }
        return b;
    }
}