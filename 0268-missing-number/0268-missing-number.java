class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        HashSet<Integer> hs=new HashSet<>();
        int k=0;
        for(int i=0;i<nums.length;i++){
            hs.add(nums[i]);
        }
        for(int i=0;i<=nums.length;i++){
            if(hs.contains(i)){
              continue;
            }
            else
            {
              k=i;
              break;
            }
        }
         return k;
    }
}