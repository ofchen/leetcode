package LeetCode.easy;

import java.util.Hashtable;
import java.util.Map;

/*Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
Example:
	Given nums = [2, 7, 11, 15], target = 9,
	Because nums[0] + nums[1] = 2 + 7 = 9,
	return [0, 1].
 
 1.��������
 	ʱ�临�Ӷ�n^2,�ռ临�Ӷ�n
 2.HashTable
 	ʱ�临�Ӷ�n,�ռ临�Ӷ�n
 3.HashTable �߽�����ж�
 	ʱ�临�Ӷ�n,�ռ临�Ӷ�n
 */

public class TwoSum {
	/*
	public static int[] twoSum(int[] nums, int target) {
        int len = nums.length;             
        
        for (int i = 0; i < len; i++)
        	for (int j = i + 1; j < len; j++)
        		if(nums[i] + nums[j] == target){
        			if(i != j){
        				return new int[]{i, j};
        			}
        		}	
        
        throw new IllegalArgumentException("No two sum solution");
    }
	*/
	
	/*
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> hashTable = new Hashtable<Integer, Integer>();
		for (int i = 0; i < nums.length; i++){
			hashTable.put(nums[i], i);
		}
		for (int i = 0; i < nums.length; i++){
			int com = target - nums[i];
			if (hashTable.containsKey(com) && hashTable.get(com) != i)
				return new int[]{i, hashTable.get(com)};
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	*/
	
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> hashTable = new Hashtable<Integer, Integer>();
		for (int i = 0; i < nums.length; i++){
			hashTable.put(nums[i], i);
			int com = target - nums[i];
			if (hashTable.containsKey(com) && hashTable.get(com) != i)
				return new int[]{hashTable.get(com), i};			
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
	public static void main(String args[]){
		int[] nums = {2, 7, 11, 16, 20, 4};
		int target = 9;
		//long startTime = System.currentTimeMillis();
		int[] result = twoSum(nums,target);
		//long endTime = System.currentTimeMillis();
		
		System.out.println("result="+ result[0]+" "+result[1]);
		//System.out.println("��������ʱ�䣺" + (endTime - startTime) + "ms");//��������ʱ��϶̣�<1ms
	}
}
