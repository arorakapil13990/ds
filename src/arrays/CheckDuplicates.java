package arrays;
// https://leetcode.com/problems/contains-duplicate/description/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CheckDuplicates {

    public boolean containsDuplicate(int[] nums) {
/*
        Map<Integer, Integer> map = new HashMap<>();

        int i;
        for(i =0;i< nums.length; i++){
            if(map.containsKey(nums[i])){
                return true;
            }
            map.put(nums[i],i);

        return false; */
        Set<Integer> set = new HashSet<>();
        for (Integer x : nums) {
            if (set.contains(x)) {
                return true;
            }
            set.add(x);
        }
        return false;
    }
}