package Demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Solution {

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> arr = new ArrayList<List<Integer>>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		
		//创建二叉树
		ListNode root = new ListNode(null); //初始化首个节点
		ArrayList<Integer> tempArr = new ArrayList<Integer>();
	    initRoot(root, candidates, 0, target, arr, tempArr); //构建树
	    
	    //去重
	    for(int i=0; i<arr.size(); i++){
	        boolean hasSame = false;
	        for(int j=0; j<res.size(); j++){
	            if(join(arr.get(i)).equals(join(res.get(j))) ){
	                hasSame = true;
	                break;
	            }
	        }
	        if(!hasSame){
	            res.add(arr.get(i));
	        }
	    }
		
	    return res;
	}
	
	private static String join(List<Integer> list){
	    String s = "";
	    for (Integer str : list) {
	        s+=str+",";
	    }
	    return s;
	}
	
	@SuppressWarnings("unchecked")
	private static void initRoot(ListNode node, int[] nums, int i,
			int target, List<List<Integer>> arr, ArrayList<Integer> tempArr) {

		if(node.val!=null){ //非空节点才需要计算tempArr里的和
	        tempArr.add(node.val);
	        if(tempArr.size()>0 ){
	            int r = add(tempArr, target); //判断和
	            if(r==0){ //相等 不需要往下遍历 存入结果集 return
	                arr.add(tempArr);
	                return;
	            }
	            if(r>0){return; } //大于0 直接return
	        }
	    }
	    if(i==nums.length){return; }

	    //ArrayList<Integer> tempArrList = new ArrayList<Integer>();
	    //Collections.copy(tempArrList, tempArr);
	    		
	    node.left = new ListNode(nums[i]);
	    initRoot(node.left, nums, i+1, target, arr, (ArrayList<Integer>)tempArr.clone());

	    node.right = new ListNode(null);
	    initRoot(node.right, nums, i+1, target, arr, (ArrayList<Integer>)tempArr.clone());
			
	}

	static class ListNode{
		ListNode left = null;
		ListNode right = null;
		Integer val;
		public ListNode(Integer val){
			this.val = val;
		    this.left = null;
		    this.right = null;
		}
	}
	
	//求和
	private static int add(List<Integer> arr, int target){
	    int sum=0;
	    for(int i=0; i<arr.size(); i++){ sum += arr.get(i); }
	    if(sum==target){return 0; }
	    if(sum<target){ return -1; }
	    return 1;
	}
	
	public static void main(String[] args) {
		int[] arr = {14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12};
		int target = 27;
		combinationSum2(arr, target);
	}
	
}
