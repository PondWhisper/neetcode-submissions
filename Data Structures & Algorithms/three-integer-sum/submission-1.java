
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int lastPointer=nums.length-1;
            int primePointer=i+1;
            int target= -nums[i];
            while(lastPointer>primePointer){
                int lastValue=nums[lastPointer];
                int primeValue=nums[primePointer];
                int currSum=lastValue+primeValue;
                if(currSum>target){
                    lastPointer--;
                }else if(currSum<target){
                    primePointer++;
                }else{
                    List<Integer> currList=new ArrayList<>();
                    currList.add(nums[i]  );
                    currList.add(primeValue);
                    currList.add(lastValue);
                    if (!list.contains(currList)) {
                        list.add(currList);
                    }
                    lastPointer--;
                    primePointer++;
                }
            }
        }
        return list;
    }
}
