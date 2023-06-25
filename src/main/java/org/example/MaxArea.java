package org.example;

/**
 * Container With Most Water
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 */
public class MaxArea {

    public int maxArea(int[] height) {

        int maxArea = 0;
        int len = height.length;
        if (len < 2)
            return maxArea;

        int i = 0;
        int j = len - 1;

        while (i <= j) {

            int b = height[i];
            if (b > height[j]) {
                b = height[j];

            }

            if (b * (j - i) > maxArea)
                maxArea = b * (j - i);

            if (height[i] < height[j])
                i++;
            else
                j--;


        }


        return maxArea;

    }

    public static void main(String[] args) {

        int[] height = {1,8,6,2,5,4,8,3,7};
        MaxArea maxArea = new MaxArea();
        System.out.println(maxArea.maxArea(height));


    }
}
