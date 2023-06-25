package org.example;

/**
 * There is an integer array nums sorted in ascending order (with distinct values).
 *
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 *
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {

        //Input: nums = [4,5,6,7,0,1,2], target = 3

        int length =nums.length;
        if(target >= nums[0]) {
            for(int i= 0 ;i< length && target >= nums[i];i++) {
                if(target == nums[i])
                    return i;
            }
        }
        else {
            for(int i= length -1 ;i >=0 && target <= nums[i];i--) {
                if(target == nums[i])
                    return i;
            }
        }

        return -1;




    }

    public static void main(String[] args) {
        int[] nums = {3,1};
        int target = 3;
        System.out.println(SearchInRotatedSortedArray.search(nums, target));
    }
}
