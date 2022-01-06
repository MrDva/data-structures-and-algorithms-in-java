package edu.czb.datastructures.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author: 陈泽彬
 * @date: 2022/1/6 8:55
 * @description:
 */
public class Solution {
    /**
     * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
     * */
    public static boolean containsDuplicate(int[] nums) {
        //18 ms	73.8 MB
        Map<Integer,Integer> map=new HashMap<>();
        for (int num : nums) {
            if (map.get(num) != null) {
                return true;
            } else {
                map.put(num, 1);
            }
        }
        return false;
    }

    /**
     *Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
     *  */
    public static int maxSubArray(int[] nums) {
        //3 ms	90.1 MB
        int maxSum=nums[0];
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
            if(sum>maxSum){
                maxSum=sum;
            }
            if(sum<0){
                sum=0;
            }
        }
        return maxSum;
    }
    /**
     * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
     *
     * You must write an algorithm with O(log n) runtime complexity*/
    public static int search(int[] nums, int target) {
        //Time Limit Exceeded
        int left=0;
        int right=nums.length;
        //maybe overflow
        int middle=(left+right)/2;
        while (left<=right){
            if(target==nums[middle]){
                return middle;
            }else if(target<nums[middle]){
                right=middle;
                middle=(left+right)/2;
            }else if(target>nums[middle]){
                left=middle;
                middle=(left+right)/2;
            }
        }
        return -1;
    }
    public static int search1(int[] nums, int target) {
        //0 ms	51.8 MB
        int left=0;
        int right=nums.length-1;
        int middle;
        while (left<=right){
            //maybe overflow
            //middle=(left+right)/2;
            //use or middle=left +((right-left)>>1)
            middle=left+(right-left)/2;
            if(target==nums[middle]) {
                return middle;
            }
            if(target<nums[middle]){
                right=middle-1;
            }else{
                left=middle+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer max=100000000;
        int[] test=new int[max];

        for(int i=0;i<test.length;i++){
            test[i]=new Random().nextInt(1000000000);
        }
        test=Arrays.stream(test).sorted().toArray();
        /*for (Integer integer:test){
            System.out.print(integer+"  ");
        }*/
        System.out.println("");
        long startTime=System.currentTimeMillis();
        System.out.println(search(test,new Random().nextInt(100000000)));
        long endTime=System.currentTimeMillis();
        System.out.println(((endTime - startTime)) + "ms");
    }
}
