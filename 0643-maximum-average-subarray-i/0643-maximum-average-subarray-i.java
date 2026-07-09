class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum=0,low=0;
        int high=k;
        for(int i=0;i<k;i++){
            sum=sum+nums[i];
        }
        double max=sum;
        while(high<nums.length){
            sum=sum-nums[low];
            sum=sum+nums[high];

            low++;
            high++;

        max=Math.max(max, sum);
        }
        return max/k;
    }
}