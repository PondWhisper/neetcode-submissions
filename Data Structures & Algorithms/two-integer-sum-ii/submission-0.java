class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int lastPointer=numbers.length-1;
        int primePointer=0;
        while(lastPointer>primePointer){
           if(numbers[lastPointer]+numbers[primePointer]>target){
               lastPointer--;
           }else if(numbers[lastPointer]+numbers[primePointer]<target){
              primePointer++;
            }else{
               return new int[]{primePointer+1, lastPointer+1};
           }
        }
        return new int[]{};
    }
}
