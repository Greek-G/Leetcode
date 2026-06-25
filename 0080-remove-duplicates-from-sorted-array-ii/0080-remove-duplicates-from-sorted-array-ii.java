class Solution {
    public int removeDuplicates(int[] nums) {
        int slow=2;
        for(int fast=2;fast<nums.length;fast++){
            if(nums[slow-2]!=nums[fast]){
                nums[slow]=nums[fast];
                slow++;
            }
        }
        return slow;
    }
}