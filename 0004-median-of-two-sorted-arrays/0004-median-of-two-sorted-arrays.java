class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        int total=a.length+b.length;
        if(a.length==0&&b.length==0)return 0.0;
       if (total % 2 == 1) {
            return findKthElement(a, b, total / 2 + 1);
        } else {
            double first = findKthElement(a, b, total / 2);
            double second = findKthElement(a, b, total / 2 + 1);
            return (first + second) / 2.0;
        }
    }
   public int findKthElement(int[] a, int[] b, int k) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        if (a.length > 0) {
            low = Math.min(low, a[0]);
            high = Math.max(high, a[a.length - 1]);
        }
        if (b.length > 0) {
            low = Math.min(low, b[0]);
            high = Math.max(high, b[b.length - 1]);
        }

        int ans = low;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = countLessOrEqual(a, mid) + countLessOrEqual(b, mid);

            if (count >= k) {
                ans = mid;
                high = mid - 1; 
            } else {
                low = mid + 1;  
            }
        }
        return ans;
    }
    public int countLessOrEqual(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}