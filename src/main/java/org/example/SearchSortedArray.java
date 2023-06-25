package org.example;

/**
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 *
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 */
public class SearchSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int[] vals = new int[]{-1, -1};
        if(nums.length ==0) return vals;

        int start =0;
        int end = nums.length-1;
        return search(start, end, nums, target, vals);
    }
    private int[] search(int start, int end, int[] nums, int target, int[] vals) {


        if(start == end) {
            if(target == nums[start]) {
                vals[0] = start;
                vals[1] = start;
            }
            return vals;
        }


        int mid =(start + end)/2;
        if(end-start ==1 )
        {

            if(target == nums[start] && target == nums[end]) {
                vals[0]= start;
                vals[1] = end;

            }
            else if(target == nums[start])
            {
                vals[0]= start;
                vals[1]= start;
            }
            else if(target == nums[end]) {
                vals[0]= end;
                vals[1] = end;
            }
            return vals;
        }
        if(target < nums[mid] && end > 1)
        {
            return search(start, mid, nums, target, vals);

        } else if(target > nums[mid] && end  > 1)
        {
            return search(mid, end, nums, target, vals);
        }
        else if(target > nums[end]) {
            return vals;
        }
        else if(target == nums[mid]){

            vals[0] = mid;
            vals[1] = mid;
            for(int j=mid; j >= start && nums[j]== target; j--) {
                vals[0] =j;

            }
            for(int j=mid; j <=end && nums[j]== target; j++) {
                vals[1] =j;

            }


        }
        return vals;



    }

    public static void main(String[] args) {
        int[] nums = new int[] {5,7,7,8,8,10};
        int target =6;
        SearchSortedArray obj = new SearchSortedArray();

        int[] results = obj.searchRange(nums, target);
        for(int i : results) {
            System.out.println(i);
        }
    }
}
