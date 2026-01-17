package Array;
/*
Container With Most Water  (This is a classic two-pointer problem.)
-------------------------------------------------------------------
You are given an integer array height of length n.
There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.

Notice that you may not slant the container.
 */

/*
💡Key Idea (Two Pointers)
--------------------------
Start with two pointers:

left at the beginning
right at the end

The water area between two lines is: Area of rectangle = l * b

area = min(height[left], height[right]) * (right - left)

The width is fixed by the pointers, so to possibly get a larger area:

-Move the pointer with the smaller height inward
-Moving the taller one cannot increase the area
 */

public class Container_With_Most_Water {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            maxArea = Math.max(maxArea, h * w);

            // Move the pointer with the smaller height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
