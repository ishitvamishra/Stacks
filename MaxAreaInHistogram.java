package Stacks;
import java.util.*;
public class MaxAreaInHistogram {
    public static void maxArea(int arr[]){
        int maxArea = 0;
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length]; 
        //nsr
        Stack<Integer> s = new Stack<>();
        for(int i =arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }

            if(s.isEmpty()){
                nsr[i] = arr.length;
            }

            else{
                nsr[i] = s.peek();
            }

            s.push(i);
        }

        //nsl

        s= new Stack<>();
        for(int i =0;i<arr.length;i++){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }

            if(s.isEmpty()){
                nsl[i] = -1;
            }

            else{
                nsl[i] = s.peek();
            }

            s.push(i);
        }

        //current area
        for(int i =0;i<arr.length;i++){
            int height= arr[i];
            int width=  nsr[i] - nsl[i] - 1;
            int currArea = height* width;
            maxArea = Math.max(currArea , maxArea );
        }
        System.out.println("Max area in histogram = "+ maxArea);
    }
    public static void main(String[] args) {
        int arr[]= {2,1,5,6,2,3};
        maxArea(arr);
    }
}


/*
 * import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            // For the last index, assume height = 0 (forces clearing stack)
            int currHeight = (i == n) ? 0 : heights[i];

            // Pop until current bar is taller than top of stack
            while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }
                int area = height * width;
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }

        return maxArea;
    }
}

 */